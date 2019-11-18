
package com.infodart.salman.Pojo_Classes.HomePageNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImagesPaths {

    @SerializedName("offer_image_path_english")
    @Expose
    private String offerImagePathEnglish;
    @SerializedName("offer_image_path_arabic")
    @Expose
    private String offerImagePathArabic;
    @SerializedName("supermarket_image_path")
    @Expose
    private String supermarketImagePath;
    @SerializedName("product_image_path")
    @Expose
    private String productImagePath;

    public String getOfferImagePathEnglish() {
        return offerImagePathEnglish;
    }

    public void setOfferImagePathEnglish(String offerImagePathEnglish) {
        this.offerImagePathEnglish = offerImagePathEnglish;
    }

    public String getOfferImagePathArabic() {
        return offerImagePathArabic;
    }

    public void setOfferImagePathArabic(String offerImagePathArabic) {
        this.offerImagePathArabic = offerImagePathArabic;
    }

    public String getSupermarketImagePath() {
        return supermarketImagePath;
    }

    public void setSupermarketImagePath(String supermarketImagePath) {
        this.supermarketImagePath = supermarketImagePath;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

}
