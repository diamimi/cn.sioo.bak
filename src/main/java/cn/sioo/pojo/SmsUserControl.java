package cn.sioo.pojo;

import javax.persistence.Column;

/**
 * Created by morrigan on 2017/6/2.
 */
public class SmsUserControl  extends BaseEntity{



    private Integer uid;
    @Column(name = "isShowRpt")
    private Integer isShowRpt;
    @Column(name = "childFun")
    private Integer childFun;
    @Column(name = "childNum")
    private Integer childNum;
    @Column(name = "isRelease")
    private Integer isRelease;
    @Column(name = "releaseNum")
    private Integer releaseNum;
    private Integer replyn;
    @Column(name = "repeatFilter")
    private Integer repeatFilter;
    @Column(name = "repeatNum")
    private Integer repeatNum;
    @Column(name = "signPosition")
    private Integer signPosition;
    @Column(name = "expidSign")
    private Integer expidSign;
    @Column(name = "proxyIp")
    private String proxyIp;
    private Integer mobile;
    private Integer unicom;
    private Integer telecom;
    @Column(name = "submitType")
    private Integer submitType;
    private Integer speed;
    @Column(name = "blackAll")
    private Integer blackAll;
    @Column(name = "repeatSign")
    private Integer repeatSign;
    @Column(name = "repeatSignNum")
    private Integer repeatSignNum;
    private Integer line;


    @Override
    public String getOrderBy() {
        return "uid";
    }



    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getIsShowRpt() {
        return isShowRpt;
    }

    public void setIsShowRpt(Integer isShowRpt) {
        this.isShowRpt = isShowRpt;
    }

    public Integer getChildFun() {
        return childFun;
    }

    public void setChildFun(Integer childFun) {
        this.childFun = childFun;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public Integer getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    public Integer getReleaseNum() {
        return releaseNum;
    }

    public void setReleaseNum(Integer releaseNum) {
        this.releaseNum = releaseNum;
    }

    public Integer getReplyn() {
        return replyn;
    }

    public void setReplyn(Integer replyn) {
        this.replyn = replyn;
    }

    public Integer getRepeatFilter() {
        return repeatFilter;
    }

    public void setRepeatFilter(Integer repeatFilter) {
        this.repeatFilter = repeatFilter;
    }

    public Integer getRepeatNum() {
        return repeatNum;
    }

    public void setRepeatNum(Integer repeatNum) {
        this.repeatNum = repeatNum;
    }

    public Integer getSignPosition() {
        return signPosition;
    }

    public void setSignPosition(Integer signPosition) {
        this.signPosition = signPosition;
    }

    public Integer getExpidSign() {
        return expidSign;
    }

    public void setExpidSign(Integer expidSign) {
        this.expidSign = expidSign;
    }

    public String getProxyIp() {
        return proxyIp;
    }

    public void setProxyIp(String proxyIp) {
        this.proxyIp = proxyIp;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Integer getUnicom() {
        return unicom;
    }

    public void setUnicom(Integer unicom) {
        this.unicom = unicom;
    }

    public Integer getTelecom() {
        return telecom;
    }

    public void setTelecom(Integer telecom) {
        this.telecom = telecom;
    }

    public Integer getSubmitType() {
        return submitType;
    }

    public void setSubmitType(Integer submitType) {
        this.submitType = submitType;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getBlackAll() {
        return blackAll;
    }

    public void setBlackAll(Integer blackAll) {
        this.blackAll = blackAll;
    }

    public Integer getRepeatSign() {
        return repeatSign;
    }

    public void setRepeatSign(Integer repeatSign) {
        this.repeatSign = repeatSign;
    }

    public Integer getRepeatSignNum() {
        return repeatSignNum;
    }

    public void setRepeatSignNum(Integer repeatSignNum) {
        this.repeatSignNum = repeatSignNum;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsUserControl that = (SmsUserControl) o;

        if (uid != null ? !uid.equals(that.uid) : that.uid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        return result;
    }
}