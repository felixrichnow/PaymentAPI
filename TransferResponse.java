package Payment;

public class TransferResponse {

    private String userId;
    private Boolean success;
    private String txId;
    private String merchantTxId;
    public TransferResponse(String userId, Boolean success, String txId, String merchantTxId) {
        this.userId = userId;
        this.success = success;
        this.txId = txId;
        this.merchantTxId = merchantTxId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getMerchantTxId() {
        return merchantTxId;
    }

    public void setMerchantTxId(String merchantTxId) {
        this.merchantTxId = merchantTxId;
    }
}
