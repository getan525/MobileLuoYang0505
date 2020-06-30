package com.getan.mobileluoyang0505;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.getan.mobileluoyang0505.base.BaseActivity;
import com.getan.mobileluoyang0505.ui.fragment.HomeFragment;
import com.getan.mobileluoyang0505.ui.fragment.PeopleFragment;
import com.getan.mobileluoyang0505.ui.fragment.RechargeFragment;
import com.getan.mobileluoyang0505.ui.fragment.RecommendFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.fl_main)
    FrameLayout mFrameLayout;
    @BindView(R.id.navigation_bottom)
    BottomNavigationView mBottomNavigationView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initListener();
        switchFragment(0);
    }

    private void initListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_news:
                        switchFragment(0);
                        Log.d(TAG, "onNavigationItemSelected: navigation_news");
                        break;
                    case R.id.navigation_recommend:
                        switchFragment(1);
                        break;
                    case R.id.navigation_people:
                        switchFragment(2);
                        break;
                    case R.id.navigation_recharge:
                        switchFragment(3);
                        break;
                }
                return true;
            }
        });
    }

    private void switchFragment(int i) {

        HomeFragment homeFragment = new HomeFragment();
        RecommendFragment recommendFragment = new RecommendFragment();
        PeopleFragment peopleFragment = new PeopleFragment();
        RechargeFragment rechargeFragment = new RechargeFragment();

        List<Fragment> list = new ArrayList();
        list.add(homeFragment);
        list.add(recommendFragment);
        list.add(peopleFragment);
        list.add(rechargeFragment);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main,list.get(i));
        //fragmentTransaction.add(R.id.fl_main,list.get(i));
        fragmentTransaction.commit();
    }

    @Override
    protected void initData() {

    }


}
