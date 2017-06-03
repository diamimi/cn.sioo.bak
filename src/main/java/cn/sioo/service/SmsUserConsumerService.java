package cn.sioo.service;

import cn.sioo.mapper21.SmsUserConsumerMapper21;
import cn.sioo.mapper31.SmsUserConsumerMapper31;
import cn.sioo.pojo.SmsUserConsume;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public class SmsUserConsumerService implements BaseService<SmsUserConsume> {

    @Autowired
    private SmsUserConsumerMapper31 smsUserConsumerMapper31;

    @Autowired
    private SmsUserConsumerMapper21 smsUserConsumerMapper21;

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
