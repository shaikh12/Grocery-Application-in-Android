
package com.infodart.salman.Pojo_Classes.HomePageNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeExample {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Home data;
    @SerializedName("status")
    @Expose
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Home getData() {
        return data;
    }

    public void setData(Home data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
