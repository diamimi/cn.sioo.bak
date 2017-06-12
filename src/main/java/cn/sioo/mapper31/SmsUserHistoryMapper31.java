package cn.sioo.mapper31;

import cn.sioo.pojo.SmsUserHistory;

/**
 * Created by morrigan on 2017/6/3.
 */
public interface SmsUserHistoryMapper31 extends BaseMapper31<SmsUserHistory> {

    int findUid(int i);

    int findId();
}
