package cn.sioo.service;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface BaseService<T> {


    /**
     * 插入31
     * @param t
     */
     void insertBatch(List<T> t);

    /**
     * 查询31数量
     * @return
     */
     int findCount31()    ;

    /**
     * 查询21数量
     * @return
     */
     int findCount21();

    /**
     * 查询21数据
     * @param index
     * @param size
     * @return
     */
     List<T> findList(int index, int size);
}
