package cn.sioo.thread;

import cn.sioo.pojo.SmsUserConsume;
import cn.sioo.service.SmsUserConsumeService;
import cn.sioo.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public  class SmsUserConsumeThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserConsumeThread.class);

    public SmsUserConsumeService smsUserConsumeService;




    public SmsUserConsumeThread(SmsUserConsumeService smsUserConsumeService) {
        this.smsUserConsumeService = smsUserConsumeService;
    }


    @Override
    public void run() {
        try {
            int date = DateUtils.getDay()-1;
            long begin = System.currentTimeMillis();
            SmsUserConsume smsUserConsume=new SmsUserConsume();
            smsUserConsume.setDate(date);
            int count31 = smsUserConsumeService.selectConsumeCount31(smsUserConsume);
            int count21 = smsUserConsumeService.selectConsumeCount21(smsUserConsume);
            int size = 3000;
            int part = count21 / size;
            for (int i = 0; i <= part; i++) {
                smsUserConsume.setPageIndex(count31);
                smsUserConsume.setPageSize(size);
                List<SmsUserConsume> list= smsUserConsumeService.selectLConsumeistLimit(smsUserConsume);
                if (list.size() > 0) {
                    smsUserConsumeService.insertList(list);
                } else {
                    break;
                }
                count31 = count31 + size;
            }
            LOGGER.info("{} 备份,耗时:{}", "SmsUserConsume", (System.currentTimeMillis() - begin));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
