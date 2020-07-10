package com.getan.mobileluoyang0505.mvp.model.impl;

import android.util.Log;

import com.getan.mobileluoyang0505.bean.BannerBean;
import com.getan.mobileluoyang0505.bean.HomePageBean;
import com.getan.mobileluoyang0505.mvp.ApiCompleteListener;
import com.getan.mobileluoyang0505.mvp.model.IHomePageModel;
import com.getan.mobileluoyang0505.net.ApiService;
import com.getan.mobileluoyang0505.net.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePageModelImpl implements IHomePageModel {
    ApiService mApiService = RetrofitManager.getApiService();
    @Override
    public void getHomePageModel(ApiCompleteListener completeListener, String cate) {
        mApiService.getHomePage(cate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomePageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomePageBean homePageBean) {
                        if (homePageBean!= null){

                        completeListener.onCompleted(homePageBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        completeListener.onFailed(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getHomePageBanner(ApiCompleteListener completeListener) {
        RetrofitManager.getApiService_2().getBannerInfo(1,"1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        if (bannerBean!= null){
                            Log.d("", "onNext: 111111111111111111111111111");
                        completeListener.onBannerCompleted(bannerBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        completeListener.onFailed(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
