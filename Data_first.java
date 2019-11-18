
package com.infodart.salman.Pojo_Classes.Model_CartCategory_Last;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_first {

    @SerializedName("subcategories")
    @Expose
    private List<Subcategory> subcategories = null;
    @SerializedName("category_image_path")
    @Expose
    private String categoryImagePath;
    @SerializedName("marketid")
    @Expose
    private String marketid;

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public String getCategoryImagePath() {
        return categoryImagePath;
    }

    public void setCategoryImagePath(String categoryImagePath) {
        this.categoryImagePath = categoryImagePath;
    }

    public String getMarketid() {
        return marketid;
    }

    public void setMarketid(String marketid) {
        this.marketid = marketid;
    }

}
