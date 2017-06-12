package cn.sioo.pojo;

import javax.persistence.Column;
import java.math.BigInteger;

/**
 * Created by morrigan on 2017/6/12.
 */
public class SmsSendHistoryBackups {

    private BigInteger id;

    private Integer stype;

    private Integer mtype;

    private BigInteger senddate;

    private Integer uid;

    private BigInteger mobile;

    private Integer channel;

    private String content;

    @Column(name="contentNum")
    private Integer contentNum;

    private Integer succ;

    private Integer fail;

    private String mtstat;

    private Integer pid;

    private Integer grade;

    private String expid;

    private String location;

    private Integer arriveSucc;

    private Integer arriveFail;

    private Integer stat;

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getStype() {
        return stype;
    }

    public void setStype(Integer stype) {
        this.stype = stype;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public BigInteger getSenddate() {
        return senddate;
    }

    public void setSenddate(BigInteger senddate) {
        this.senddate = senddate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getContentNum() {
        return contentNum;
    }

    public void setContentNum(Integer contentNum) {
        this.contentNum = contentNum;
    }

    public Integer getSucc() {
        return succ;
    }

    public void setSucc(Integer succ) {
        this.succ = succ;
    }

    public String getMtstat() {
        return mtstat;
    }

    public void setMtstat(String mtstat) {
        this.mtstat = mtstat;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getExpid() {
        return expid;
    }

    public void setExpid(String expid) {
        this.expid = expid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }
}
