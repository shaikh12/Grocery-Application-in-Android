
package com.infodart.salman.Pojo_Classes.Model_Cart_Category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_Cart_Category {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data_Category data;
    @SerializedName("status")
    @Expose
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data_Category getData() {
        return data;
    }

    public void setData(Data_Category data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
