package cn.sioo.thread;

import cn.sioo.pojo.SmsUserSignstore;
import cn.sioo.service.SmsUserSignstoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public class SmsUserSignstoreThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserSignstoreThread.class);

    public SmsUserSignstoreService smsUserSignstoreService;


    private String type;


    public SmsUserSignstoreThread(SmsUserSignstoreService smsUserSignstoreService, String type) {
        this.smsUserSignstoreService = smsUserSignstoreService;
        this.type = type;
    }


    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            int count21 = smsUserSignstoreService.selectCount21(null);
            int count31 = smsUserSignstoreService.selectCount31(null);
            int size = 500;
            int part = count21 / size;
            for (int i = 0; i <= part; i++) {
                if (count31 < count21) {
                    List<SmsUserSignstore> list = smsUserSignstoreService.selectListLimit(new SmsUserSignstore(), count31, size);
                    if (list.size() > 0) {
                        for (SmsUserSignstore smsUserSignstore : list) {
                            if (smsUserSignstore.getExpend().equals("794901701229886")) {
                                LOGGER.info(smsUserSignstore.toString());
                            }
                        }
                        smsUserSignstoreService.insertList(list);
                    } else {
                        break;
                    }
                    count31 = count31 + size;
                } else {
                    break;
                }
            }
            LOGGER.info("备份耗时:{},{}", (System.currentTimeMillis() - begin), "SmsUserSignstore");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
