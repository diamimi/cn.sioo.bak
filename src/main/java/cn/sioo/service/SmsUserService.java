package cn.sioo.service;

import cn.sioo.mapper31.SmsUserMapper31;
import cn.sioo.pojo.SmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by morrigan on 2017/6/1.
 */
@Service
public class SmsUserService extends BaseService<SmsUser> {

    @Autowired
    private SmsUserMapper31 smsUserMapper31;

        public void deleteIds(List<Integer> list){
            smsUserMapper31.deleteIds(list);
        }
}
