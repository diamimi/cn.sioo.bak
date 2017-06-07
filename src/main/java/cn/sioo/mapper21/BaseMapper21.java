package cn.sioo.mapper21;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface BaseMapper21<T> extends Mapper<T> {

    @SelectProvider(type = BaseMapper21Provider.class, method = "dynamicSQL")
    List<T> selectListLimit(@Param("entity")T t, @Param("index") int index,@Param("size") int size);

}
