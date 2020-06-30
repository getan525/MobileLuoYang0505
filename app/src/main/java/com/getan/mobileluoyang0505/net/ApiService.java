package com.getan.mobileluoyang0505.net;


import com.getan.mobileluoyang0505.bean.HomeCateBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/tools/service/getNewsCate")
    Observable<HomeCateBean> getCate();
}
