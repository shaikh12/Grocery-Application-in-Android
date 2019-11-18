package com.infodart.salman.Pojo_Classes.Model_HomePage;

public class OfferImage {

    public String image_path;
    public String image_path_arabic;
    private String supermarket_id;
    private String category_id;
    private String product_id;

    public String getSupermarket_id() {
        return supermarket_id;
    }

    public OfferImage setSupermarket_id(String supermarket_id) {
        this.supermarket_id = supermarket_id;
        return this;
    }

    public String getCategory_id() {
        return category_id;
    }

    public OfferImage setCategory_id(String category_id) {
        this.category_id = category_id;
        return this;
    }

    public String getProduct_id() {
        return product_id;
    }

    public OfferImage setProduct_id(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getImage_path() {
        return image_path;
    }

    public OfferImage setImage_path(String image_path) {
        this.image_path = image_path;
        return this;
    }

    public String getImage_path_arabic() {
        return image_path_arabic;
    }

    public OfferImage setImage_path_arabic(String image_path_arabic) {
        this.image_path_arabic = image_path_arabic;
        return this;
    }


}
