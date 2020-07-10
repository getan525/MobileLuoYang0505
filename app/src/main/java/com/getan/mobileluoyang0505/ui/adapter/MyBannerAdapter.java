package com.getan.mobileluoyang0505.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.getan.mobileluoyang0505.R;
import com.getan.mobileluoyang0505.bean.BannerBean;

import java.util.ArrayList;
import java.util.List;

public class MyBannerAdapter extends PagerAdapter {
    List<BannerBean.DataBean> mDataBeans = new ArrayList<>();
    private LayoutInflater mInflater;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        /*String imageurl = mDataBeans.get(position).getImage();
        //String imageurl = "http://open-image.ws.126.net/3052c5dcb6d341cda772db399256b474.jpg";
        ImageView imageView = new ImageView(container.getContext());
        Glide.with(container.getContext()).load(imageurl).into(imageView);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(layoutParams);
        Log.d("MyBannerAdapter", "instantiateItem: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+imageurl);
        container.addView(imageView);*/
        //View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.item_banner, container, false);
        mInflater = LayoutInflater.from(container.getContext());
        View view = mInflater.inflate(R.layout.item_banner, null);
        ImageView imageView = view.findViewById(R.id.img_banner);
        TextView tv_banner = view.findViewById(R.id.tv_banner);
        Log.d("000", "instantiateItem: ="+mDataBeans.get(1).getImage());

/*for (int i = 0; i < mDataBeans.size(); i++) {

            ImageView iv_point = new ImageView(container.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(4,4);
            iv_point.setLayoutParams(layoutParams);
            if (i==position){
                iv_point.setBackgroundResource(R.color.orange);
            }else {
                iv_point.setBackgroundResource(R.color.white);
            }
            container.addView(iv_point);
        }*/

        /*ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(layoutParams);*/
        Glide.with(container.getContext()).load(mDataBeans.get(position).getImage()).into(imageView);
        tv_banner.setText(mDataBeans.get(position).getContentTitle());


        container.addView(view);
        //imageView.setImageURI(Uri.parse(mDataBeans.get(position).getImage()));
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mDataBeans.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void sendData(List<BannerBean.DataBean> banner_list) {
        Log.d("MyBannerAdapter", "instantiateItem: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        mDataBeans = banner_list;
        /*mDataBeans.clear();
        mDataBeans.addAll(banner_list);*/
        notifyDataSetChanged();
    }
}
