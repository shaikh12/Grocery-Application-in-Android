
package com.infodart.salman.Pojo_Classes.Model_Signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infodart.salman.Pojo_Classes.Model_Login.Data;

public class signup {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status")
    @Expose
    private Long status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
