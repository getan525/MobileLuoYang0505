package com.getan.mobileluoyang0505.ui.fragment;

import androidx.viewpager.widget.ViewPager;

import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.base.BaseMvpFragment;
import com.getan.mobileluoyang0505.bean.HomeCateBean;
import com.getan.mobileluoyang0505.mvp.presenter.impl.HomePresenterImpl;
import com.getan.mobileluoyang0505.mvp.view.IHomeView;
import com.getan.mobileluoyang0505.ui.adapter.MyFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/10.
 * 邮箱：405181076@qq.com
 */
public class HomeFragment extends BaseMvpFragment<HomePresenterImpl> implements IHomeView {
    @BindView(R.id.tl_home)
    TabLayout tabLayout;
    @BindView(R.id.vp_home)
    ViewPager viewPager;
    //private IHomePresenter mPresenter;
    HomeCateBean mHomeCateBean;
    List<String> mList = new ArrayList<>();

    @Override
    protected HomePresenterImpl getPresenter() {

        return new HomePresenterImpl();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        //tableLayout.setTag();
        //tabLayout.addTab();

        //mPresenter.requestHomeCateData();
        mPresenter.requestHomeCateData();


    }

    @Override
    public void loadData(Object result) {
        mHomeCateBean = (HomeCateBean) result;

        MyFragmentPagerAdapter myAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        List<HomeCateBean.DataBean.CateListBean> cate_list = mHomeCateBean.getData().getCate_list();
        myAdapter.setCateList(cate_list);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        /*String cateName = mCateListBean.getCateName();
        mList.add(cateName);*/
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMsg() {

    }


}
