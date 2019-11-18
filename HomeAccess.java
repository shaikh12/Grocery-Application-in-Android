package com.infodart.salman.Pojo_Classes.Model_HomePage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class HomeAccess {

    @SerializedName("list")
    @Expose
    private List<ChildHomeResponse> list = null;

    public List<ChildHomeResponse> getList() {
        return list;
    }

    public void setList(List<ChildHomeResponse> list) {
        this.list = list;
    }


    private List<OfferImage> offers;

    public List<OfferImage> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferImage> offers) {
        this.offers = offers;

    }
}
