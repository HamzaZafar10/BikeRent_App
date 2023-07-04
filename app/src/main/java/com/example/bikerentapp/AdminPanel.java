package com.example.bikerentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class AdminPanel extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        drawerLayout=findViewById(R.id.navigation_draw);
        toolbar=findViewById(R.id.toolBar);
        navigationView=findViewById(R.id.navigationBar);
        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.Open_navigation_bar,R.string.Close_navigation_Bar
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1,new AdminFragmentsPannel()).commit();
            navigationView.setCheckedItem(R.id.dashbord);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.Insert_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1,new InsetedItem()).commit();
                break;
            case R.id.dashbord:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1,new AdminFragmentsPannel()).commit();
                break;
            case R.id.BuyBikesAdd:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1,new BuyBikesInsertionFragments()).commit();
                break;
            case R.id.RentBike:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1,new BikeRentInsertionFragments()).commit();
                    break;

            case R.id.home:
                Intent intent=new Intent(getApplicationContext(),MainBottomActivity.class);
                startActivity(intent);
                finish();
            break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}