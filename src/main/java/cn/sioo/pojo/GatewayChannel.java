package cn.sioo.pojo;

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
}
