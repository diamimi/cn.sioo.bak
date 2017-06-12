package cn.sioo.pojo;

import javax.persistence.Column;
import java.util.Objects;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsUserDayCount extends BaseEntity {

    private Integer id;
    private Integer uid;
    private Integer total;
    private Integer fail;
    private Integer arriveSucc;
    private Integer arriveFail;
    private Integer time;
    @Column(name="isReturn")
    private Integer isReturn;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

    public Integer getArriveSucc() {
        return arriveSucc;
    }

    public void setArriveSucc(Integer arriveSucc) {
        this.arriveSucc = arriveSucc;
    }

    public Integer getArriveFail() {
        return arriveFail;
    }

    public void setArriveFail(Integer arriveFail) {
        this.arriveFail = arriveFail;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsUserDayCount that = (SmsUserDayCount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(total, that.total) &&
                Objects.equals(fail, that.fail) &&
                Objects.equals(arriveSucc, that.arriveSucc) &&
                Objects.equals(arriveFail, that.arriveFail) &&
                Objects.equals(time, that.time) &&
                Objects.equals(isReturn, that.isReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, total, fail, arriveSucc, arriveFail, time, isReturn);
    }
}
