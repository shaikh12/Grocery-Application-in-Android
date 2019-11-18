
package com.infodart.salman.Pojo_Classes.Model_pulsesFragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Supermarket;

import java.util.List;

public class ProductList {

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
    private Long vendorId;
    @SerializedName("category_id")
    @Expose
    private Long categoryId;
    @SerializedName("status")
    @Expose
    private Long status;
    @SerializedName("supermarket")
    @Expose
    private Supermarket supermarket;
    @SerializedName("productconfig")
    @Expose
    private List<ProducTConfig> productconfig=null;

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

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public List<ProducTConfig> getProducTConfig() {
        return productconfig;
    }

    public void setProductconfig(List<ProducTConfig> productconfig) {
        this.productconfig = productconfig;
    }

}
