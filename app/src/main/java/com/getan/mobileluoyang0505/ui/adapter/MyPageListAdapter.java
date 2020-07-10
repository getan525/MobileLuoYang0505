package com.getan.mobileluoyang0505.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.bean.HomePageBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyPageListAdapter extends RecyclerView.Adapter<MyPageListAdapter.InnerHodler> {
    List<HomePageBean.DataBean.NewsListBean> mList = new ArrayList<>();
    Context mContext;
    public MyPageListAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public InnerHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View inflate = View.inflate(parent.getContext(), R.layout.item_news_list, null);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
        return new InnerHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHodler holder, int position) {
        String title = mList.get(position).getTitle();
        int praise = mList.get(position).getPraise();
        String mtime = mList.get(position).getMtime();
        int views = mList.get(position).getViews();
        //mList.get(position).get
        Glide.with(mContext).load(mList.get(position).getResubImage()).into(holder.iv_news_img);
        holder.tv_news_title.setText(title);
        holder.tv_news_praise.setText(String.valueOf(praise));
        holder.tv_news_mtime.setText(mtime);
        holder.tv_news_views.setText(String.valueOf(views));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

//    public void sendData(HomePageBean.DataBean.NewsListBean newsListBean) {
//        mList.add(newsListBean);
//    }

    public void sendData(List<HomePageBean.DataBean.NewsListBean> news_list) {
        mList = news_list;
        notifyDataSetChanged();
    }

    public class InnerHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_news_img)
        ImageView iv_news_img;
        @BindView(R.id.tv_news_title)
        TextView tv_news_title;
        @BindView(R.id.tv_news_praise)
        TextView tv_news_praise;
        @BindView(R.id.tv_news_mtime)
        TextView tv_news_mtime;
        @BindView(R.id.tv_news_views)
        TextView tv_news_views;
        public InnerHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
