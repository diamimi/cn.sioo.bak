package cn.sioo.thread;

import cn.sioo.pojo.SmsUser;
import cn.sioo.service.SmsUserService;

import java.util.List;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsUserThread extends BaseThread<SmsUserService> implements Runnable {

    public SmsUserThread(SmsUserService t) {
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
            List<SmsUser> smsUsers = t.findList(count31, size);
            if(smsUsers.size()>0){
                t.insertBatch(smsUsers);
            }else {
                break;
            }
            count31=count31+size;
        }
        LOGGER.info("备份SmsUser,耗时:{}",(System.currentTimeMillis()-begin));
    }
}
