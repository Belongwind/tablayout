package com.bliss.print.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * tablayout相关adapter
 */
public class MyAdapter extends FragmentPagerAdapter {
    static final int NUM_ITEMS = 4;
    private List<Fragment> fragmentList;
    private String[] strings = new String[]{"推荐","印刷工程师","平面设计","图文排版"};

    public MyAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
