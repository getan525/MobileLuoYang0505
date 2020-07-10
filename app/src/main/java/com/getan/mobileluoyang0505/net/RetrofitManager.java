package com.getan.mobileluoyang0505.net;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {


    /**
     * 设置拦截器 打印日志
     *
     * @return
     */
    private static Interceptor getInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //显示日志
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    private static OkHttpClient getOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .build();
        return okHttpClient;
    }

    public static ApiService getApiService(){
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BaseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

        return mRetrofit.create(ApiService.class);


    }

    public static ApiService getApiService_2(){
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BaseURL_2)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

        return mRetrofit.create(ApiService.class);


    }

}
