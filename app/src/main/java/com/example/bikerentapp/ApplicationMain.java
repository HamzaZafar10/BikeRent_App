package com.example.bikerentapp;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class ApplicationMain extends Application implements UpdateSelectedItem {

    private static Context context;
    ArrayList<OrderConformModel> list;


    @Override
    public void onCreate() {
        super.onCreate();

        context=getApplicationContext();
        list=new ArrayList<>();
    }
    public static Context getContext()
    {
        return context;

    }


    @Override
    public void addItem(String name, String Price, String image) {
        list.add(new OrderConformModel(name,Price,image));
    }

    @Override
    public ArrayList<OrderConformModel> getItem()
    {
        return list;
    }
}

