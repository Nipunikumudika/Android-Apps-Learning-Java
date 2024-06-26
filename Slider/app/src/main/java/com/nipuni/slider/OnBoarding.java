package com.nipuni.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    Button btn;
    Button next_btn;

    SliderAdapter sliderAdapter;
    TextView[] dots;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        btn=findViewById(R.id.get_started_btn);
        next_btn = findViewById(R.id.next_btn);
        addDots(0);

        viewPager.addOnPageChangeListener(changeListener);

        //hide toolbar
        getSupportActionBar().hide();

        //Call Adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = viewPager.getCurrentItem();
                viewPager.setCurrentItem(position+1);
            }
        });

        dotsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = viewPager.getCurrentItem();
                viewPager.setCurrentItem(position+1);
            }
        });

    }

    private void addDots(int position){
        dots = new TextView[3];
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.purple_700));
        }

    }
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            if(position == 2){
                btn.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

