package com.bliss.print.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bliss.print.R;
import com.bliss.print.fragments.HomeFragment;
import com.bliss.print.fragments.MeFragment;
import com.bliss.print.fragments.MessageFragment;
import com.bliss.print.fragments.ResumeFragment;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static final int []mTabRes = new int[]{R.drawable.home_default,R.drawable.message_default,R.drawable.resume_default,R.drawable.me_default};
    public static final int []mTabResPressed = new int[]{R.drawable.home_select,R.drawable.message_select,R.drawable.resume_select,R.drawable.me_select};
    public static final String []mTabTitle = new String[]{"首页","消息","简历","我的"};

    public static List<Fragment> getFragments(String from){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance(from));
        fragments.add(MessageFragment.newInstance(from));
        fragments.add(ResumeFragment.newInstance(from));
        fragments.add(MeFragment.newInstance(from));
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content,null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}
