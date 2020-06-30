package com.getan.mobileluoyang0505.mvp.view;

import com.getan.mobileluoyang0505.base.IBaseView;

/**
 * Created by Administrator on 2020/5/5.
 * 邮箱：405181076@qq.com
 */
public interface IHomeView extends IBaseView {
    /**
     * 加载数据与UI相关的接口
     */
    //void loadData(List<HomeCateBean> cates);
    void loadData(Object result);
   /* void loadDataEmpty();
    void loadDataError();
    void loadingData();*/



    /**
     * 加载更多与UI相关的接口
     */
   /* void loadMoreData();
    void loadMoreDataError();
    void loadingMoreData();*/

}
