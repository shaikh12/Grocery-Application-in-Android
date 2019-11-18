package com.infodart.salman.Pojo_Classes.HomePageNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infodart.salman.Pojo_Classes.HomePageNew.Product;

public class list {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_arabic")
    @Expose
    private String nameArabic;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("freedeliveryamount")
    @Expose
    private String freedeliveryamount;
    @SerializedName("fixeddeliveryamount")
    @Expose
    private String fixeddeliveryamount;
    @SerializedName("fixedserviceamount")
    @Expose
    private String fixedserviceamount;
    @SerializedName("commission_percentage")
    @Expose
    private String commissionPercentage;
    @SerializedName("deliverytime")
    @Expose
    private String deliverytime;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("is_enabled")
    @Expose
    private String isEnabled;
    @SerializedName("products")
    @Expose
    private java.util.List<Product> products = null;

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

    public String getNameArabic() {
        return nameArabic;
    }

    public void setNameArabic(String nameArabic) {
        this.nameArabic = nameArabic;
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFreedeliveryamount() {
        return freedeliveryamount;
    }

    public void setFreedeliveryamount(String freedeliveryamount) {
        this.freedeliveryamount = freedeliveryamount;
    }

    public String getFixeddeliveryamount() {
        return fixeddeliveryamount;
    }

    public void setFixeddeliveryamount(String fixeddeliveryamount) {
        this.fixeddeliveryamount = fixeddeliveryamount;
    }

    public String getFixedserviceamount() {
        return fixedserviceamount;
    }

    public void setFixedserviceamount(String fixedserviceamount) {
        this.fixedserviceamount = fixedserviceamount;
    }

    public String getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(String commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public java.util.List<Product> getProducts() {
        return products;
    }

    public void setProducts(java.util.List<Product> products) {
        this.products = products;
    }

}
