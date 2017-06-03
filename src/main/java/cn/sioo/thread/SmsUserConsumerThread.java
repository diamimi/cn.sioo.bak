package cn.sioo.thread;

import cn.sioo.pojo.SmsUserConsume;
import cn.sioo.service.SmsUserConsumerService;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public class SmsUserConsumerThread extends BaseThread<SmsUserConsumerService> implements Runnable{

    public SmsUserConsumerThread(SmsUserConsumerService t) {
        super(t);
    }

    @Override
    public void run() {
        long begin=System.currentTimeMillis();
        int count31=t.findCount31();
        int count21=t.findCount21();
        int size=300;
        int part=count21/size;
        for(int i=0;i<=part;i++){
            List<SmsUserConsume> smsUserConsumes = t.findList(count31, size);
            if(smsUserConsumes.size()>0){
                t.insertBatch(smsUserConsumes);
            }else {
                break;
            }
            count31=count31+size;
        }
        LOGGER.info("备份SmsUserConsumer,耗时:{}",(System.currentTimeMillis()-begin));
    }
}
