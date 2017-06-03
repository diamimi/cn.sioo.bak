package cn.sioo.pojo;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsUserDayCount extends BaseEntity {

    private Integer uid;
    private Integer total;
    private Integer fail;
    private Integer arriveSucc;
    private Integer arriveFail;
    private Integer time;
    private Integer isReturn;

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
}
