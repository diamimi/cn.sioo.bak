package cn.sioo.thread;

import cn.sioo.pojo.SmsUserConsume;
import cn.sioo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public  class BaseThread<T> implements Runnable{

    public static Logger LOGGER = LoggerFactory.getLogger(BaseThread.class);

    public BaseService t;

    public BaseThread(BaseService t) {

        this.t=t;
    }

    @Override
    public void run() {
        long begin=System.currentTimeMillis();
        int count31=t.findCount31();
        int count21=t.findCount21();
        int size=300;
        int part=count21/size;
        for(int i=0;i<=part;i++){
            List<T> list = t.findList(count31, size);
            if(list.size()>0){
                t.insertBatch(list);
            }else {
                break;
            }
            count31=count31+size;
        }
        LOGGER.info("备份SmsUserConsumer,耗时:{}",(System.currentTimeMillis()-begin));
    }
}
