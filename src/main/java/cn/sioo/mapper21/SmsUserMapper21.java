package cn.sioo.mapper21;

import cn.sioo.pojo.SmsUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by morrigan on 2017/6/1.
 */
@Repository
public interface SmsUserMapper21 extends BaseMapper21<SmsUser>{

    int findCount21();

    List<SmsUser> findList(@Param("index") int index,@Param("size") int size);
}
