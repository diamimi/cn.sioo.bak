package cn.sioo.pojo;

import javax.persistence.Table;

/**
 * Created by morrigan on 2017/6/12.
 */
@Table(name="sms_user_history_170101")
public class SmsUserHistory extends BaseEntity{

    private Integer hisid;

    private Integer uid;

    public Integer getHisid() {
        return hisid;
    }

    public void setHisid(Integer hisid) {
        this.hisid = hisid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
