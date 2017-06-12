package cn.sioo.thread;

import cn.sioo.pojo.SmsUserDayCount;
import cn.sioo.service.SmsUserDayCountService;
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
public class SmsUserDayCountThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserDayCountThread.class);

    public SmsUserDayCountService smsUserDayCountService;


    public SmsUserDayCountThread(SmsUserDayCountService smsUserDayCountService) {
        this.smsUserDayCountService = smsUserDayCountService;
    }



    public List<SmsUserDayCount> getDiffrentAdd(List<SmsUserDayCount> list21, List<SmsUserDayCount> list31) {
        List<SmsUserDayCount> diff = new ArrayList<>();
        Map<Integer, SmsUserDayCount> map = new HashMap<>();
        for (SmsUserDayCount smsUserDayCount : list31) {
            map.put(smsUserDayCount.getId(), smsUserDayCount);
        }
        for (SmsUserDayCount smsUserDayCount : list21) {
            if (!(map.get(smsUserDayCount.getId()) != null &&map.get(smsUserDayCount.getId()).equals(smsUserDayCount))) {
                diff.add(smsUserDayCount);
            }

        }
        return diff;
    }

    @Override
    public void run() {
        try {
            int date = DateUtils.getDay();
            SmsUserDayCount smsUserDayCount = new SmsUserDayCount();
            smsUserDayCount.setTime(date-10);
            List<SmsUserDayCount> list21 = smsUserDayCountService.selectGreateTime21(smsUserDayCount);
            List<SmsUserDayCount> list31 = smsUserDayCountService.selectGreateTime31(smsUserDayCount);
            List<SmsUserDayCount> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                LOGGER.info("更新SmsUser,数量:{}",diffrentAdd.size());
                List<Integer> ids=new ArrayList<>();
                for (SmsUserDayCount userDayCount : diffrentAdd) {
                    ids.add(userDayCount.getId());
                }
                smsUserDayCountService.delByIds(ids);
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsUserDayCount> subList = diffrentAdd.subList(0, limitSize);
                        smsUserDayCountService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        smsUserDayCountService.insertList(diffrentAdd);
                    }
                } else {
                    smsUserDayCountService.insertList(diffrentAdd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
