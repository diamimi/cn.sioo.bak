package cn.sioo.mapper21;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface BaseMapper21<T> extends Mapper<T> {

    List<T> findList(T t, int index, int size);

}
