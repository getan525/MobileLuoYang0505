package com.getan.mobileluoyang0505.mvp.presenter.impl;

import android.content.Context;
import android.util.Log;

import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.base.BasePresenterImpl;
import com.getan.mobileluoyang0505.mvp.ApiCompleteListener;
import com.getan.mobileluoyang0505.mvp.model.IHomePageModel;
import com.getan.mobileluoyang0505.mvp.model.impl.HomePageModelImpl;
import com.getan.mobileluoyang0505.mvp.presenter.IHomePagePresenter;
import com.getan.mobileluoyang0505.mvp.view.IHomePageView;
import com.getan.mobileluoyang0505.utils.NetworkUtils;

public class HomePagePresenterImpl extends BasePresenterImpl<IHomePageView> implements IHomePagePresenter, ApiCompleteListener {
    IHomePageModel mIHomePageModel;
    Context mContext;
    public HomePagePresenterImpl(Context context){
        this.mIHomePageModel = new HomePageModelImpl();
        this.mContext = context;
    }
    @Override
    public void getHomePageData(String cate) {

        mIHomePageModel.getHomePageModel(this,cate);
        mV.showLoading();
        if (!NetworkUtils.isConnected(mContext)){
            mV.showMsg(mContext.getString(R.string.net_error));
            mV.hideLoading();
        }
    }

    @Override
    public void getHomePageBannerData() {
        mIHomePageModel.getHomePageBanner(this);
        mV.showLoading();
        if (!NetworkUtils.isConnected(mContext)){
            mV.showMsg(mContext.getString(R.string.net_error));
            mV.hideLoading();
        }
    }

    @Override
    public void onCompleted(Object result) {
        mV.loadPageData(result);

    }

    @Override
    public void onBannerCompleted(Object result) {
        Log.d("", "onBannerCompleted: =====================");
        mV.loadPageBanner(result);
    }

    @Override
    public void onFailed(String s) {
        Log.d("onFailed", "onFailed: showmsg的内容是="+s);
        if (s != null){

        mV.showMsg(s);
        }
    }
}
