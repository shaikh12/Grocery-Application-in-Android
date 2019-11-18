package com.infodart.salman.Pojo_Classes.Others;

public class Pojo {

    String title;
    String Desciption;
    int Image;

    public Pojo(String title, String desciption,int image){
        this.title=title;
        this.Desciption=desciption;
        this.Image=image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getImage() {
        return Image;
    }

    public void setDesciption(String desciption) {
        Desciption = desciption;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Desciption;
    }

    public int getImages() {
        return Image;
    }
}
