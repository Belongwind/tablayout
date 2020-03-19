package com.bliss.print.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bliss.print.R;
import com.bliss.print.adapter.MyAdapter;
import com.bliss.print.banner.LocalImageHolderView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnItemClickListener{

    private ConvenientBanner convenientBanner;
    private TabLayout tab_layout;
    private ViewPager view_pager;
    private LinearLayout ll_shixi,ll_zhichang,ll_xuanjiang,ll_yinshua;

    private ArrayList<Integer> localImages = new ArrayList<Integer>();//本地轮播图片集合
    private List<Fragment> fragmentList = new ArrayList<>();

    public HomeFragment() {
    }
    public static Fragment newInstance(String from){
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        convenientBanner = view.findViewById(R.id.convenientBanner);
        tab_layout = view.findViewById(R.id.tab_layout);
        view_pager = view.findViewById(R.id.view_pager);
        ll_shixi = view.findViewById(R.id.ll_shixi);
        ll_zhichang = view.findViewById(R.id.ll_zhichang);
        ll_xuanjiang = view.findViewById(R.id.ll_xuanjiang);
        ll_yinshua = view.findViewById(R.id.ll_yinshua);
        ll_shixi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了实习职位",Toast.LENGTH_SHORT).show();
            }
        });
        ll_xuanjiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了企业宣讲会",Toast.LENGTH_SHORT).show();
            }
        });
        ll_yinshua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了印刷资讯",Toast.LENGTH_SHORT).show();
            }
        });
        ll_zhichang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了职场问答",Toast.LENGTH_SHORT).show();
            }
        });
        initNetCB();
        initView();
        return view;
    }

    private void initView() {
        fragmentList.add(HomeFragmentItem1.newInstance());
        fragmentList.add(HomeFragmentItem1.newInstance());
        fragmentList.add(HomeFragmentItem1.newInstance());
        fragmentList.add(HomeFragmentItem1.newInstance());
        MyAdapter fragmentAdater = new  MyAdapter(getChildFragmentManager(),fragmentList);
        view_pager.setAdapter(fragmentAdater);
        tab_layout.setupWithViewPager(view_pager);
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(2000);//轮播间隔
    }

    /**
     * 网络图片轮播
     */
    private void initNetCB() {
        localImages.add(R.drawable.home1);
        localImages.add(R.drawable.home2);
        localImages.add(R.drawable.home3);
        convenientBanner.setPages(
                new CBViewHolderCreator() {
                    @Override
                    public LocalImageHolderView createHolder(View itemView) {
                        return new LocalImageHolderView(itemView);
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_localimage;
                    }
                }, localImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focusedblue})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this);

    }

    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(),"点击了第"+position+"个",Toast.LENGTH_SHORT).show();
    }

}
