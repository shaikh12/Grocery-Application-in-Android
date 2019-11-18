package com.infodart.salman.Pojo_Classes.Others;

public class Pojo_Cart_Category {

    String discount,title,description;
    int images;

    public Pojo_Cart_Category(String discount, String title, String description, int images) {

        this.discount = discount;
        this.title = title;
        this.description = description;
        this.images=images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getImages() {
        return images;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
