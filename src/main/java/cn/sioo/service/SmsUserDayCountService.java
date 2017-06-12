package cn.sioo.service;

import cn.sioo.mapper21.SmsUserDayCountMapper21;
import cn.sioo.mapper31.SmsUserDayCountMapper31;
import cn.sioo.pojo.SmsUserDayCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by morrigan on 2017/6/1.
 */
@Service
public class SmsUserDayCountService extends BaseService<SmsUserDayCount> {

    @Autowired
    private SmsUserDayCountMapper21 smsUserDayCountMapper21;

    @Autowired
    private SmsUserDayCountMapper31 smsUserDayCountMapper31;

    public List<SmsUserDayCount> selectGreateTime21(SmsUserDayCount smsUserDayCount) {
        Example example=new Example(smsUserDayCount.getClass());
        example.createCriteria().andGreaterThan("time",smsUserDayCount.getTime());
        return smsUserDayCountMapper21.selectByExample(example);
    }

    public List<SmsUserDayCount> selectGreateTime31(SmsUserDayCount smsUserDayCount) {
        Example example=new Example(smsUserDayCount.getClass());
        example.createCriteria().andGreaterThan("time",smsUserDayCount.getTime());
        return smsUserDayCountMapper31.selectByExample(example);
    }
}
