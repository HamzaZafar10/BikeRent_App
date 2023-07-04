package com.example.bikerentapp;

public class RentBikeModel {
    String BikeName,Date,Time,PhoneNumber,Image,RentPrice,Model,Des,RenterName;
    public RentBikeModel()
    {
        
    }
    public RentBikeModel(String name,String image,String rentPrice)
    {
        BikeName=name;
        Image=image;
        RentPrice=rentPrice;

    }

    public RentBikeModel(String model,String rentPrice,String Desc,String BikeNam,String image)
    {
        Model=model;
        BikeName=BikeNam;
        RentPrice=rentPrice;
        Des=Desc;
        Image=image;

    }

    public String getRenterName() {
        return BikeName;
    }


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getRentPrice() {
        return RentPrice;
    }

    public void setRentPrice(String rentPrice) {
        RentPrice = rentPrice;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public void setRenterName(String renterName) {
        RenterName = renterName;
    }

    public String getBikeName() {
        return BikeName;
    }

    public void setBikeName(String bikeName) {
        BikeName = bikeName;
    }

    public RentBikeModel(String renterName, String date, String time, String phoneNumber, String rentPrice, String image) {
        RenterName = renterName;
        Date = date;
        Time = time;
        PhoneNumber = phoneNumber;
        Image = image;
        RentPrice = rentPrice;
    }
}
