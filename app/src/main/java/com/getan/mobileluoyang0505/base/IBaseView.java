package com.getan.mobileluoyang0505.base;

/**
 * Created by Administrator on 2020/5/5.
 * 邮箱：405181076@qq.com
 */
public interface IBaseView {
    //显示进度中
    void showLoading();
    //关闭进度
    void hideLoading();
    //提示信息
    void showMsg();

    //显示请求成功
    //void showSuccess();


    //失败重试
    //void showFailed();

    //显示当前网络不可用
    //void showNoNet();

    //重试
    //void onRetry();
}
