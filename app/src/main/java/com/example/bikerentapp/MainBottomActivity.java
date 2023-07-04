package com.example.bikerentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainBottomActivity extends AppCompatActivity {

    private ImageButton home,StoreCart,shoppingPoint,Post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom);
        home=findViewById(R.id.home);
        StoreCart=findViewById(R.id.store);
        shoppingPoint=findViewById(R.id.ShoppingPoint);
        Post=findViewById(R.id.Post);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DashbordMainFaragments()).commit();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DashbordMainFaragments()).commit();

            }
        });
        StoreCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBottomActivity.this, "Store Room", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new StoreCartFragments()).commit();

            }
        });

    }
}