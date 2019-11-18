
package com.infodart.salman.Pojo_Classes.Model_CartCategory_Last;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartExample {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data_first data;
    @SerializedName("status")
    @Expose
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data_first getData() {
        return data;
    }

    public void setData(Data_first data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
