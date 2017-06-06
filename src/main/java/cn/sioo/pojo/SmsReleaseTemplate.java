package cn.sioo.pojo;

import java.math.BigInteger;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsReleaseTemplate extends  BaseEntity {

    private Integer id;
    private Integer uid;

    private String content;

    private Integer type;

    private BigInteger effectivetime;

    private Integer stat;

    private BigInteger addtime;

    private String aid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigInteger getEffectivetime() {
        return effectivetime;
    }

    public void setEffectivetime(BigInteger effectivetime) {
        this.effectivetime = effectivetime;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public BigInteger getAddtime() {
        return addtime;
    }

    public void setAddtime(BigInteger addtime) {
        this.addtime = addtime;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
