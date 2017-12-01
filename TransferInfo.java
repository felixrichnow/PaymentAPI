package Payment;

public class TransferInfo {
    private String txId;
    private String userId;
    private String accountId;
    private String txPspAmount;
    private String merchantTxId;
    private String txTypeId;

    public TransferInfo() {
    }

    public TransferInfo(String txId, String userId, String accountId, String txPspAmount, String txTypeId, String merchantTxId) {
        this.txId = txId;
        this.userId = userId;
        this.accountId = accountId;
        this.txPspAmount = txPspAmount;
        this.txTypeId = txTypeId;
        this.merchantTxId = merchantTxId;
    }

    public String getTxTypeId() {
        return txTypeId;
    }

    public void setTxTypeId(String txTypeId) {
        this.txTypeId = txTypeId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTxPspAmount() {
        return txPspAmount;
    }

    public void setTxPspAmount(String txPspAmount) {
        this.txPspAmount = txPspAmount;
    }

    public String getMerchantTxId() {
        return merchantTxId;
    }

    public void setMerchantTxId(String merchantTxId) {
        this.merchantTxId = merchantTxId;
    }
}