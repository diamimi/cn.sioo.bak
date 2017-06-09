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
        Map<Integer, SmsUserControl> map = new HashMap<>();
        for (SmsUserControl smsUserControl : list31) {
            map.put(smsUserControl.getUid(), smsUserControl);
        }
        for (SmsUserControl smsUserConsume : list21) {
            if (!(map.get(smsUserConsume.getUid()) != null && map.get(smsUserConsume.getUid()).equals(smsUserConsume))) {
                diff.add(smsUserConsume);
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
                LOGGER.info("更新SmsUser,数量:{}",diffrentAdd.size());
                List<Integer> uids=new ArrayList<>();
                for (SmsUserControl smsUserControl : diffrentAdd) {
                    uids.add(smsUserControl.getUid());
                }
                smsUserControlService.delByUids(uids);
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

            LOGGER.info("备份耗时:{},{}", (System.currentTimeMillis() - begin), "SmsUserSignstore");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
