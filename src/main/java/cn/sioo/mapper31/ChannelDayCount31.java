package cn.sioo.mapper31;

import cn.sioo.pojo.SmsUser;

import java.util.List;

/**
 * Created by morrigan on 2017/6/2.
 */
public interface ChannelDayCount31 {


    void insertBatch(List<SmsUser> smsUsers);

    void truncate();
}
