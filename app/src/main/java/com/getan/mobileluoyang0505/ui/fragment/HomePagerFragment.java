package com.getan.mobileluoyang0505.ui.fragment;

import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.base.BaseFragment;
import com.getan.mobileluoyang0505.bean.HomeCateBean;

public class HomePagerFragment extends BaseFragment {
    public static HomePagerFragment newInstance(HomeCateBean.DataBean.CateListBean cateListBean) {
        HomePagerFragment homePagerFragment = new HomePagerFragment();
        return homePagerFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    protected void initView() {

    }
}
