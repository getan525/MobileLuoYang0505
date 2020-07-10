package com.getan.mobileluoyang0505.mvp.presenter.impl;

import android.content.Context;

import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.base.BasePresenterImpl;
import com.getan.mobileluoyang0505.mvp.ApiCompleteListener;
import com.getan.mobileluoyang0505.mvp.model.IHomeModel;
import com.getan.mobileluoyang0505.mvp.model.impl.HomeModelImpl;
import com.getan.mobileluoyang0505.mvp.presenter.IHomePresenter;
import com.getan.mobileluoyang0505.mvp.view.IHomeView;
import com.getan.mobileluoyang0505.utils.NetworkUtils;

/**
 * Created by Administrator on 2020/5/5.
 * 邮箱：405181076@qq.com
 */
public class HomePresenterImpl extends BasePresenterImpl<IHomeView> implements IHomePresenter, ApiCompleteListener {
    private IHomeModel mIHomeModel;
    private Context mContext;
    public HomePresenterImpl(Context context){
        mIHomeModel = new HomeModelImpl();
        this.mContext = context;
    }

    @Override
    public void requestHomeCateData() {

        if(!NetworkUtils.isConnected(mContext)){
            mV.showMsg(mContext.getString(R.string.net_error));
            mV.hideLoading();
        }
        mIHomeModel.getHomeCategory(this);
        mV.showLoading();
    }


    @Override
    public void onCompleted(Object result) {
        mV.loadData(result);
        mV.hideLoading();
    }

    @Override
    public void onBannerCompleted(Object result) {

    }

    @Override
    public void onFailed(String s) {
        mV.showMsg(s);
    }
}
