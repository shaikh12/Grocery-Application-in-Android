
package com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Supermarket {

    @SerializedName("id")
    @Expose
    private Long id;
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
    private Long countryId;
    @SerializedName("state_id")
    @Expose
    private Long stateId;
    @SerializedName("city_id")
    @Expose
    private Long cityId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("freedeliveryamount")
    @Expose
    private Long freedeliveryamount;
    @SerializedName("fixeddeliveryamount")
    @Expose
    private Long fixeddeliveryamount;
    @SerializedName("fixedserviceamount")
    @Expose
    private Long fixedserviceamount;
    @SerializedName("commission_percentage")
    @Expose
    private Long commissionPercentage;
    @SerializedName("deliverytime")
    @Expose
    private String deliverytime;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("status")
    @Expose
    private Long status;
    @SerializedName("is_enabled")
    @Expose
    private Long isEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getFreedeliveryamount() {
        return freedeliveryamount;
    }

    public void setFreedeliveryamount(Long freedeliveryamount) {
        this.freedeliveryamount = freedeliveryamount;
    }

    public Long getFixeddeliveryamount() {
        return fixeddeliveryamount;
    }

    public void setFixeddeliveryamount(Long fixeddeliveryamount) {
        this.fixeddeliveryamount = fixeddeliveryamount;
    }

    public Long getFixedserviceamount() {
        return fixedserviceamount;
    }

    public void setFixedserviceamount(Long fixedserviceamount) {
        this.fixedserviceamount = fixedserviceamount;
    }

    public Long getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Long commissionPercentage) {
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Long isEnabled) {
        this.isEnabled = isEnabled;
    }

}
