package Payment;

public class AuthorResponse {
    private String userId;
    private Boolean success;
    private String authCode;

    public AuthorResponse() {

    }


    public AuthorResponse(String userId, Boolean success, String authCode) {
        this.userId = userId;
        this.success = success;
        this.authCode = authCode;
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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}
