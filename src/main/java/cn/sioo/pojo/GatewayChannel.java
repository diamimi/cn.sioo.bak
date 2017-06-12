package cn.sioo.pojo;

import java.util.Objects;

/**
 * Created by morrigan on 2017/6/2.
 */
public class GatewayChannel extends BaseEntity {

    private Integer id;
    private Integer gatewayTemplate;
    private Integer gatewayPort;
    private String gatewayIp;
    private String gatewayCorpid;
    private String gatewayAccount;
    private String gatewayPass;
    private String gatewayNomber;
    private String gatewayServiceid;
    private Integer gatewayMsgformat;
    private String gatewayNodeid;
    private String gatewayUrl;
    private String gatewayParameter;
    private Integer localPort;
    private String localIp;
    private Integer localExpidLen;
    private Integer localDelay;
    private Integer localReadNum;
    private Integer localRate;
    private Integer rabbitPort;
    private String rabbitIp;
    private String rabbitAccount;
    private String rabbitPass;
    private String channelName;
    private String channelProvider;
    private Integer supportNetwork;
    private Integer sendWordsLen;
    private Integer sendWordsMaxlen;
    private Integer recordType;
    private Integer routeType;
    private String routeRequire;
    private Integer routeChannel;
    private Integer signPosition;
    private Integer isSigns;
    private Integer isGroup;
    private Integer status;
    private Integer standard;
    private Integer price;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGatewayTemplate() {
        return gatewayTemplate;
    }

    public void setGatewayTemplate(Integer gatewayTemplate) {
        this.gatewayTemplate = gatewayTemplate;
    }

    public Integer getGatewayPort() {
        return gatewayPort;
    }

    public void setGatewayPort(Integer gatewayPort) {
        this.gatewayPort = gatewayPort;
    }

    public String getGatewayIp() {
        return gatewayIp;
    }

    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    public String getGatewayCorpid() {
        return gatewayCorpid;
    }

    public void setGatewayCorpid(String gatewayCorpid) {
        this.gatewayCorpid = gatewayCorpid;
    }

    public String getGatewayAccount() {
        return gatewayAccount;
    }

    public void setGatewayAccount(String gatewayAccount) {
        this.gatewayAccount = gatewayAccount;
    }

    public String getGatewayPass() {
        return gatewayPass;
    }

    public void setGatewayPass(String gatewayPass) {
        this.gatewayPass = gatewayPass;
    }

    public String getGatewayNomber() {
        return gatewayNomber;
    }

    public void setGatewayNomber(String gatewayNomber) {
        this.gatewayNomber = gatewayNomber;
    }

    public String getGatewayServiceid() {
        return gatewayServiceid;
    }

    public void setGatewayServiceid(String gatewayServiceid) {
        this.gatewayServiceid = gatewayServiceid;
    }

    public Integer getGatewayMsgformat() {
        return gatewayMsgformat;
    }

    public void setGatewayMsgformat(Integer gatewayMsgformat) {
        this.gatewayMsgformat = gatewayMsgformat;
    }

    public String getGatewayNodeid() {
        return gatewayNodeid;
    }

    public void setGatewayNodeid(String gatewayNodeid) {
        this.gatewayNodeid = gatewayNodeid;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getGatewayParameter() {
        return gatewayParameter;
    }

    public void setGatewayParameter(String gatewayParameter) {
        this.gatewayParameter = gatewayParameter;
    }

    public Integer getLocalPort() {
        return localPort;
    }

    public void setLocalPort(Integer localPort) {
        this.localPort = localPort;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public Integer getLocalExpidLen() {
        return localExpidLen;
    }

    public void setLocalExpidLen(Integer localExpidLen) {
        this.localExpidLen = localExpidLen;
    }

    public Integer getLocalDelay() {
        return localDelay;
    }

    public void setLocalDelay(Integer localDelay) {
        this.localDelay = localDelay;
    }

    public Integer getLocalReadNum() {
        return localReadNum;
    }

    public void setLocalReadNum(Integer localReadNum) {
        this.localReadNum = localReadNum;
    }

    public Integer getLocalRate() {
        return localRate;
    }

    public void setLocalRate(Integer localRate) {
        this.localRate = localRate;
    }

    public Integer getRabbitPort() {
        return rabbitPort;
    }

    public void setRabbitPort(Integer rabbitPort) {
        this.rabbitPort = rabbitPort;
    }

    public String getRabbitIp() {
        return rabbitIp;
    }

    public void setRabbitIp(String rabbitIp) {
        this.rabbitIp = rabbitIp;
    }

    public String getRabbitAccount() {
        return rabbitAccount;
    }

    public void setRabbitAccount(String rabbitAccount) {
        this.rabbitAccount = rabbitAccount;
    }

    public String getRabbitPass() {
        return rabbitPass;
    }

    public void setRabbitPass(String rabbitPass) {
        this.rabbitPass = rabbitPass;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelProvider() {
        return channelProvider;
    }

    public void setChannelProvider(String channelProvider) {
        this.channelProvider = channelProvider;
    }

    public Integer getSupportNetwork() {
        return supportNetwork;
    }

    public void setSupportNetwork(Integer supportNetwork) {
        this.supportNetwork = supportNetwork;
    }

    public Integer getSendWordsLen() {
        return sendWordsLen;
    }

    public void setSendWordsLen(Integer sendWordsLen) {
        this.sendWordsLen = sendWordsLen;
    }

    public Integer getSendWordsMaxlen() {
        return sendWordsMaxlen;
    }

    public void setSendWordsMaxlen(Integer sendWordsMaxlen) {
        this.sendWordsMaxlen = sendWordsMaxlen;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    public String getRouteRequire() {
        return routeRequire;
    }

    public void setRouteRequire(String routeRequire) {
        this.routeRequire = routeRequire;
    }

    public Integer getRouteChannel() {
        return routeChannel;
    }

    public void setRouteChannel(Integer routeChannel) {
        this.routeChannel = routeChannel;
    }

    public Integer getSignPosition() {
        return signPosition;
    }

    public void setSignPosition(Integer signPosition) {
        this.signPosition = signPosition;
    }

    public Integer getIsSigns() {
        return isSigns;
    }

    public void setIsSigns(Integer isSigns) {
        this.isSigns = isSigns;
    }

    public Integer getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GatewayChannel that = (GatewayChannel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(gatewayTemplate, that.gatewayTemplate) &&
                Objects.equals(gatewayPort, that.gatewayPort) &&
                Objects.equals(gatewayIp, that.gatewayIp) &&
                Objects.equals(gatewayCorpid, that.gatewayCorpid) &&
                Objects.equals(gatewayAccount, that.gatewayAccount) &&
                Objects.equals(gatewayPass, that.gatewayPass) &&
                Objects.equals(gatewayNomber, that.gatewayNomber) &&
                Objects.equals(gatewayServiceid, that.gatewayServiceid) &&
                Objects.equals(gatewayMsgformat, that.gatewayMsgformat) &&
                Objects.equals(gatewayNodeid, that.gatewayNodeid) &&
                Objects.equals(gatewayUrl, that.gatewayUrl) &&
                Objects.equals(gatewayParameter, that.gatewayParameter) &&
                Objects.equals(localPort, that.localPort) &&
                Objects.equals(localIp, that.localIp) &&
                Objects.equals(localExpidLen, that.localExpidLen) &&
                Objects.equals(localDelay, that.localDelay) &&
                Objects.equals(localReadNum, that.localReadNum) &&
                Objects.equals(localRate, that.localRate) &&
                Objects.equals(rabbitPort, that.rabbitPort) &&
                Objects.equals(rabbitIp, that.rabbitIp) &&
                Objects.equals(rabbitAccount, that.rabbitAccount) &&
                Objects.equals(rabbitPass, that.rabbitPass) &&
                Objects.equals(channelName, that.channelName) &&
                Objects.equals(channelProvider, that.channelProvider) &&
                Objects.equals(supportNetwork, that.supportNetwork) &&
                Objects.equals(sendWordsLen, that.sendWordsLen) &&
                Objects.equals(sendWordsMaxlen, that.sendWordsMaxlen) &&
                Objects.equals(recordType, that.recordType) &&
                Objects.equals(routeType, that.routeType) &&
                Objects.equals(routeRequire, that.routeRequire) &&
                Objects.equals(routeChannel, that.routeChannel) &&
                Objects.equals(signPosition, that.signPosition) &&
                Objects.equals(isSigns, that.isSigns) &&
                Objects.equals(isGroup, that.isGroup) &&
                Objects.equals(status, that.status) &&
                Objects.equals(standard, that.standard) &&
                Objects.equals(price, that.price) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gatewayTemplate, gatewayPort, gatewayIp, gatewayCorpid, gatewayAccount, gatewayPass, gatewayNomber, gatewayServiceid, gatewayMsgformat, gatewayNodeid, gatewayUrl, gatewayParameter, localPort, localIp, localExpidLen, localDelay, localReadNum, localRate, rabbitPort, rabbitIp, rabbitAccount, rabbitPass, channelName, channelProvider, supportNetwork, sendWordsLen, sendWordsMaxlen, recordType, routeType, routeRequire, routeChannel, signPosition, isSigns, isGroup, status, standard, price, remark);
    }
}
