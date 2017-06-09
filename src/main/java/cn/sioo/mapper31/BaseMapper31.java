package cn.sioo.mapper31;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by morrigan on 2017/6/5.
 */
public interface BaseMapper31<T> extends Mapper<T> {

    @InsertProvider(type = BaseMapper31Provider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);

    @DeleteProvider(type = BaseMapper31Provider.class, method = "dynamicSQL")
    void delByIds(@Param("list") List<Integer> ids);

    @DeleteProvider(type = BaseMapper31Provider.class, method = "dynamicSQL")
    void delByUids(@Param("list") List<Integer> ids);
}
