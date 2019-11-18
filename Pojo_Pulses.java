package com.infodart.salman.Pojo_Classes.Others;

public class Pojo_Pulses {

    int Images;
    String Pulses_price;
    String Pulses_actual_price;
    String pulses_discount;
    String Pulses_description;
    String Pulses_quantity;
    int Heart_image;
    int Addbtn;

    public Pojo_Pulses( int Images,String Pulses_price,String Pulses_actual_price,String pulses_discount
            ,int Heart_image,String Pulses_description,String Pulses_quantity, int addbtn){

        this.Images=Images;
        this.Pulses_price=Pulses_price;
        this.Pulses_actual_price=Pulses_actual_price;
        this.pulses_discount=pulses_discount;
        this.Heart_image=Heart_image;
        this.Pulses_description=Pulses_description;
        this.Pulses_quantity=Pulses_quantity;
        this.Addbtn=addbtn;
    }

    public int getImages() {
        return Images;
    }

    public String getPulses_price() {
        return Pulses_price;
    }

    public String getPulses_actual_price() {
        return Pulses_actual_price;
    }

    public String getPulses_discount() {
        return pulses_discount;
    }

    public int getHeart_image() {
        return Heart_image;
    }

    public String getPulses_desciption() {
        return Pulses_description;
    }

    public String getPulse_quantity() {
        return Pulses_description;
    }

    public int getAddbtn() {
        return Addbtn;
    }

}
