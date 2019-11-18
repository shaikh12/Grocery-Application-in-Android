
package com.infodart.salman.Pojo_Classes.Model_pulsesFragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Data;

public class Example_cityCart1 {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data1 data;
    @SerializedName("status")
    @Expose
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data1 getData() {
        return data;
    }

    public void setData(Data1 data) {
        this.data = data;
    }

    public String  getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
