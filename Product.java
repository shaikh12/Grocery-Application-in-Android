
package com.infodart.salman.Pojo_Classes.HomePageNew;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_arabic")
    @Expose
    private String nameArabic;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("description_arabic")
    @Expose
    private String descriptionArabic;
    @SerializedName("supermarket_id")
    @Expose
    private String supermarketId;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("productconfig")
    @Expose
    private List<Productconfig> productconfig = null;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionArabic() {
        return descriptionArabic;
    }

    public void setDescriptionArabic(String descriptionArabic) {
        this.descriptionArabic = descriptionArabic;
    }

    public String getSupermarketId() {
        return supermarketId;
    }

    public void setSupermarketId(String supermarketId) {
        this.supermarketId = supermarketId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Productconfig> getProductconfig() {
        return productconfig;
    }

    public void setProductconfig(List<Productconfig> productconfig) {
        this.productconfig = productconfig;
    }

}
