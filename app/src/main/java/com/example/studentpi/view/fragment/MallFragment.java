package com.example.studentpi.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.studentpi.R;
import com.example.studentpi.model.Bean.MultipleItem;
import com.example.studentpi.view.adapter.MultipleItemAdapter;
import com.example.studentpi.view.sources.NavigationBar;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bingoogolapple.bgabanner.BGABanner;

public class MallFragment extends BaseFragment {

    private View rootView;
    private RecyclerView recyclerView;
    private BGABanner bgaBanner;
    private Toolbar navigationBar;
    private List<MultipleItem> itemList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_mall, container, false);
        initView();


        return rootView;

    }

    private void initView() {
        navigationBar = rootView.findViewById(R.id.navigation);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        bgaBanner = rootView.findViewById(R.id.banner);
//        navigationBar.setTitleColor(Color.parseColor("#ffffff"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();


    }

    private void initData() {
        bgaBanner.setAdapter(new BGABanner.Adapter<ImageView, Integer>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable Integer model, int position) {
                Glide.with(getActivity()).load(model).fitCenter().dontAnimate().into(itemView);

            }
        });
        bgaBanner.setData(Arrays.asList(R.mipmap.cola, R.mipmap.rou, R.mipmap.milk), Arrays.asList("", "", ""));

        itemList.add(new MultipleItem(MultipleItem.GRID));
        MultipleItem multipleItem = new MultipleItem(MultipleItem.CARD);
        for (int i = 0; i < 10; i++) {
            itemList.add(multipleItem);

        }


        recyclerView.setAdapter(new MultipleItemAdapter(itemList, getContext()));

    }
}
