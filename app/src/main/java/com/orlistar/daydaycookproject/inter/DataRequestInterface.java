package com.orlistar.daydaycookproject.inter;

import com.orlistar.daydaycookproject.bean.BannerBean;
import com.orlistar.daydaycookproject.bean.FindBean;
import com.orlistar.daydaycookproject.bean.NewRecipeBean;
import com.orlistar.daydaycookproject.bean.SelectedBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/2/3 0003.
 */

public interface DataRequestInterface {
    /**
     * 获取selectedFragment的数据
     *
     * @return
     */
    @GET(ApiManager.SELECTED_URL)
    Call<SelectedBean> getSelectedData();

    /**
     * 获取selectedFragment头部banner的数据
     *
     * @return
     */
    @GET(ApiManager.BANNER_URL)
    Call<BannerBean> getBannerData();

    /**
     * 获取selectedFragment 每日新菜馆的数据
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GET(ApiManager.NEW_RECIPE_URL)
    Call<NewRecipeBean> getNewRecipeData(@Query("currentPage") int currentPage, @Query("pageSize") int pageSize);

    /**
     * 获取 findFragment 页面数据
     *
     * @return
     */
    @GET(ApiManager.FIND_URL)
    Call<FindBean> getFindData();
}
