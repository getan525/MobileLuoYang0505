package com.getan.mobileluoyang0505.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BaseMvpFragment< P extends BasePresenterImpl> extends BaseFragment implements IBaseView{
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract P getPresenter();

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
