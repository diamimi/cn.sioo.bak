package cn.sioo.thread;

import cn.sioo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by morrigan on 2017/6/3.
 */
public  class BaseThread<T> implements Runnable{

    public static Logger LOGGER = LoggerFactory.getLogger(BaseThread.class);

    public BaseService baseService;

    public T t;

    public BaseThread(BaseService baseService,T t) {

        this.baseService=baseService;
        this.t=t;
    }

    public void run() {
        /*try {
            long begin=System.currentTimeMillis();
            int count21=baseService.findCount21();
            int count31=baseService.findCount31();
            int size=10;
            int part=count21/size;
            for(int i=0;i<=part;i++){
                List<T> list = baseService.findList(t,1+(count31/size), size);
                if(list.size()>0){
                    baseService.insertList(list);
                }else {
                    break;
                }
                count31=count31+1;
            }
            LOGGER.info("备份耗时:{},{}",(System.currentTimeMillis()-begin),t.getClass().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
