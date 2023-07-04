package com.example.bikerentapp;

public class OrderConformModel {
        private String ProductName,Image;
        String Price;
        public OrderConformModel()
        {

        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String productName) {
            ProductName = productName;
        }

        public String getPrice() {
            return Price;
        }



        public String getImage() {
            return Image;
        }

        public void setImage(String  image) {
            Image = image;
        }

    public OrderConformModel(String productName, String price, String  image) {
            ProductName = productName;
            Price = price;
            Image = image;
        }
    }


