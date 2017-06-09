package cn.sioo.thread;

import cn.sioo.pojo.SmsUserConsume;
import cn.sioo.service.SmsUserConsumeService;
import cn.sioo.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by morrigan on 2017/6/8.
 */
public class SmsUserConsumeNowThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserConsumeNowThread.class);

    public SmsUserConsumeService smsUserConsumeService;



    public SmsUserConsumeNowThread(SmsUserConsumeService smsUserConsumeService) {
        this.smsUserConsumeService = smsUserConsumeService;
    }


    public List<SmsUserConsume> getDiffrentAdd(List<SmsUserConsume> list21, List<SmsUserConsume> list31) {
        List<SmsUserConsume> diff = new ArrayList<>();
        Map<Integer, SmsUserConsume> map = new HashMap<>();
        for (SmsUserConsume smsUserConsume : list31) {
            map.put(smsUserConsume.getId(), smsUserConsume);
        }
        for (SmsUserConsume smsUserConsume : list21) {
            if (!(map.get(smsUserConsume.getId()) != null && map.get(smsUserConsume.getId()).equals(smsUserConsume))) {
                diff.add(smsUserConsume);
            }

        }
        return diff;
    }

    public void bak(int time) {
        try {
            long begin = System.currentTimeMillis();
            SmsUserConsume smsUserConsume = new SmsUserConsume();
            smsUserConsume.setDate(time);
            List<SmsUserConsume> list21 = smsUserConsumeService.selectList21(smsUserConsume);
            List<SmsUserConsume> list31 = smsUserConsumeService.selectList31(smsUserConsume);
            List<SmsUserConsume> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                LOGGER.info("SmsUserSignstoreNow {},数量:{}",time,diffrentAdd.size());
                List<Integer> ids = new ArrayList<>();
                for (SmsUserConsume smsUser : diffrentAdd) {
                    ids.add(smsUser.getId());
                }
                smsUserConsumeService.delByIds(ids);
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsUserConsume> subList = diffrentAdd.subList(0, limitSize);
                        smsUserConsumeService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        smsUserConsumeService.insertList(diffrentAdd);
                    }
                } else {
                    smsUserConsumeService.insertList(diffrentAdd);
                }
            }
            LOGGER.info("{} {}备份,耗时{}", "SmsUserSignstoreNow",time, (System.currentTimeMillis() - begin));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int date = DateUtils.getDay();
        bak(date);
    }
}

