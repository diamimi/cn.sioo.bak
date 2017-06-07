package cn.sioo.pojo;

import javax.persistence.Column;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsUserSignstore extends BaseEntity {

    private Integer id;

    private Integer uid;

    private String store;

    @Column(name="expend")
    private String expend;

    private Integer status;

    private Integer userstat;

    private String signtime;
    private String addtime;

    private Integer type;
    private Integer channel;

    private String expendqd;
    @Column(name="expend2")
    private String expend2;
    private String userexpend;



    @Override
    public String toString() {
        return "SmsUserSignstore{" +
                "id=" + id +
                ", uid=" + uid +
                ", store='" + store + '\'' +
                ", expend='" + expend + '\'' +
                ", status=" + status +
                ", userstat=" + userstat +
                ", signtime='" + signtime + '\'' +
                ", addtime='" + addtime + '\'' +
                ", type=" + type +
                ", channel=" + channel +
                ", expendqd='" + expendqd + '\'' +
                ", expend2='" + expend2 + '\'' +
                ", userexpend='" + userexpend + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getExpend() {
        return expend;
    }

    public void setExpend(String expend) {
        this.expend = expend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserstat() {
        return userstat;
    }

    public void setUserstat(Integer userstat) {
        this.userstat = userstat;
    }

    public String getSigntime() {
        return signtime;
    }

    public void setSigntime(String signtime) {
        this.signtime = signtime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getExpendqd() {
        return expendqd;
    }

    public void setExpendqd(String expendqd) {
        this.expendqd = expendqd;
    }

    public String getExpend2() {
        return expend2;
    }

    public void setExpend2(String expend2) {
        this.expend2 = expend2;
    }

    public String getUserexpend() {
        return userexpend;
    }

    public void setUserexpend(String userexpend) {
        this.userexpend = userexpend;
    }
}
