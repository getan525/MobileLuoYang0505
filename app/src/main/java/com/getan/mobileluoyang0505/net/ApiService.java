package com.getan.mobileluoyang0505.net;


import com.getan.mobileluoyang0505.bean.BannerBean;
import com.getan.mobileluoyang0505.bean.HomeCateBean;
import com.getan.mobileluoyang0505.bean.HomePageBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String AGENT_HEADER = "User-Agent: NETS_Android";
    String COOKIE_HEADER = "Cookie: ntes_open_client_i=android#5.1.3#de701f3637ddfe2b11b22b22db9b6c6413dc2370#v7_1wan#6.0";
    String TOKEN_HEADER = "mob-token: 56d054805dd4ba1c4dfc69c8ac3309fe60b433af7a85508f36d9a2fed9df08f054e66aad739173e4e5cf96fb76749c2bfe09682e6e112ee8f27a62be4dfeb2cc4f207ca775f24ec77cfa8c26340bc7bfac8be6e1ba318dfbbcf25e4d6a5403edd677533282a681eac2ae33622b670eb211d8b17647947328599231e566bc5e513fa3c09029523360055dba2b34db1786";

    @GET("/tools/service/getNewsCate")
    Observable<HomeCateBean> getCate();

    /**
     * 参考这篇文章：https://www.jianshu.com/p/946d6c923820     retrofit和okhttp请求url的参数拼接
     *
     *  https://192.168.1.101/api/MovieList/2018
     *  分析：2018为动态可变部分，代表指定idMovie，api/MovieList/{movieId}
     *  Observable<ResultEntity<MovieEntity>> getMovieList(@Path("movieId") String movieId )
     *
     * @param cate
     * @return
     */
    @GET("/tools/service/getNewsList/{cate}")
    Observable<HomePageBean> getHomePage(@Path("cate") String cate);


    //轮播图接口，采用的OClient应用里的轮播图接口
    @Headers({AGENT_HEADER,
            COOKIE_HEADER,
            TOKEN_HEADER})
    @GET("/open/mob/subscribe/home.do")
    Observable<BannerBean> getBannerInfo(@Query("position") int position, @Query("rtypes") String rTypes);
}
