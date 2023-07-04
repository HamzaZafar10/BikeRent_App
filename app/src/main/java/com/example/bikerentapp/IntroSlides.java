package com.example.bikerentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class IntroSlides extends AppCompatActivity {

    public static ViewPager viewPager;
    SlideViewPagerAdapter adapter;
FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
if(auth.getCurrentUser()!=null)
{
    Intent intent=new Intent(getApplicationContext(),SignMainAcitivity.class);
    startActivity(intent);
    finish();
}

        viewPager = findViewById(R.id.viewpager);
        adapter = new SlideViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }
}