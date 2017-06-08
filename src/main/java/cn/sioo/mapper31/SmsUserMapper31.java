package cn.sioo.mapper31;

import cn.sioo.pojo.SmsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by morrigan on 2017/6/1.
 */
public interface SmsUserMapper31 extends BaseMapper31<SmsUser>  {


    void deleteIds(@Param("list") List<Integer> list);
}
