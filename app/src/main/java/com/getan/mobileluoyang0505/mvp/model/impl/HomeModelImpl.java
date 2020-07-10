package com.getan.mobileluoyang0505.mvp.model.impl;

import android.util.Log;

import com.getan.mobileluoyang0505.bean.HomeCateBean;
import com.getan.mobileluoyang0505.mvp.ApiCompleteListener;
import com.getan.mobileluoyang0505.mvp.model.IHomeModel;
import com.getan.mobileluoyang0505.net.ApiService;
import com.getan.mobileluoyang0505.net.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class HomeModelImpl implements IHomeModel {
    ApiService mApiService = RetrofitManager.getApiService();
    @Override
    public void getHomeCategory(ApiCompleteListener listener) {


        mApiService.getCate()
                .subscribeOn(Schedulers.io())    //请求在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行;
                .subscribe(new Observer<HomeCateBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeCateBean homeCateBean) {
                        listener.onCompleted(homeCateBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e.toString());
                        Log.d("====", "loadData: //////////////////////////////////////");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
