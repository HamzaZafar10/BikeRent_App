package com.example.bikerentapp;

public class SaleBickeModel {
    private String BickModel;
    private String BikePrice;
    private String BikeDesc;
    private int FireBaseBikePrice;
    private String Image;
public SaleBickeModel()
{

}

    public String getBickModel() {
        return BickModel;
    }

    public void setBickModel(String bickModel) {
        BickModel = bickModel;
    }

    public String getBikePrice() {
        return BikePrice;
    }

    public void setBikePrice(String bikePrice) {
        BikePrice = bikePrice;
    }

    public String getBikeDesc() {
        return BikeDesc;
    }

    public void setBikeDesc(String bikeDesc) {
        BikeDesc = bikeDesc;
    }

    public String getBikeName() {
        return BikeName;
    }

    public void setBikeName(String bikeName) {
        BikeName = bikeName;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public SaleBickeModel(String bickModel, int bikePrice, String bikeDesc, String bikeName, String Image) {
        BickModel = bickModel;
        FireBaseBikePrice = bikePrice;
        BikeDesc = bikeDesc;
        BikeName = bikeName;
        this.Image=Image;

}

    public int getFireBaseBikePrice() {
        return FireBaseBikePrice;
    }

    public void setFireBaseBikePrice(int fireBaseBikePrice) {
        FireBaseBikePrice = fireBaseBikePrice;
    }

    public SaleBickeModel(String bickModel, String bikePrice, String bikeDesc, String bikeName, String Image) {
        BickModel = bickModel;
        BikePrice = bikePrice;
        BikeDesc = bikeDesc;
        BikeName = bikeName;
        this.Image=Image;

    }

    private String BikeName;
}
