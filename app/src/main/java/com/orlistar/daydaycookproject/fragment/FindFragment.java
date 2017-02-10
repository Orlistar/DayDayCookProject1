package com.orlistar.daydaycookproject.fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orlistarlib.base.BaseFragment;
import com.example.orlistarlib.util.GlideImageLoader;
import com.example.orlistarlib.util.GlideUtil;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.orlistar.daydaycookproject.R;
import com.orlistar.daydaycookproject.bean.FindBean;
import com.orlistar.daydaycookproject.inter.ApiManager;
import com.orlistar.daydaycookproject.inter.DataRequestInterface;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/2/3 0003.
 */

public class FindFragment extends BaseFragment {

    private List<FindBean> data;
    private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    private Banner banner;
    private ImageView ivLoading;
    private LinearLayout llContent;

    @Override
    protected int getContentId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void init(View view) {
        setupViews(view);
        ivLoading.setVisibility(View.VISIBLE);
        llContent.setVisibility(View.GONE);
        RotateAnimation loadingAnim = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        loadingAnim.setDuration(1000);
        loadingAnim.setRepeatCount(Animation.INFINITE);
        loadingAnim.setRepeatMode(Animation.RESTART);
        loadingAnim.setInterpolator(new LinearInterpolator());
        ivLoading.startAnimation(loadingAnim);

        data = new ArrayList<>();
        loadData();
    }

    private void setupViews(View view) {
        banner = findViewByIds(view, R.id.banner);
        iv1 = findViewByIds(view, R.id.iv_1);
        iv2 = findViewByIds(view, R.id.iv_2);
        iv3 = findViewByIds(view, R.id.iv_3);
        iv4 = findViewByIds(view, R.id.iv_4);
        iv5 = findViewByIds(view, R.id.iv_5);
        iv6 = findViewByIds(view, R.id.iv_6);
        iv7 = findViewByIds(view, R.id.iv_7);
        iv8 = findViewByIds(view, R.id.iv_8);

        tv1 = findViewByIds(view, R.id.tv_1);
        tv2 = findViewByIds(view, R.id.tv_2);
        tv3 = findViewByIds(view, R.id.tv_3);
        tv4 = findViewByIds(view, R.id.tv_4);
        tv5 = findViewByIds(view, R.id.tv_5);
        tv6 = findViewByIds(view, R.id.tv_6);
        tv7 = findViewByIds(view, R.id.tv_7);
        tv8 = findViewByIds(view, R.id.tv_8);

        ivLoading = findViewByIds(view, R.id.iv_loading);
        llContent = findViewByIds(view, R.id.ll_content);
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(DataRequestInterface.class).getFindData().enqueue(new Callback<FindBean>() {
            @Override
            public void onResponse(Call<FindBean> call, Response<FindBean> response) {
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                llContent.setVisibility(View.VISIBLE);
                data.add(response.body());

                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_1().get(0).getImage_url(), iv1);
                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_2().get(0).getImage_url(), iv2);
                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_3().get(0).getImage_url(), iv3);
                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_4().get(0).getImage_url(), iv4);
                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_5().get(0).getImage_url(), iv5);
                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_6().get(0).getImage_url(), iv6);
                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_7().get(0).getImage_url(), iv7);
                GlideUtil.setImgByGlide(getContext(), data.get(0).getDataBeen_8().get(0).getImage_url(), iv8);

                String prefix = "#";
                tv1.setText(prefix + data.get(0).getDataBeen_1().get(0).getTitle());
                tv2.setText(prefix + data.get(0).getDataBeen_2().get(0).getTitle());
                tv3.setText(prefix + data.get(0).getDataBeen_3().get(0).getTitle());
                tv4.setText(prefix + data.get(0).getDataBeen_4().get(0).getTitle());
                tv5.setText(prefix + data.get(0).getDataBeen_5().get(0).getTitle());
                tv6.setText(prefix + data.get(0).getDataBeen_6().get(0).getTitle());
                tv7.setText(prefix + data.get(0).getDataBeen_7().get(0).getTitle());
                tv8.setText(prefix + data.get(0).getDataBeen_8().get(0).getTitle());

                banner.setDelayTime(3000);
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.setImageLoader(new GlideImageLoader());
                List<FindBean.DataBean> dataBeen_9 = data.get(0).getDataBeen_9();
                List<String> imgUrls = new ArrayList<>();
                for (int i = 0; i < dataBeen_9.size(); i++) {
                    imgUrls.add(dataBeen_9.get(i).getImage_url());
                }
                banner.setImages(imgUrls);
                banner.start();
            }

            @Override
            public void onFailure(Call<FindBean> call, Throwable t) {
                if (ivLoading.getVisibility() == View.VISIBLE) {
                    ivLoading.clearAnimation();
                    ivLoading.setVisibility(View.GONE);
                }
            }
        });
    }
}
