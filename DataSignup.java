
package com.infodart.salman.Pojo_Classes.Model_Signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSignup {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    @SerializedName("mobile_verified")
    @Expose
    private Object mobileVerified;
    @SerializedName("email_verified")
    @Expose
    private Object emailVerified;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Object getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(Object mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public Object getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Object emailVerified) {
        this.emailVerified = emailVerified;
    }

}
