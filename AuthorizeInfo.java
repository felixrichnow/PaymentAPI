package Payment;

import java.util.UUID;

public class AuthorizeInfo {

    private String userId;
    private String authCode;

    //Req Params
    private String txAmount;
    private String txAmountCy;
    private String txId;
    private Integer txTypeId;
    private String txName;
    private String provider;
    //Optional Req Params
    private String pspService;
    private String originTxId;
    private UUID accountId;
    private String accountHolder;
    private String maskedAccount;
    private String pspFee;
    private String pspFeeCy;
    private String pspFeeBase;
    private String pspFeeBaseCy;
    private Object attributes;

    public AuthorizeInfo(String userId, String authCode, String txAmount, String txAmountCy,
                         String txId, Integer txTypeId, String txName, String provider, String pspService,
                         String originTxId, UUID accountId, String accountHolder, String maskedAccount,
                         String pspFee, String pspFeeCy, String pspFeeBase, String pspFeeBaseCy, Object attributes) {
        this.userId = userId;
        this.authCode = authCode;
        this.txAmount = txAmount;
        this.txAmountCy = txAmountCy;
        this.txId = txId;
        this.txTypeId = txTypeId;
        this.txName = txName;
        this.provider = provider;
        this.pspService = pspService;
        this.originTxId = originTxId;
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.maskedAccount = maskedAccount;
        this.pspFee = pspFee;
        this.pspFeeCy = pspFeeCy;
        this.pspFeeBase = pspFeeBase;
        this.pspFeeBaseCy = pspFeeBaseCy;
        this.attributes = attributes;
    }

    public AuthorizeInfo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getTxTypeId() {
        return txTypeId;
    }

    public void setTxTypeId(Integer txTypeId) {
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

    public String getPspService() {
        return pspService;
    }

    public void setPspService(String pspService) {
        this.pspService = pspService;
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

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getMaskedAccount() {
        return maskedAccount;
    }

    public void setMaskedAccount(String maskedAccount) {
        this.maskedAccount = maskedAccount;
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

    public String getPspFeeBaseCy() {
        return pspFeeBaseCy;
    }

    public void setPspFeeBaseCy(String pspFeeBaseCy) {
        this.pspFeeBaseCy = pspFeeBaseCy;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }
}
