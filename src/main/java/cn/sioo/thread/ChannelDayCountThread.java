package cn.sioo.thread;

import cn.sioo.pojo.ChannelDayCount;
import cn.sioo.service.ChannelDayCountService;
import cn.sioo.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/8.
 */
public class ChannelDayCountThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(ChannelDayCountThread.class);

    public ChannelDayCountService channelDayCountService;


    public ChannelDayCountThread(ChannelDayCountService channelDayCountService) {
        this.channelDayCountService = channelDayCountService;
    }


    public List<ChannelDayCount> getDiffrentAdd(List<ChannelDayCount> list21, List<ChannelDayCount> list31) {
        List<ChannelDayCount> diff = new ArrayList<>();
        Map<String, ChannelDayCount> map = new HashMap<>();
        for (ChannelDayCount channelDayCount : list31) {
            map.put(channelDayCount.getChannelId() + "," + channelDayCount.getCreateTime(), channelDayCount);
        }
        for (ChannelDayCount channelDayCount : list21) {
            if (!(map.get(channelDayCount.getChannelId() + "," + channelDayCount.getCreateTime()) != null
                    && map.get(channelDayCount.getChannelId() + "," + channelDayCount.getCreateTime()).equals(channelDayCount))) {
                diff.add(channelDayCount);
            }
        }
        return diff;
    }


    @Override
    public void run() {
        try {
            int time = DateUtils.getDay();
            ChannelDayCount ChannelDayCount = new ChannelDayCount();
            ChannelDayCount.setCreateTime(time - 10);
            List<ChannelDayCount> list21 = channelDayCountService.selectGreateCreateTime21(ChannelDayCount);
            List<ChannelDayCount> list31 = channelDayCountService.selectGreateCreateTime31(ChannelDayCount);
            List<ChannelDayCount> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                LOGGER.info("ChannelDayCount,数量:{}", diffrentAdd.size());
                for (ChannelDayCount channelDayCount : diffrentAdd) {
                    ChannelDayCount dayCount = new ChannelDayCount();
                    dayCount.setChannelId(channelDayCount.getChannelId());
                    dayCount.setCreateTime(channelDayCount.getCreateTime());
                    channelDayCountService.delete(dayCount);
                }
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<ChannelDayCount> subList = diffrentAdd.subList(0, limitSize);
                        channelDayCountService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        channelDayCountService.insertList(diffrentAdd);
                    }
                } else {
                    channelDayCountService.insertList(diffrentAdd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
