package cn.sioo.mapper31;

import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

/**
 * Created by morrigan on 2017/6/5.
 */
public interface BaseMapper31<T> extends Mapper<T> {

    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);
}
