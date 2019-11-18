
package com.infodart.salman.Pojo_Classes.Model_Cart_Category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_Category {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("category_image_path")
    @Expose
    private String categoryImagePath;
    @SerializedName("marketid")
    @Expose
    private String marketid;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
