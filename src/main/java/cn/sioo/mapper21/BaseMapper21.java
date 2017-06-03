package cn.sioo.mapper21;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface BaseMapper21<T> {


    /**
     * 查询21数量
     *
     * @return
     */
    int findCount21();

    /**
     * 查询21数据
     *
     * @param count1
     * @param size
     * @return
     */
    List<T> findList(int count1, int size);
}
