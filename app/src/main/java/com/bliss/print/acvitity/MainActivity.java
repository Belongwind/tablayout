package com.bliss.print.acvitity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bliss.print.R;
import com.bliss.print.adapter.MyViewPagerAdapter;
import com.bliss.print.fragments.HomeFragment;
import com.bliss.print.fragments.MeFragment;
import com.bliss.print.fragments.MessageFragment;
import com.bliss.print.fragments.ResumeFragment;
import com.bliss.print.utils.DataGenerator;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> mFragmensts = new ArrayList<>();
    private MyViewPagerAdapter adapter;
    private static final String TAG = "MainActivity";

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.view_pager)
    ViewPager view_pager;

    @BindView(R.id.ll_container)
    LinearLayout ll_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        mFragmensts.add(new HomeFragment());
        mFragmensts.add(new MessageFragment());
        mFragmensts.add(new ResumeFragment());
        mFragmensts.add(new MeFragment());
        adapter = new MyViewPagerAdapter(getSupportFragmentManager(),mFragmensts);
        view_pager.setAdapter(adapter);
        view_pager.setOffscreenPageLimit(3);
        view_pager.setCurrentItem(0,false);
        for(int i=0;i<4;i++){
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(DataGenerator.getTabView(this,i)));
        }
        chooseFirst();
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e(TAG, "onTabSelected: " + tab.getPosition());
                view_pager.setCurrentItem(tab.getPosition(),true);
                recoverItem();
                View view =tab.getCustomView();
                ImageView imageView = view.findViewById(R.id.tab_content_image);
                TextView textView = view.findViewById(R.id.tab_content_text);
                imageView.setImageDrawable(getResources().getDrawable(DataGenerator.mTabResPressed[tab.getPosition()]));
                textView.setTextColor(getResources().getColor(R.color.colorBlue));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    private void recoverItem() {
        for (int i = 0; i < 4; i++) {
            TabLayout.Tab tabAt =  mTabLayout.getTabAt(i);
            View view =tabAt.getCustomView();
            ImageView imageView = view.findViewById(R.id.tab_content_image);
            TextView textView = view.findViewById(R.id.tab_content_text);
            imageView.setImageDrawable(getResources().getDrawable(DataGenerator.mTabRes[i]));
            textView.setTextColor(Color.GRAY);
        }
    }

    private void chooseFirst() {
        TabLayout.Tab tabAt =  mTabLayout.getTabAt(0);
        View view =tabAt.getCustomView();
        ImageView imageView = view.findViewById(R.id.tab_content_image);
        TextView textView = view.findViewById(R.id.tab_content_text);
        imageView.setImageDrawable(getResources().getDrawable(DataGenerator.mTabResPressed[0]));
        textView.setTextColor(getResources().getColor(R.color.colorBlue));
    }

    @Override
    public void onBackPressed() {
    }
}
