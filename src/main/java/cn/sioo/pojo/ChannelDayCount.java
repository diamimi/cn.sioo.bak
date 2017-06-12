package cn.sioo.pojo;

import javax.persistence.Column;
import java.util.Objects;

/**
 * Created by morrigan on 2017/6/2.
 */
public class ChannelDayCount extends BaseEntity {

    private Integer id;
    private Integer submitCount;
    private Integer submitSucc;
    private Integer submitFail;
    private Integer reportCount;
    private Integer reportSucc;
    private Integer reportFail;
    private Integer createTime;
    @Column(name="channelId")
    private Integer channelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(Integer submitCount) {
        this.submitCount = submitCount;
    }

    public Integer getSubmitSucc() {
        return submitSucc;
    }

    public void setSubmitSucc(Integer submitSucc) {
        this.submitSucc = submitSucc;
    }

    public Integer getSubmitFail() {
        return submitFail;
    }

    public void setSubmitFail(Integer submitFail) {
        this.submitFail = submitFail;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public Integer getReportSucc() {
        return reportSucc;
    }

    public void setReportSucc(Integer reportSucc) {
        this.reportSucc = reportSucc;
    }

    public Integer getReportFail() {
        return reportFail;
    }

    public void setReportFail(Integer reportFail) {
        this.reportFail = reportFail;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelDayCount that = (ChannelDayCount) o;
        return  Objects.equals(submitCount, that.submitCount) &&
                Objects.equals(submitSucc, that.submitSucc) &&
                Objects.equals(submitFail, that.submitFail) &&
                Objects.equals(reportCount, that.reportCount) &&
                Objects.equals(reportSucc, that.reportSucc) &&
                Objects.equals(reportFail, that.reportFail) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(channelId, that.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submitCount, submitSucc, submitFail, reportCount, reportSucc, reportFail, createTime, channelId);
    }
}
