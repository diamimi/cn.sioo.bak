package cn.sioo.pojo;

import javax.persistence.Column;
import java.math.BigInteger;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsAccount extends BaseEntity{

    private Integer id;
    private Integer uid;

    private Float amount;

    @Column(name="amountNum")
    private Integer amountNum;

    @Column(name="dateTime")
    private BigInteger dateTime;

    @Column(name="chargeType")
    private Integer chargeType;

    private Integer stat;

    private String info;

    private String addUid;

    private String memo;

    @Column(name="giftNum")
    private Integer giftNum;

    @Column(name="operateType")
    private Integer operateType;

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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getAmountNum() {
        return amountNum;
    }

    public void setAmountNum(Integer amountNum) {
        this.amountNum = amountNum;
    }

    public BigInteger getDateTime() {
        return dateTime;
    }

    public void setDateTime(BigInteger dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddUid() {
        return addUid;
    }

    public void setAddUid(String addUid) {
        this.addUid = addUid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
}
