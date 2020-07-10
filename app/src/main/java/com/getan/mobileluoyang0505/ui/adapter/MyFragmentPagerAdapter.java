package com.getan.mobileluoyang0505.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.getan.mobileluoyang0505.bean.HomeCateBean;
import com.getan.mobileluoyang0505.ui.fragment.HomePagerFragment;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "MyFragmentPagerAdapter";
    List<HomeCateBean.DataBean.CateListBean> mCateListBeans = new ArrayList<>();
    List<String> mList = new ArrayList<>();

    public MyFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public MyFragmentPagerAdapter(FragmentManager childFragmentManager) {
        super(childFragmentManager);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mCateListBeans.get(position).getCateName();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        HomeCateBean.DataBean.CateListBean cateListBean = mCateListBeans.get(position);
        HomePagerFragment pagerFragment = HomePagerFragment.newInstance(cateListBean);

        return pagerFragment;
    }

    @Override
    public int getCount() {
        return mCateListBeans.size();
    }


    public void setCateList(List<HomeCateBean.DataBean.CateListBean> cate_list) {
        this.mCateListBeans = cate_list;
        /*for (HomeCateBean.DataBean.CateListBean cateListBean : cate_list) {
            String cateName = cateListBean.getCateName();
            mList.add(cateName);
        }*/
    }
}
