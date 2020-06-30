package com.getan.mobileluoyang0505.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2020/5/5.
 * 邮箱：405181076@qq.com
 */
public abstract class BaseFragment extends Fragment{


    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //View rootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), container);
        //View rootView = inflater.inflate(getLayoutId(), container, false);
        View mRootView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);

        initView();
        return mRootView;
    }



    protected abstract int getLayoutId();
    protected abstract void initView();
    protected void initData(){
    }



    @Override
    public void onDestroy() {
        super.onDestroy();



        if (mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
