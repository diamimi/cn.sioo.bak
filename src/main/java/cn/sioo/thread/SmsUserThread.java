package cn.sioo.thread;

import cn.sioo.pojo.SmsUser;
import cn.sioo.service.BaseService;

import java.util.List;

/**
 * Created by morrigan on 2017/6/5.
 */
public class SmsUserThread extends BaseThread<SmsUser> implements Runnable {


    public SmsUserThread(BaseService baseService) {
        super(baseService);
    }

    @Override
    public void run() {
        try {
            long begin=System.currentTimeMillis();
            int count21=baseService.selectCount21(null);
            int count31=baseService.selectCount31(null);
            int size=500;
            int part=count21/size;
            int index=count31/size+1;
            for(int i=0;i<=part;i++){
                if(count31<count21){
                    List<SmsUser> list = baseService.findList(SmsUser.class,index, size);
                    if(list.size()>0){
                        baseService.insertList(list);
                    }else {
                        break;
                    }
                    count31=count31+1;
                    index++;
                }
                LOGGER.info("备份耗时:{},{}",(System.currentTimeMillis()-begin),"SmsUser");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
