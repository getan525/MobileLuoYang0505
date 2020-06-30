package com.getan.mobileluoyang0505.mvp.presenter.impl;

import com.getan.mobileluoyang0505.base.BasePresenterImpl;
import com.getan.mobileluoyang0505.mvp.ApiCompleteListenter;
import com.getan.mobileluoyang0505.mvp.model.IHomeModel;
import com.getan.mobileluoyang0505.mvp.model.impl.HomeModelImpl;
import com.getan.mobileluoyang0505.mvp.presenter.IHomePresenter;
import com.getan.mobileluoyang0505.mvp.view.IHomeView;

/**
 * Created by Administrator on 2020/5/5.
 * 邮箱：405181076@qq.com
 */
public class HomePresenterImpl extends BasePresenterImpl<IHomeView> implements IHomePresenter, ApiCompleteListenter {
    private IHomeModel mIHomeModel;
    public HomePresenterImpl(){
        mIHomeModel = new HomeModelImpl();
    }

    @Override
    public void requestHomeCateData() {
        mIHomeModel.getHomeCategory(this);

        mV.showLoading();
    }


    @Override
    public void onCompleted(Object result) {
        mV.loadData(result);
        mV.hideLoading();
    }

    @Override
    public void onFailed() {
        mV.showMsg();
    }
}
