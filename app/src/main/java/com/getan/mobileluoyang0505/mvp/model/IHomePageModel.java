package com.getan.mobileluoyang0505.mvp.model;

import com.getan.mobileluoyang0505.mvp.ApiCompleteListener;

public interface IHomePageModel {
    void getHomePageModel(ApiCompleteListener completeListener, String cate);
    void getHomePageBanner(ApiCompleteListener completeListener);
}
