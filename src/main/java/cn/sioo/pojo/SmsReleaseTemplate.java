package cn.sioo.pojo;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsReleaseTemplate extends  BaseEntity {

    private Integer uid;

    private String content;

    private Integer type;

    private Integer effectivetime;

    private Integer stat;

    private Integer addtime;

    private String aid;

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

    public Integer getEffectivetime() {
        return effectivetime;
    }

    public void setEffectivetime(Integer effectivetime) {
        this.effectivetime = effectivetime;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
