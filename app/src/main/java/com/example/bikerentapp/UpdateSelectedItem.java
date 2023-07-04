package com.example.bikerentapp;

import java.util.ArrayList;

public interface UpdateSelectedItem {
    void addItem(String name, String Price, String image);
    ArrayList<OrderConformModel> getItem();

}
