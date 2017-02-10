package com.orlistar.daydaycookproject.inter;

/**
 * Created by Administrator on 2017/2/3 0003.
 */

public interface ApiManager {
    /**
     * 主机地址
     */
    String BASE_URL = "http://api.daydaycook.com.cn";

    /**
     * selected fragment的数据接口
     */
    String SELECTED_URL = "/daydaycook/recommend/queryRecommendAll.do";

    /**
     * selected fragment 头部轮播数据接口
     */
    String BANNER_URL = "/daydaycook/server/ad/listAds.do";

    /**
     * selected fragment 每日新菜馆数据接口
     * params currentPage(int) pageSize(int)
     */
    String NEW_RECIPE_URL = "/daydaycook/server/recipe/search.do";

    /**
     * find fragment 数据接口
     */
    String FIND_URL = "/daydaycook/recommend/getMoreThemeRecipe.do";
}
