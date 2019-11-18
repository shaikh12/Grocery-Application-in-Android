package com.infodart.salman.Pojo_Classes.Model_HomePage;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChildHomeResponse extends BaseResponse {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("country_id")
    @Expose
    private int countryId;
    @SerializedName("state_id")
    @Expose
    private int stateId;
    @SerializedName("city_id")
    @Expose
    private int cityId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("freedeliveryamount")
    @Expose
    private int freedeliveryamount;
    @SerializedName("deliverytime")
    @Expose
    private String deliverytime;
//    @SerializedName("status")
//    @Expose
    //private int status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    @SerializedName("products")
    @Expose
    private List<LotteryDrawResponse> products;

    private String name_arabic;

    public String getName_arabic() {
        return name_arabic;
    }

    public void setName_arabic(String name_arabic) {
        this.name_arabic = name_arabic;

    }

    private String image_path;

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFreedeliveryamount() {
        return freedeliveryamount;
    }

    public void setFreedeliveryamount(int freedeliveryamount) {
        this.freedeliveryamount = freedeliveryamount;
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<LotteryDrawResponse> getProducts() {
        return products;
    }

    public void setProducts(List<LotteryDrawResponse> products) {
        this.products = products;
    }
}
