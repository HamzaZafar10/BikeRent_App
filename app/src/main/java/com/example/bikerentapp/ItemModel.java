package com.example.bikerentapp;

public class ItemModel {
    private String Image;
    private String Title;
    private String Desc;
    private String key;
    private String priceShow;
    private int Discount,Price;
    private String Dis;

    public String getDis() {
        return Dis;
    }

    public void setDis(String dis) {
        Dis = dis;
    }

    public ItemModel(String image, String title, String desc, int price) {
        Image = image;
        Title = title;
        Desc = desc;
        Price = price;
    }
    public ItemModel(String image, String title, String desc, String price) {
        Image = image;
        Title = title;
        Desc = desc;
        priceShow = price;
    }

    public ItemModel()
    {

    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPriceShow() {
        return priceShow;
    }

    public void setPriceShow(String priceShow) {
        this.priceShow = priceShow;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
