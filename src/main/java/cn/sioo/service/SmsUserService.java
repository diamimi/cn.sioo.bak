package cn.sioo.service;

import cn.sioo.mapper21.SmsUserMapper21;
import cn.sioo.mapper31.SmsUserMapper31;
import cn.sioo.pojo.SmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by morrigan on 2017/6/1.
 */
@Service
public class SmsUserService implements BaseService<SmsUser> {

    @Autowired
    private SmsUserMapper21 smsUserMapper21;

    @Autowired
    private SmsUserMapper31 smsUserMapper31;

    public void insertBatch(List<SmsUser> smsUsers) {
        smsUserMapper31.insertBatch(smsUsers);
    }

    public int findCount31() {
        return smsUserMapper31.findCount31();
    }

    public int findCount21() {
        return smsUserMapper21.findCount21();
    }

    public List<SmsUser> findList(int count1, int size) {
        return smsUserMapper21.findList(count1,size);
    }
}
