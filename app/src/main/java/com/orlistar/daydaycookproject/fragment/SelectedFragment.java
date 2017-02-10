package com.orlistar.daydaycookproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orlistarlib.util.GlideImageLoader;
import com.example.orlistarlib.util.GlideUtil;
import com.example.orlistarlib.util.ScreenUtil;
import com.orlistar.daydaycookproject.R;
import com.orlistar.daydaycookproject.bean.BannerBean;
import com.orlistar.daydaycookproject.bean.NewRecipeBean;
import com.orlistar.daydaycookproject.bean.SelectedBean;
import com.orlistar.daydaycookproject.inter.ApiManager;
import com.orlistar.daydaycookproject.inter.DataRequestInterface;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

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

public class SelectedFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<SelectedBean> listData;
    private List<BannerBean> bannerData;
    private HeaderAndFooterWrapper headerAndFooterWrapper;
    private int currentPage;
    private ImageView ivLoading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selected, null);
        setupViews(view);
        init();
        return view;
    }

    private void init() {
        currentPage = 0;
        recyclerView.setVisibility(View.GONE);
        ivLoading.setVisibility(View.VISIBLE);
        RotateAnimation loadingAnim = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        loadingAnim.setDuration(1000);
        loadingAnim.setRepeatCount(Animation.INFINITE);
        loadingAnim.setRepeatMode(Animation.RESTART);
        loadingAnim.setInterpolator(new LinearInterpolator());
        ivLoading.startAnimation(loadingAnim);
        listData = new ArrayList<>();
        bannerData = new ArrayList<>();
        loadListData();
    }

    private void loadListData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<SelectedBean> call = retrofit.create(DataRequestInterface.class).getSelectedData();
        call.enqueue(new Callback<SelectedBean>() {
            @Override
            public void onResponse(Call<SelectedBean> call, Response<SelectedBean> response) {
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                SelectedBean body = response.body();
                listData.add(body);
                CommonAdapter commonAdapter = new CommonAdapter<SelectedBean.ThemeListBean>(getContext(), R.layout.selected_list_item, listData.get(0).getThemeList()) {
                    @Override
                    protected void convert(ViewHolder holder, SelectedBean.ThemeListBean themeListBean, int position) {
                        ImageView cover = holder.getView(R.id.iv_cover);
                        TextView title = holder.getView(R.id.tv_title);
                        TextView authorName = holder.getView(R.id.tv_authorName);
                        LinearLayout topic = holder.getView(R.id.ll_topic);
                        if (holder.getAdapterPosition() != 1) {
                            topic.setVisibility(View.GONE);
                        } else {
                            topic.setVisibility(View.VISIBLE);
                        }

                        GlideUtil.setImgByGlide(getContext(), themeListBean.getImage_url(), cover);
                        title.setText(themeListBean.getTitle());
                        if (themeListBean.getSource() != null) {
                            authorName.setText(themeListBean.getSource().getAuthorName());
                        }
                    }
                };

                headerAndFooterWrapper = new HeaderAndFooterWrapper(commonAdapter);
                //添加头部
                addHeaders();
                recyclerView.setAdapter(headerAndFooterWrapper);
                headerAndFooterWrapper.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SelectedBean> call, Throwable t) {
                if (ivLoading.getVisibility() == View.VISIBLE) {
                    ivLoading.clearAnimation();
                    ivLoading.setVisibility(View.GONE);
                }
            }
        });
    }

    private void addHeaders() {
        //添加头部--广告轮播
        addHeaderBanner();
        //添加头部--食谱分类、视频专区等按钮
        addHeaderCategory();
        //添加头部--每日新菜馆
        addHeaderNewRecipe();
        //添加头部--当红人气菜
        addHeaderHotRecipe();
    }

    private void addHeaderCategory() {
        View header_category = LayoutInflater.from(getContext()).inflate(R.layout.header_category, null, false);
        headerAndFooterWrapper.addHeaderView(header_category);
    }

    private void addHeaderNewRecipe() {
        View header_newRecipe = LayoutInflater.from(getContext()).inflate(R.layout.header_recipelist, null, false);
        LinearLayout recipeList = (LinearLayout) header_newRecipe.findViewById(R.id.recipe_list);
        ImageView headImg = (ImageView) header_newRecipe.findViewById(R.id.iv_headImg);
        TextView headText = (TextView) header_newRecipe.findViewById(R.id.tv_headText);
        headImg.setImageResource(R.drawable.second_new);
        headText.setText("每日新菜馆");
        loadNewRecipeListData(recipeList);
        headerAndFooterWrapper.addHeaderView(header_newRecipe);
    }

    private void loadNewRecipeListData(final LinearLayout recipeList) {
        final List<NewRecipeBean.DataBean> newRecipeData = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<NewRecipeBean> call = retrofit.create(DataRequestInterface.class).getNewRecipeData(currentPage, 10);
        call.enqueue(new Callback<NewRecipeBean>() {
            @Override
            public void onResponse(Call<NewRecipeBean> call, Response<NewRecipeBean> response) {
                NewRecipeBean body = response.body();
                newRecipeData.addAll(body.getData());
                recipeList.removeAllViews();
                for (int i = 0; i < newRecipeData.size(); i++) {
                    View item = LayoutInflater.from(getContext()).inflate(R.layout.recipe_list_item_1, null, true);
                    ImageView img = (ImageView) item.findViewById(R.id.iv_img);
                    TextView title = (TextView) item.findViewById(R.id.tv_title);
                    TextView description = (TextView) item.findViewById(R.id.tv_description);
                    TextView clickCount = (TextView) item.findViewById(R.id.tv_clickCount);

                    GlideUtil.setImgByGlide(getContext(), newRecipeData.get(i).getImageUrl(), img);
                    title.setText(newRecipeData.get(i).getTitle());
                    description.setText(newRecipeData.get(i).getDescription());
                    clickCount.setText(newRecipeData.get(i).getClickCount() + "");
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (ScreenUtil.getScreenWidth(getContext()) / 2.5), ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(5, 5, 5, 5);
                    recipeList.addView(item, params);
                }
            }

            @Override
            public void onFailure(Call<NewRecipeBean> call, Throwable t) {

            }
        });
    }

    private void addHeaderBanner() {
        View header_banner = LayoutInflater.from(getContext()).inflate(R.layout.header_banner, null, false);
        Banner banner = (Banner) header_banner.findViewById(R.id.banner);
        banner.setDelayTime(3000);
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        loadBannerData(banner);
        headerAndFooterWrapper.addHeaderView(header_banner);
    }

    private void loadBannerData(final Banner banner) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<BannerBean> call = retrofit.create(DataRequestInterface.class).getBannerData();
        call.enqueue(new Callback<BannerBean>() {
            @Override
            public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
                BannerBean body = response.body();
                bannerData.add(body);
                List<String> imgUrls = new ArrayList();
                List<BannerBean.DataBean> dataBeanList = bannerData.get(0).getData();
                for (int i = 0; i < dataBeanList.size(); i++) {
                    imgUrls.add(dataBeanList.get(i).getPath());
                }
                banner.setImages(imgUrls);
                banner.start();
            }

            @Override
            public void onFailure(Call<BannerBean> call, Throwable t) {

            }
        });
    }

    private void addHeaderHotRecipe() {
        View header_hotRecipe = LayoutInflater.from(getContext()).inflate(R.layout.header_recipelist, null, false);
        LinearLayout recipeList = (LinearLayout) header_hotRecipe.findViewById(R.id.recipe_list);
        ImageView headImg = (ImageView) header_hotRecipe.findViewById(R.id.iv_headImg);
        TextView headText = (TextView) header_hotRecipe.findViewById(R.id.tv_headText);
        headImg.setImageResource(R.drawable.second_hot);
        headText.setText("当红人气菜");
        List<SelectedBean.RecipeListBean> recipeListBeen = listData.get(0).getRecipeList();
        recipeList.removeAllViews();
        for (int i = 0; i < recipeListBeen.size(); i++) {
            View item = LayoutInflater.from(getContext()).inflate(R.layout.recipe_list_item_1, null, true);
            ImageView img = (ImageView) item.findViewById(R.id.iv_img);
            TextView title = (TextView) item.findViewById(R.id.tv_title);
            TextView description = (TextView) item.findViewById(R.id.tv_description);
            TextView clickCount = (TextView) item.findViewById(R.id.tv_clickCount);

            GlideUtil.setImgByGlide(getContext(), recipeListBeen.get(i).getImage_url(), img);
            title.setText(recipeListBeen.get(i).getTitle());
            description.setText(recipeListBeen.get(i).getDescription());
            clickCount.setText(recipeListBeen.get(i).getClick_count() + "");
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (ScreenUtil.getScreenWidth(getContext()) / 2.5), ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 5, 5, 5);
            recipeList.addView(item, params);
        }
        headerAndFooterWrapper.addHeaderView(header_hotRecipe);
    }

    private void setupViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ivLoading = (ImageView) view.findViewById(R.id.iv_loading);
    }
}
