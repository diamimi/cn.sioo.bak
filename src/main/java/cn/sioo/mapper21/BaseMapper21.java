package cn.sioo.mapper21;

import org.apache.ibatis.annotations.Param;

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
     * @param index
     * @param size
     * @return
     */
    List<T> findList(@Param("index") int index, @Param("size") int size);
}
