
package com.infodart.salman.Pojo_Classes.HomePageNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Home {

    @SerializedName("list")
    @Expose
    private java.util.List<list> list;
    @SerializedName("offers")
    @Expose
    private java.util.List<Offer> offers;
//    @SerializedName("images_paths")
//    @Expose
//    private ImagesPaths imagesPaths;

    public java.util.List<list> getList() {
        return list;
    }

    public void setList(java.util.List<com.infodart.salman.Pojo_Classes.HomePageNew.list> list) {
        this.list = list;
    }

    public java.util.List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(java.util.List<Offer> offers) {
        this.offers = offers;
    }

//    public ImagesPaths getImagesPaths() {
//        return imagesPaths;
//    }
//
//    public void setImagesPaths(ImagesPaths imagesPaths) {
//        this.imagesPaths = imagesPaths;
//    }

}
