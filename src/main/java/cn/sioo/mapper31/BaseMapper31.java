package cn.sioo.mapper31;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface BaseMapper31<T> {

    /**
     * 插入31
     *
     * @param t
     */
    void insertBatch(List<T> t);

    /**
     * 查询31数量
     *
     * @return
     */
    int findCount31();


}
