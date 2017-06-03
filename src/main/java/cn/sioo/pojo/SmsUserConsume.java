package cn.sioo.pojo;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsUserConsume extends BaseEntity {

    private Integer uid;

    private Integer send;

    private Integer unsend;

    private Integer date;

    private Integer utype;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer send) {
        this.send = send;
    }

    public Integer getUnsend() {
        return unsend;
    }

    public void setUnsend(Integer unsend) {
        this.unsend = unsend;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getUtype() {
        return utype;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }
}
