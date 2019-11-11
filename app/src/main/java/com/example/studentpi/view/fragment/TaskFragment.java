package com.example.studentpi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentpi.R;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class TaskFragment extends BaseFragment {

    private String[] mTabTitle = {"全部", "跑腿", "占座", "拿快递"}; // 标题

    private View rootView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_task, container, false);
        initView();


        return rootView;

    }

    private void initView() {
        tabLayout = rootView.findViewById(R.id.tab_layout);
        viewPager = rootView.findViewById(R.id.view_pager);
        viewPager.setAdapter(new FragmentAdapter(getActivity().getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);

        for(int i=0;i<mTabTitle.length;i++)
        {
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);

        for(int i=0;i<mTabTitle.length;i++)
        {
            tabLayout.getTabAt(i).setText(mTabTitle[i]);
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {


    }

    private class FragmentAdapter extends FragmentPagerAdapter {


        public FragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
              Fragment fragment=new TaskDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type",mTabTitle[position]);
            fragment.setArguments(bundle);


            return fragment;
        }

        @Override
        public int getCount() {
            return mTabTitle.length;
        }
    }
}
