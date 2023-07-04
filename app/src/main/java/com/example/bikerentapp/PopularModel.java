package com.example.bikerentapp;

public class PopularModel {
    private String userName;
    private String Rating;
    private int ImagePop;
    private String Desc;

    public PopularModel()
    {

    }

    public PopularModel(String userName, String rating, int imagePop, String desc) {
        this.userName = userName;
        Rating = rating;
        ImagePop = imagePop;
        Desc = desc;
    }

    public String getUserName() {
        return userName;
    }

    public String getRating() {
        return Rating;
    }

    public int getImagePop() {
        return ImagePop;
    }

    public String getDesc() {
        return Desc;
    }
}
