package cn.sioo.thread;

import cn.sioo.pojo.BaseEntity;
import cn.sioo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public  class BaseThread<T extends BaseEntity> implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(BaseThread.class);

    public BaseService baseService;

    public T t;

    private String type;


    public BaseThread(BaseService baseService, T t) {
        this.baseService = baseService;
        this.t = t;
    }


    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            int count31 = baseService.selectCount31(null);
            int count21 = baseService.selectCount21(null);
            int size = 3000;
            int part = count21 / size;
            for (int i = 0; i <= part; i++) {
                List<T> list = baseService.selectListLimit(t, count31, size);
                if (list.size() > 0) {
                    baseService.insertList(list);
                } else {
                    break;
                }
                count31 = count31 + size;
            }
            LOGGER.info("{} 备份,耗时:{}", t.getClass().getName(), (System.currentTimeMillis() - begin));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
