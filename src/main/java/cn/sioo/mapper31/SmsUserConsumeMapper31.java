package cn.sioo.mapper31;

import cn.sioo.pojo.SmsUserConsume;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface SmsUserConsumeMapper31 extends BaseMapper31<SmsUserConsume> {

    int selectConsumeCount31(SmsUserConsume smsUserConsume);
}
