package cn.sioo.service;

import cn.sioo.mapper31.SmsUserHistoryMapper31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by morrigan on 2017/6/12.
 */
@Service
public class SmsUserHistoryService {
    @Autowired
    private SmsUserHistoryMapper31 smsUserHistoryMapper31;

    public int findId() {
        return smsUserHistoryMapper31.findId();
    }

    public int findUid(BigInteger id) {
        return  smsUserHistoryMapper31.findUid(id.intValue());
    }
}
