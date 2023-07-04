package com.example.bikerentapp;


public class CatagorieModel {
    private int Image;
    private String TitleName;

    public int getImage() {
        return Image;
    }

    public String getTitleName() {
        return TitleName;
    }

    public CatagorieModel()
    {

    }
    public CatagorieModel(int image, String titleName) {
        Image = image;
        TitleName = titleName;
    }
}