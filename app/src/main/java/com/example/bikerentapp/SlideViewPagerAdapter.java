package com.example.bikerentapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_screen,container,false);


        ImageView logo=view.findViewById(R.id.logo);
        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);
        TextView title=view.findViewById(R.id.title);
        TextView desc=view.findViewById(R.id.desc);
        ImageView next=view.findViewById(R.id.next);
        ImageView back=view.findViewById(R.id.back);
        Button btnGetStarted=view.findViewById(R.id.btnGetStarted);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntroSlides.viewPager.setCurrentItem(position+1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntroSlides.viewPager.setCurrentItem(position-1);
            }
        });

        switch (position)
        {
            case 0:
                logo.setImageResource(R.drawable.image14);
                ind1.setImageResource(R.drawable.seleted);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                title.setText("Book Your Favourite \n Style list");
                desc.setText("All Artiest are brilliant and Honest and Talented Parson");
                back.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                break;
            case 1:
                logo.setImageResource(R.drawable.image7);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.seleted);
                ind3.setImageResource(R.drawable.unselected);
                title.setText("Best Baby Cutting \n   Master ");
                desc.setText("This is random text taking from lorem ipsum tesing puspose");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                break;
            case 2:
                logo.setImageResource(R.drawable.image8);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.seleted);

                title.setText("Select To Professional\n & Appointed Your Date");
                desc.setText("This is random text taking from lorem ipsum tesing puspose");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                break;
            case 3:
                logo.setImageResource(R.drawable.image9);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.seleted);
                title.setText("Shopping Now");
                desc.setText("This is random text taking from lorem ipsum tesing puspose");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.GONE);

                btnGetStarted.setVisibility(View.VISIBLE);
                btnGetStarted.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(ctx, SignIn.class);
                        ctx.startActivity(intent);
                        ((Activity)ctx).finish();
                    }
                });
                break;





        }


        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
