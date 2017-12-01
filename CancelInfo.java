package Payment;

import java.util.UUID;

public class CancelInfo {

    private String authCode;
    private String txAmount;
    private String txAmountCy;
    private String txId;
    private Number txTypeId;
    private String txName;
    private String provider;
    private String originTxId;
    private UUID accountId;
    private String maskedAccount;
    private String statusCode;
    private String pspStatusCode;
    private String pspFee;
    private String pspFeeCy;
    private String pspFeeBase;
    private String pspRefId;
    private String pspStatusMessage;
    private Object attributes;
    public CancelInfo() {
    }
    public CancelInfo(String authCode, String txAmount, String txAmountCy, String txId,
                      Number txTypeId, String txName, String provider, String originTxId,
                      UUID accountId, String maskedAccount, String statusCode, String pspStatusCode,
                      String pspFee, String pspFeeCy, String pspFeeBase, String pspRefId,
                      String pspStatusMessage, Object attributes) {

        this.authCode = authCode;
        this.txAmount = txAmount;
        this.txAmountCy = txAmountCy;
        this.txId = txId;
        this.txTypeId = txTypeId;
        this.txName = txName;
        this.provider = provider;
        this.originTxId = originTxId;
        this.accountId = accountId;
        this.maskedAccount = maskedAccount;
        this.statusCode = statusCode;
        this.pspStatusCode = pspStatusCode;
        this.pspFee = pspFee;
        this.pspFeeCy = pspFeeCy;
        this.pspFeeBase = pspFeeBase;
        this.pspRefId = pspRefId;
        this.pspStatusMessage = pspStatusMessage;
        this.attributes = attributes;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(String txAmount) {
        this.txAmount = txAmount;
    }

    public String getTxAmountCy() {
        return txAmountCy;
    }

    public void setTxAmountCy(String txAmountCy) {
        this.txAmountCy = txAmountCy;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Number getTxTypeId() {
        return txTypeId;
    }

    public void setTxTypeId(Number txTypeId) {
        this.txTypeId = txTypeId;
    }

    public String getTxName() {
        return txName;
    }

    public void setTxName(String txName) {
        this.txName = txName;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getOriginTxId() {
        return originTxId;
    }

    public void setOriginTxId(String originTxId) {
        this.originTxId = originTxId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getMaskedAccount() {
        return maskedAccount;
    }

    public void setMaskedAccount(String maskedAccount) {
        this.maskedAccount = maskedAccount;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getPspStatusCode() {
        return pspStatusCode;
    }

    public void setPspStatusCode(String pspStatusCode) {
        this.pspStatusCode = pspStatusCode;
    }

    public String getPspFee() {
        return pspFee;
    }

    public void setPspFee(String pspFee) {
        this.pspFee = pspFee;
    }

    public String getPspFeeCy() {
        return pspFeeCy;
    }

    public void setPspFeeCy(String pspFeeCy) {
        this.pspFeeCy = pspFeeCy;
    }

    public String getPspFeeBase() {
        return pspFeeBase;
    }

    public void setPspFeeBase(String pspFeeBase) {
        this.pspFeeBase = pspFeeBase;
    }

    public String getPspRefId() {
        return pspRefId;
    }

    public void setPspRefId(String pspRefId) {
        this.pspRefId = pspRefId;
    }

    public String getPspStatusMessage() {
        return pspStatusMessage;
    }

    public void setPspStatusMessage(String pspStatusMessage) {
        this.pspStatusMessage = pspStatusMessage;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }


}
