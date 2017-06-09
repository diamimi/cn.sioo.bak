package cn.sioo.service;

import cn.sioo.mapper21.SmsUserConsumeMapper21;
import cn.sioo.mapper31.SmsUserConsumeMapper31;
import cn.sioo.pojo.SmsUserConsume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by morrigan on 2017/6/3.
 */
@Service
public class SmsUserConsumeService extends BaseService<SmsUserConsume> {

    @Autowired
    private SmsUserConsumeMapper31 smsUserConsumeMapper31;

    @Autowired
    private SmsUserConsumeMapper21 smsUserConsumeMapper21;

    public int selectConsumeCount31(SmsUserConsume smsUserConsume){
        return smsUserConsumeMapper31.selectConsumeCount31(smsUserConsume);
    }

    public int selectConsumeCount21(SmsUserConsume smsUserConsume) {
        return smsUserConsumeMapper21.selectConsumeCount21(smsUserConsume);
    }

    public List<SmsUserConsume> selectLConsumeistLimit(SmsUserConsume smsUserConsume) {
        return smsUserConsumeMapper21.selectLConsumeistLimit(smsUserConsume);
    }


}
