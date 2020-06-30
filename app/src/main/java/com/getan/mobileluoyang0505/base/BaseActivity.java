package com.getan.mobileluoyang0505.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2020/5/5.
 * 邮箱：405181076@qq.com
 */
public abstract class BaseActivity extends AppCompatActivity {
    Unbinder mUnbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
         mUnbinder = ButterKnife.bind(this);
         initView();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
