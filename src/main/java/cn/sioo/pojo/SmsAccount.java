package cn.sioo.pojo;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsAccount extends BaseEntity{

    private Integer uid;

    private Float amount;

    private Integer amountNum;

    private Integer dataTime;

    private Integer chargeType;

    private Integer stat;

    private String info;

    private String addUid;

    private String memo;

    private Integer giftNum;

    private Integer operateType;

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

    public Integer getDataTime() {
        return dataTime;
    }

    public void setDataTime(Integer dataTime) {
        this.dataTime = dataTime;
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
