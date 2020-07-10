package com.getan.mobileluoyang0505.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.base.BaseMvpFragment;
import com.getan.mobileluoyang0505.bean.BannerBean;
import com.getan.mobileluoyang0505.bean.HomeCateBean;
import com.getan.mobileluoyang0505.bean.HomePageBean;
import com.getan.mobileluoyang0505.mvp.presenter.impl.HomePagePresenterImpl;
import com.getan.mobileluoyang0505.mvp.view.IHomePageView;
import com.getan.mobileluoyang0505.ui.adapter.MyBannerAdapter;
import com.getan.mobileluoyang0505.ui.adapter.MyPageListAdapter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class HomePagerFragment extends BaseMvpFragment<HomePagePresenterImpl> implements IHomePageView, ViewPager.OnPageChangeListener {
    HomePageBean mHomePageBean;
    BannerBean mBannerBean;
    @BindView(R.id.rc_home_page)
    RecyclerView mRecyclerView;
    @BindView(R.id.vp_banner)
    ViewPager vp_banner;
    @BindView(R.id.ll_point)
    LinearLayout ll_point;
    private MyPageListAdapter mMyPageListAdapter;
    private MyBannerAdapter mMyBannerAdapter;
    private ImageView mIv_point;
    private ImageView[] mImageViews_points;
    private int bannerPageIndex = 0;

    public static HomePagerFragment newInstance(HomeCateBean.DataBean.CateListBean cateListBean) {
        HomePagerFragment homePagerFragment = new HomePagerFragment();
        Bundle bundle = new Bundle();
        String cate = cateListBean.getCate();
        String cateId = cateListBean.getCateId();
        bundle.putString("cate",cate);
        homePagerFragment.setArguments(bundle);
        return homePagerFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mMyPageListAdapter = new MyPageListAdapter(getContext());
        mRecyclerView.setAdapter(mMyPageListAdapter);

        mMyBannerAdapter = new MyBannerAdapter();
        vp_banner.setAdapter(mMyBannerAdapter);
        Log.d("HomePagerFragment", "mMyBannerAdapter = new MyBannerAdapter();<<<<<<<<<<<<<<<");

        vp_banner.addOnPageChangeListener(this);

    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String cate = arguments.getString("cate");
        mPresenter.getHomePageData(cate);

        mPresenter.getHomePageBannerData();
    }

    @Override
    public void loadPageData(Object result) {
        mHomePageBean = (HomePageBean) result;
        List<HomePageBean.DataBean.NewsListBean> news_list = mHomePageBean.getData().getNews_list();
        mMyPageListAdapter.sendData(news_list);


    }

    @Override
    public void loadPageBanner(Object result) {
        mBannerBean = (BannerBean) result;
        List<BannerBean.DataBean> data = mBannerBean.getData();
        mMyBannerAdapter.sendData(data);

        mImageViews_points = new ImageView[data.size()];

        for (int i = 0; i < data.size(); i++) {
            mIv_point = new ImageView(getContext());

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10,10,10,10);
            mIv_point.setLayoutParams(lp);
            mIv_point.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageViews_points[i] = mIv_point;
            //iv_point.setPadding(10,10,10,10);
            if (i==0){
                mImageViews_points[i].setBackgroundResource(R.drawable.shape_point_orange);
            }else {
                mImageViews_points[i].setBackgroundResource(R.drawable.shape_point_white);
            }
            ll_point.addView(mImageViews_points[i]);
        }

        autoBanner();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMsg(String s) {

    }


    @Override
    protected HomePagePresenterImpl getPresenter() {
        return new HomePagePresenterImpl(getContext());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < mBannerBean.getData().size(); i++) {
            mImageViews_points[i].setBackgroundResource(R.drawable.shape_point_orange);
            if (i != position){
                mImageViews_points[i].setBackgroundResource(R.drawable.shape_point_white);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 自动轮播线程
     */
    /*private void autoBannerThread(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                if (bannerPageIndex < (mBannerBean.getData().size()-1)){
                    bannerPageIndex ++;
                }else {
                    bannerPageIndex = 0;
                }

                //在fragment里用runOnUiThread必须添加getActivity()
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //设置选中的白点
                        mImageViews_points[bannerPageIndex].setBackgroundResource(R.drawable.shape_point_orange);
                        //设置viewPager现实的页面            false 表示不显示动画效果
                        vp_banner.setCurrentItem(bannerPageIndex, false);
                    }
                });
            }
        }.start();
    }*/





    public void autoBanner() {

        //自动切换
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (bannerPageIndex < (mBannerBean.getData().size() - 1)) {
                    bannerPageIndex++;
                } else { //最后一张后切换为第一页
                    bannerPageIndex = 0;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //设置选中的白点
                        //mImageViews_points[bannerPageIndex].setImageResource(R.drawable.shape_point_orange);
                        for (int i = 0; i < mBannerBean.getData().size(); i++) {
                            mImageViews_points[i].setBackgroundResource(R.drawable.shape_point_orange);
                            if (i != bannerPageIndex){
                                mImageViews_points[i].setBackgroundResource(R.drawable.shape_point_white);
                            }
                        }
                        //设置viewPager现实的页面            false 表示不显示动画效果
                        vp_banner.setCurrentItem(bannerPageIndex, false);
                    }
                });
            }
        };
        //表示一开始暂停5秒，然后每3秒执行一次run方法
        timer.schedule(task, 5000, 3000);
    }
}
