package com.orlistar.daydaycookproject.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.orlistarlib.base.BaseFragment;
import com.example.orlistarlib.util.GlideUtil;
import com.example.orlistarlib.util.ScreenUtil;
import com.orlistar.daydaycookproject.R;
import com.orlistar.daydaycookproject.bean.NewRecipeBean;
import com.orlistar.daydaycookproject.inter.ApiManager;
import com.orlistar.daydaycookproject.inter.DataRequestInterface;
import com.orlistar.daydaycookproject.widget.PullToRefreshHeadView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/2/3 0003.
 */
public class RecipeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<NewRecipeBean.DataBean> data;
    private CommonAdapter commonAdapter;
    private LoadMoreWrapper loadMoreWrapper;
    private int currentPage = 0;
    private AnimationDrawable loadMoreAnim;
    private ImageView ivLoading;
    private PtrClassicFrameLayout ptr;
    private ImageView toTop;

    @Override
    protected int getContentId() {
        return R.layout.fragment_recipe;
    }

    @Override
    protected void init(View view) {
        setupViews(view);
        data = new ArrayList<>();

        //设置动画
        recyclerView.setVisibility(View.GONE);
        ivLoading.setVisibility(View.VISIBLE);
        RotateAnimation loadingAnim = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        loadingAnim.setDuration(1000);
        loadingAnim.setInterpolator(new LinearInterpolator());
        loadingAnim.setRepeatCount(Animation.INFINITE);
        loadingAnim.setRepeatMode(Animation.RESTART);
        ivLoading.startAnimation(loadingAnim);

        loadData();
        commonAdapter = new CommonAdapter<NewRecipeBean.DataBean>(getContext(), R.layout.recipe_list_item_2, data) {
            @Override
            protected void convert(ViewHolder holder, NewRecipeBean.DataBean dataBean, int position) {
                ImageView cover = holder.getView(R.id.iv_cover);
                TextView title = holder.getView(R.id.tv_title);
                TextView description = holder.getView(R.id.tv_description);
                TextView time = holder.getView(R.id.tv_time);
                TextView clickCount = holder.getView(R.id.tv_clickCount);
                TextView share = holder.getView(R.id.tv_share);

                GlideUtil.setImgByGlide(getContext(), dataBean.getImageUrl(), cover);
                title.setText(dataBean.getTitle());
                description.setText(dataBean.getDescription());
                time.setText(dataBean.getMaketime());
                clickCount.setText(dataBean.getClickCount() + "");
                share.setText(dataBean.getShareCount() + "");
            }
        };
        loadMoreWrapper = new LoadMoreWrapper(commonAdapter);
        View loadMoreView = LayoutInflater.from(getContext()).inflate(R.layout.load_more_view, null, true);
        ImageView loadingIv = (ImageView) loadMoreView.findViewById(R.id.iv_loading);
        loadMoreAnim = (AnimationDrawable) loadingIv.getDrawable();
        loadMoreWrapper.setLoadMoreView(loadMoreView);
        loadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMoreAnim.start();
                currentPage++;
                loadData();
            }
        });
        recyclerView.setAdapter(loadMoreWrapper);
    }

    private void setupViews(View view) {
        recyclerView = findViewByIds(view, R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ivLoading = findViewByIds(view, R.id.iv_loading);
        ptr = findViewByIds(view, R.id.ptr_refresh);
        toTop = findViewByIds(view, R.id.iv_top);
        setupPtr();
    }

    private void setupPtr() {
        PullToRefreshHeadView pullHead = new PullToRefreshHeadView(getContext());
        ptr.setHeaderView(pullHead);

        ptr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                currentPage = 0;
                data.clear();
                loadData();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, recyclerView, header);
            }
        });
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<NewRecipeBean> call = retrofit.create(DataRequestInterface.class).getNewRecipeData(currentPage, 10);
        call.enqueue(new Callback<NewRecipeBean>() {
            @Override
            public void onResponse(Call<NewRecipeBean> call, Response<NewRecipeBean> response) {
                if (loadMoreAnim != null) {
                    loadMoreAnim.stop();
                }
                ptr.refreshComplete();
                ivLoading.clearAnimation();
                ivLoading.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                data.addAll(response.body().getData());
                loadMoreWrapper.notifyDataSetChanged();

                toTop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (data.size() <= 20) {
                            recyclerView.smoothScrollToPosition(0);
                        } else {
                            recyclerView.scrollToPosition(0);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<NewRecipeBean> call, Throwable t) {
                if (ivLoading.getVisibility() == View.VISIBLE) {
                    ivLoading.clearAnimation();
                    ivLoading.setVisibility(View.GONE);
                }
            }
        });
    }
}
