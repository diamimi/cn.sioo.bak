package cn.sioo.mapper21;

import cn.sioo.pojo.SmsUserConsume;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface SmsUserConsumeMapper21 extends BaseMapper21<SmsUserConsume> {
    int selectConsumeCount21(SmsUserConsume smsUserConsume);

    List<SmsUserConsume> selectLConsumeistLimit(SmsUserConsume smsUserConsume);

}
