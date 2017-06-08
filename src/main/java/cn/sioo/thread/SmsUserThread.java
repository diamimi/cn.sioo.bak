package cn.sioo.thread;

import cn.sioo.pojo.SmsUser;
import cn.sioo.service.SmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by morrigan on 2017/6/8.
 */
public class SmsUserThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserThread.class);

    public SmsUserService smsUserService;


    public SmsUserThread(SmsUserService smsUserService) {
        this.smsUserService = smsUserService;
    }

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
    }
}
