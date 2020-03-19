package com.bliss.print.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.bliss.print.R;
import com.bliss.print.adapter.JobAdapter;
import com.bliss.print.model.JobDescribe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragmentItem1 extends Fragment {
   List<JobDescribe.JobBean> jobBeans = new ArrayList<>();
    private static final String TAG = "HomeFragmentItem1";

   private RecyclerView recyclerView;
    public HomeFragmentItem1() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragmentItem1 newInstance() {
        HomeFragmentItem1 fragment = new HomeFragmentItem1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment_item1, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        initView();
        return view;
    }

    private void initView() {
        if (jobBeans != null) {
            jobBeans.clear();
        }
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = getActivity().getAssets().open("job.json");
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4 * 1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            final String json = new String(bos.toByteArray());
            final JobDescribe jobDescribe = JSON.parseObject(json, JobDescribe.class);
            jobBeans.addAll(jobDescribe.getJob());
            for (int i = 0; i < jobBeans.size(); i++) {
                switch (i){
                    case 0:
                        jobBeans.get(0).setImg(R.drawable.hr1);
                        break;
                    case 1:
                        jobBeans.get(1).setImg(R.drawable.hr2);
                        break;
                    case 2:
                        jobBeans.get(2).setImg(R.drawable.hr3);
                        break;
                        default:
                }
            }
            JobAdapter jobAdapter = new JobAdapter(jobBeans);
            recyclerView.setAdapter(jobAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                Log.e(TAG, "getStates", e);
            }
        }


    }

}
