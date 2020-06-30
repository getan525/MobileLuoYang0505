package com.getan.mobileluoyang0505.base;

/**
 * Created by Administrator on 2020/5/5.
 * 邮箱：405181076@qq.com
 */
public abstract class BasePresenterImpl<V extends IBaseView> {

    protected V mV;

    void attachView(V view){
        this.mV = view;
    }


    void detachView(){
        this.mV = null;
    }

}
/*
*//**
 * T 泛型，指的是baseview，当然也可以是其他的view 类型
 * Created by zhengshaorui on 2017/6/22.
 *//*
public abstract class BasePresenter<T> {    // 获取 view 的view 实例
    T view;

    void onAttach(T view) {
        this.view = view;
    }

      // 解绑 view 层

    void onDetch() {
        this.view = null;
    }
    // view 数据的开始，一般再 oncreate 或者 onresume 中
// void start();}*/
