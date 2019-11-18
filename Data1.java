
package com.infodart.salman.Pojo_Classes.Model_pulsesFragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Product;

import java.util.List;

public class Data1 {

    @SerializedName("product")
    @Expose
    private List<ProductList> product = null;
    @SerializedName("product_image_path")
    @Expose
    private String productImagePath;

    public List<ProductList> getProduct1() {
        return product;
    }

    public void setProduct(List<ProductList> product) {
        this.product = product;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

}
