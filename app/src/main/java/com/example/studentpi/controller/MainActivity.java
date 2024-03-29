package com.example.studentpi.controller;


import com.example.studentpi.R;
import com.example.studentpi.view.fragment.MallFragment;
import com.example.studentpi.view.fragment.MyFragment;
import com.example.studentpi.view.fragment.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private BottomNavigationView bottomNavigationView;

    private List<Fragment> fragments = new ArrayList<>();
    private FrameLayout frameLayout;


    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.frame_layout);


//        NavigationBar navigationBar = findViewById(R.id.title);
//        navigationBar.setLeftImageResource(R.mipmap.nav_back);
//        navigationBar.setTitle("学生派");
//        navigationBar.setBackgroundColor(Color.parseColor("#ffffff"));

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_task:
                        setFragmentPosition(0);
                        break;
                    case R.id.menu_mall:
                        setFragmentPosition(1);
                        break;
                    case R.id.menu_my:
                        setFragmentPosition(2);
                        break;
                }
                return true;
            }
        });

    }

    private void setFragmentPosition(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragments.get(position));
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void initData() {
        fragments.add(new TaskFragment());
        fragments.add(new MallFragment());
        fragments.add(new MyFragment());
        bottomNavigationView.setSelectedItemId(R.id.menu_task);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void doOnClick(View v) {

    }
}
