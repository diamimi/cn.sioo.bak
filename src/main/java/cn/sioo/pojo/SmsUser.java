package cn.sioo.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by morrigan on 2017/6/1.
 */
@Table(name = "sms_user")
public class SmsUser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 291749309616942675L;

    private Integer id;
    private String pwd;
    private String dpwd;
    private String company;
    private String phone;
    private String tel;
    private String mail;
    private String linkman;
    private String address;
    private String sales;
    private Float discount;
    private Float price;
    private Integer send;
    private Integer sendOk;
    private String time;
    private String addUid;
    private Integer stat;
    private Integer sms;
    private Integer priority;
    private Integer logintime;
    private String loginip;
    private String qq;
    private String remark;
    private Integer userkind;
    private String kefu;
    private String username;
    private Integer submittype;
    @Column(name = "parentId")
    private Integer parentId;

    @Column(name = "hyType")
    private Integer hyType;
    private Integer customerId;
    private Integer usertype;
    private Integer paytype;


    @Override
    public String getOrderBy() {
        return "time";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsUser smsUser = (SmsUser) o;
        return Objects.equals(id, smsUser.id) &&
                Objects.equals(pwd, smsUser.pwd) &&
                Objects.equals(dpwd, smsUser.dpwd) &&
                Objects.equals(company, smsUser.company) &&
                Objects.equals(phone, smsUser.phone) &&
                Objects.equals(tel, smsUser.tel) &&
                Objects.equals(mail, smsUser.mail) &&
                Objects.equals(linkman, smsUser.linkman) &&
                Objects.equals(address, smsUser.address) &&
                Objects.equals(sales, smsUser.sales) &&
                Objects.equals(discount, smsUser.discount) &&
                Objects.equals(price, smsUser.price) &&
                Objects.equals(send, smsUser.send) &&
                Objects.equals(sendOk, smsUser.sendOk) &&
                Objects.equals(time, smsUser.time) &&
                Objects.equals(addUid, smsUser.addUid) &&
                Objects.equals(stat, smsUser.stat) &&
                Objects.equals(sms, smsUser.sms) &&
                Objects.equals(priority, smsUser.priority) &&
                Objects.equals(logintime, smsUser.logintime) &&
                Objects.equals(loginip, smsUser.loginip) &&
                Objects.equals(qq, smsUser.qq) &&
                Objects.equals(remark, smsUser.remark) &&
                Objects.equals(userkind, smsUser.userkind) &&
                Objects.equals(kefu, smsUser.kefu) &&
                Objects.equals(username, smsUser.username) &&
                Objects.equals(submittype, smsUser.submittype) &&
                Objects.equals(parentId, smsUser.parentId) &&
                Objects.equals(hyType, smsUser.hyType) &&
                Objects.equals(customerId, smsUser.customerId) &&
                Objects.equals(usertype, smsUser.usertype) &&
                Objects.equals(paytype, smsUser.paytype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pwd, dpwd, company, phone, tel, mail, linkman, address, sales, discount, price, send, sendOk, time, addUid, stat, sms, priority, logintime, loginip, qq, remark, userkind, kefu, username, submittype, parentId, hyType, customerId, usertype, paytype);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDpwd() {
        return dpwd;
    }

    public void setDpwd(String dpwd) {
        this.dpwd = dpwd;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer send) {
        this.send = send;
    }

    public Integer getSendOk() {
        return sendOk;
    }

    public void setSendOk(Integer sendOk) {
        this.sendOk = sendOk;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddUid() {
        return addUid;
    }

    public void setAddUid(String addUid) {
        this.addUid = addUid;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    public Integer getLogintime() {
        return logintime;
    }

    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getUserkind() {
        return userkind;
    }

    public void setUserkind(Integer userkind) {
        this.userkind = userkind;
    }

    public String getKefu() {
        return kefu;
    }

    public void setKefu(String kefu) {
        this.kefu = kefu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSubmittype() {
        return submittype;
    }

    public void setSubmittype(Integer submittype) {
        this.submittype = submittype;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getHyType() {
        return hyType;
    }

    public void setHyType(Integer hyType) {
        this.hyType = hyType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }


}
