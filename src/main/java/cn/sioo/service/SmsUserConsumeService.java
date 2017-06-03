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
public class SmsUserConsumeService implements BaseService<SmsUserConsume> {

    @Autowired
    private SmsUserConsumeMapper31 smsUserConsumerMapper31;

    @Autowired
    private SmsUserConsumeMapper21 smsUserConsumerMapper21;

    @Override
    public void insertBatch(List<SmsUserConsume> t) {
        smsUserConsumerMapper31.insertBatch(t);
    }

    @Override
    public int findCount31() {
        return smsUserConsumerMapper31.findCount31();
    }

    @Override
    public int findCount21() {
        return smsUserConsumerMapper21.findCount21();
    }

    @Override
    public List<SmsUserConsume> findList(int index, int size) {
        return smsUserConsumerMapper21.findList(index, size);
    }
}
