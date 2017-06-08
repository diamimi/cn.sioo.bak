package cn.sioo.thread;

import cn.sioo.pojo.SmsUser;
import cn.sioo.service.SmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/8.
 */
public class SmsUserThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserThread.class);

    public SmsUserService smsUserService;


    public SmsUserThread(SmsUserService smsUserService) {
        this.smsUserService = smsUserService;
    }



    public List<SmsUser> getDiffrentAdd(List<SmsUser> list2, List<SmsUser> list31) {
        List<SmsUser> diff = new ArrayList<>();
        List<SmsUser> maxList = list2;
        List<SmsUser> minList = list31;
        if (list31.size() > list2.size()) {
            maxList = list31;
            minList = list2;
        }
        Map<Integer, SmsUser> map = new HashMap<>(maxList.size());
        for (SmsUser smsUser : maxList) {
            map.put(smsUser.getId(), smsUser);
        }
        for (SmsUser smsUser : minList) {
            if (map.get(smsUser.getId()) != null && map.get(smsUser.getId()).equals(smsUser)) {
                smsUser.setDiff(2);
                map.put(smsUser.getId(), smsUser);
                continue;
            }
            diff.add(smsUser);
        }
        for (Map.Entry<Integer, SmsUser> entry : map.entrySet()) {
            if (entry.getValue().getDiff() ==1 ) {
                diff.add(entry.getValue());
            }
        }
        return diff;
    }


    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            List<SmsUser> list21 = smsUserService.selectList21(null);
            List<SmsUser> list31 = smsUserService.selectList31(null);
            List<SmsUser> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                List<Integer> ids=new ArrayList<>();
                for (SmsUser smsUser : diffrentAdd) {
                    ids.add(smsUser.getId());
                }
                smsUserService.delByIds(ids);
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsUser> subList = diffrentAdd.subList(0, limitSize);
                        smsUserService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        smsUserService.insertList(diffrentAdd);
                    }
                } else {
                    smsUserService.insertList(diffrentAdd);
                }
            }
            LOGGER.info("备份耗时:{},{}", (System.currentTimeMillis() - begin), "SmsUserSignstore");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            List<SmsUser> list21 = smsUserService.selectList21(null);
            smsUserService.delete();
            if (list21.size() > 0) {
                if (list21.size() > 3000) {
                    int limitSize = 3000;
                    int part = list21.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsUser> subList = list21.subList(0, limitSize);
                        smsUserService.insertList(subList);
                        list21.subList(0, limitSize).clear();
                    }
                    if (!list21.isEmpty()) {
                        smsUserService.insertList(list21);
                    }
                } else {
                    smsUserService.insertList(list21);
                }
            }
            LOGGER.info("备份耗时:{},{}", (System.currentTimeMillis() - begin), "SmsUser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
