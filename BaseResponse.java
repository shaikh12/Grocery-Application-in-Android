package com.infodart.salman.Pojo_Classes.Model_HomePage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("status")
    @Expose
    public String code;

//    @SerializedName("error")
//    @Expose
//    public String error;

    @SerializedName("message")
    @Expose
    public String msg;


    //public Object data;



//    public String getError() {
//        return error;
//    }
//
//    public void setError(String error) {
//        this.error = error;
//    }

//    public void setData(Object data) {
//        this.data = data;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public Object getData() {
//        return data;
//    }



}
