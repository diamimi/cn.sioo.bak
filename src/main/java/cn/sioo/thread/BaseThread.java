package cn.sioo.thread;

import cn.sioo.pojo.BaseEntity;
import cn.sioo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public  class BaseThread<T extends BaseEntity> implements Runnable{

    public static Logger LOGGER = LoggerFactory.getLogger(BaseThread.class);

    public BaseService baseService;

    public T t;

    private String type;


    public BaseThread(BaseService baseService,T t,String type) {
        this.baseService=baseService;
        this.t=t;
        this.type=type;
    }

    @Override
    public void run() {
        try {
            long begin=System.currentTimeMillis();
            int count21=baseService.selectCount21(null);
            int count31=baseService.selectCount31(null);
            int size=2000;
            int part=count21/size;
            for(int i=0;i<=part;i++){
                if(count31<count21){
                    List<T> list = baseService.selectListLimit(t,type,count31, size);
                    if(list.size()>0){
                            baseService.insertList(list);
                    }else {
                        break;
                    }
                    count31=count31+size;
                }else {
                    break;
                }
            }
            LOGGER.info("备份耗时:{},{}",(System.currentTimeMillis()-begin),t.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
