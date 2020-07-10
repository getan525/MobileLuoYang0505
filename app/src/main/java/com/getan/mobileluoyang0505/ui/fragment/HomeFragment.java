package com.getan.mobileluoyang0505.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.SearchViewHolder;
import com.getan.mobileluoyang0505.base.BaseMvpFragment;
import com.getan.mobileluoyang0505.bean.HomeCateBean;
import com.getan.mobileluoyang0505.mvp.presenter.impl.HomePresenterImpl;
import com.getan.mobileluoyang0505.mvp.view.IHomeView;
import com.getan.mobileluoyang0505.ui.activity.SearchResultActivity;
import com.getan.mobileluoyang0505.ui.adapter.MyFragmentPagerAdapter;
import com.getan.mobileluoyang0505.utils.KeyBoardUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/10.
 * 邮箱：405181076@qq.com
 */
public class HomeFragment extends BaseMvpFragment<HomePresenterImpl> implements IHomeView, SearchViewHolder.OnSearchHandlerListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tl_home)
    TabLayout tabLayout;
    @BindView(R.id.vp_home)
    ViewPager viewPager;
    @BindView(R.id.ll_home)
    LinearLayout mLinearLayout;

    //private IHomePresenter mPresenter;
    HomeCateBean mHomeCateBean;
    List<String> mList = new ArrayList<>();
    SearchViewHolder mHolder;
    PopupWindow mPopupWindow;

    @Override
    protected HomePresenterImpl getPresenter() {

        return new HomePresenterImpl(getContext());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onResume() {
        super.onResume();
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_search) {
                    showSearchView();
                    return true;
                }
                return true;
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        //inflater.inflate(R.menu.menu_toolbar,menu);
        //getActivity().onCreateOptionsMenu(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        //getActivity().onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //((MainActivity) getActivity()).setToolbar(mToolbar);

    }

    private void showSearchView() {


        if (mPopupWindow == null) {

            mHolder = new SearchViewHolder(getActivity(),this::search);
           /* mHolder = new SearchViewHolder(getActivity(), code -> {

            });*/
        mPopupWindow = new PopupWindow(mHolder.getContentView(),
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,true);
        //mPopupWindow.setContentView();
        //mPopupWindow.setBackgroundDrawable(new BitmapDrawable());          android.graphics.Color.TRANSPARENT
            mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
            backgroundAlpha(0.5f);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAtLocation(mHolder.getContentView(), Gravity.TOP, 0, 0);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                KeyBoardUtils.closeKeyBord(mHolder.et_search_content,getContext());
                backgroundAlpha(1f);
            }
        });
        mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        }

        KeyBoardUtils.openKeyBord(mHolder.et_search_content,getContext());


    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
        /*WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);*/
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().setAttributes(lp);
    }



    @Override
    protected void initView() {
        //tableLayout.setTag();
        //tabLayout.addTab();
        mToolbar.inflateMenu(R.menu.menu_toolbar);
        //mPresenter.requestHomeCateData();
        mPresenter.requestHomeCateData();

    }

    @Override
    public void loadData(Object result) {
        mHomeCateBean = (HomeCateBean) result;

        MyFragmentPagerAdapter myAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        List<HomeCateBean.DataBean.CateListBean> cate_list = mHomeCateBean.getData().getCate_list();
        myAdapter.setCateList(cate_list);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        /*String cateName = mCateListBean.getCateName();
        mList.add(cateName);*/
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMsg(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void search(int code) {
        switch (code) {
            case SearchViewHolder.RESULT_SEARCH_EMPTY_KEYWORD:
                Snackbar.make(mLinearLayout, "关键词不能为空", Snackbar.LENGTH_LONG).show();
                break;
            case SearchViewHolder.RESULT_SEARCH_KEYWORD:
                String content = mHolder.et_search_content.getText().toString();
                Intent intent;
                intent = new Intent(getContext(), SearchResultActivity.class);
                intent.putExtra("keyword", content);
                startActivity(intent);
                break;
            case SearchViewHolder.RESULT_SEARCH_GO_SCAN:
                //Intent intent1 = new Intent(getContext(),)
                break;
            case SearchViewHolder.RESULT_SEARCH_CANCEL:
                mPopupWindow.dismiss();
                break;
        }
    }


   /* @Override
    public void search(int code) {


    }*/
}
