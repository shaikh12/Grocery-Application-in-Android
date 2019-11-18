
package com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("productslist")
    @Expose
    private List<Product> product = null;
    @SerializedName("product_image_path")
    @Expose
    private String productImagePath;

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

}
