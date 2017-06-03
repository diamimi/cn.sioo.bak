package cn.sioo.thread;

import cn.sioo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public  class BaseThread<T> implements Runnable{

    public static Logger LOGGER = LoggerFactory.getLogger(BaseThread.class);

    public BaseService baseService;

    public BaseThread(BaseService baseService) {

        this.baseService=baseService;
    }

    @Override
    public void run() {
        long begin=System.currentTimeMillis();
        int count31=baseService.findCount31();
        int count21=baseService.findCount21();
        int size=2000;
        int part=count21/size;
        for(int i=0;i<=part;i++){
            List<T> list = baseService.findList(count31, size);
            if(list.size()>0){
                baseService.insertBatch(list);
            }else {
                break;
            }
            count31=count31+size;
        }
        LOGGER.info("备份SmsUserConsumer,耗时:{}",(System.currentTimeMillis()-begin));
    }
}
