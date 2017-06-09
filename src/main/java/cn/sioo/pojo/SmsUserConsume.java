package cn.sioo.pojo;

import java.util.Objects;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsUserConsume extends BaseEntity {

    private Integer id;


    private Integer uid;

    private Integer send;

    private Integer unsend;

    private Integer date;

    private Integer utype;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsUserConsume that = (SmsUserConsume) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(send, that.send) &&
                Objects.equals(unsend, that.unsend) &&
                Objects.equals(date, that.date) &&
                Objects.equals(utype, that.utype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, send, unsend, date, utype);
    }
}
