package cn.sioo.thread;

import cn.sioo.pojo.SmsUserControl;
import cn.sioo.service.SmsUserControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/3.
 */
public class SmsUserControlThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserControlThread.class);

    public SmsUserControlService smsUserControlService;


    public SmsUserControlThread(SmsUserControlService smsUserControlService) {
        this.smsUserControlService = smsUserControlService;
    }

    public List<SmsUserControl> getDiffrentAdd(List<SmsUserControl> list21, List<SmsUserControl> list31) {
        List<SmsUserControl> diff = new ArrayList<>();
        List<SmsUserControl> maxList = list21;
        List<SmsUserControl> minList = list31;
        if (list31.size() > list21.size()) {
            maxList = list31;
            minList = list21;
        }
        Map<SmsUserControl, Integer> map = new HashMap<>(maxList.size());
        for (SmsUserControl smsUserControl : maxList) {
            map.put(smsUserControl, 1);
        }
        for (SmsUserControl smsUserControl : minList) {
            if (map.get(smsUserControl) != null) {
                map.put(smsUserControl, 2);
                continue;
            }
            diff.add(smsUserControl);
        }
        for (Map.Entry<SmsUserControl, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && list21.contains(entry.getKey())) {
                diff.add(entry.getKey());
            }
        }
        return diff;

    }


    public List<Integer> getDiffrentDel(List<SmsUserControl> list21, List<SmsUserControl> list31) {
        List<Integer> diff = new ArrayList<>();
        List<SmsUserControl> maxList = list21;
        List<SmsUserControl> minList = list31;
        if (list31.size() > list21.size()) {
            maxList = list31;
            minList = list21;
        }
        Map<Integer, Integer> map = new HashMap<>(maxList.size());
        for (SmsUserControl smsUserControl : maxList) {
            map.put(smsUserControl.getUid(), 1);
        }
        for (SmsUserControl smsUserControl : minList) {
            if (map.get(smsUserControl.getUid()) != null) {
                map.put(smsUserControl.getUid(), 2);
                continue;
            }
            diff.add(smsUserControl.getUid());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && list31.contains(entry.getKey())) {
                diff.add(entry.getKey());
            }
        }
        return diff;

    }


    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            List<SmsUserControl> list21 = smsUserControlService.selectList21(null);
            List<SmsUserControl> list31 = smsUserControlService.selectList31(null);
            List<SmsUserControl> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsUserControl> subList = diffrentAdd.subList(0, limitSize);
                        smsUserControlService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        smsUserControlService.insertList(diffrentAdd);
                    }
                } else {
                    smsUserControlService.insertList(diffrentAdd);
                }
            }
            smsUserControlService.insertList(diffrentAdd);
            List<Integer> diffrentDel = getDiffrentDel(list21, list31);
            if (diffrentDel.size() > 0) {
                smsUserControlService.delByIds(diffrentDel);
            }
            LOGGER.info("备份耗时:{},{}", (System.currentTimeMillis() - begin), "SmsUserSignstore");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
