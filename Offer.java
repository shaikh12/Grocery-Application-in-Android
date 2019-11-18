
package com.infodart.salman.Pojo_Classes.HomePageNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("offer_type")
    @Expose
    private String offerType;
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
    @SerializedName("main_category_id")
    @Expose
    private String mainCategoryId;
    @SerializedName("sub_category_id")
    @Expose
    private String subCategoryId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("productconfig_id")
    @Expose
    private String productconfigId;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("image_path_arabic")
    @Expose
    private String imagePathArabic;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("is_enabled")
    @Expose
    private String isEnabled;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
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

    public String getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(String mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductconfigId() {
        return productconfigId;
    }

    public void setProductconfigId(String productconfigId) {
        this.productconfigId = productconfigId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePathArabic() {
        return imagePathArabic;
    }

    public void setImagePathArabic(String imagePathArabic) {
        this.imagePathArabic = imagePathArabic;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
