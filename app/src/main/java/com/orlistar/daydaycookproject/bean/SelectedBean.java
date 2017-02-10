package com.orlistar.daydaycookproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/3 0003.
 */

public class SelectedBean {

    private List<ThemeListBean> themeList;
    private List<RecipeListBean> recipeList;

    public void setThemeList(List<ThemeListBean> themeList) {
        this.themeList = themeList;
    }

    public void setRecipeList(List<RecipeListBean> recipeList) {
        this.recipeList = recipeList;
    }

    public List<ThemeListBean> getThemeList() {
        return themeList;
    }

    public List<RecipeListBean> getRecipeList() {
        return recipeList;
    }

    public static class ThemeListBean {

        private String recipe_type;
        private Object locationName;
        private String image_url;
        private String recommend_type;
        private String description;
        private int click_count;
        private SourceBean source;
        private String title;
        private int rid;
        private int share_count;
        private String str_date;
        private int recipe_id;
        private int group_id;
        private Object locationId;
        private int favorite_count;
        private String favorite;
        private String makingTime;

        public void setRecipe_type(String recipe_type) {
            this.recipe_type = recipe_type;
        }

        public void setLocationName(Object locationName) {
            this.locationName = locationName;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public void setRecommend_type(String recommend_type) {
            this.recommend_type = recommend_type;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setClick_count(int click_count) {
            this.click_count = click_count;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public void setStr_date(String str_date) {
            this.str_date = str_date;
        }

        public void setRecipe_id(int recipe_id) {
            this.recipe_id = recipe_id;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public void setLocationId(Object locationId) {
            this.locationId = locationId;
        }

        public void setFavorite_count(int favorite_count) {
            this.favorite_count = favorite_count;
        }

        public void setFavorite(String favorite) {
            this.favorite = favorite;
        }

        public void setMakingTime(String makingTime) {
            this.makingTime = makingTime;
        }

        public String getRecipe_type() {
            return recipe_type;
        }

        public Object getLocationName() {
            return locationName;
        }

        public String getImage_url() {
            return image_url;
        }

        public String getRecommend_type() {
            return recommend_type;
        }

        public String getDescription() {
            return description;
        }

        public int getClick_count() {
            return click_count;
        }

        public SourceBean getSource() {
            return source;
        }

        public String getTitle() {
            return title;
        }

        public int getRid() {
            return rid;
        }

        public int getShare_count() {
            return share_count;
        }

        public String getStr_date() {
            return str_date;
        }

        public int getRecipe_id() {
            return recipe_id;
        }

        public int getGroup_id() {
            return group_id;
        }

        public Object getLocationId() {
            return locationId;
        }

        public int getFavorite_count() {
            return favorite_count;
        }

        public String getFavorite() {
            return favorite;
        }

        public String getMakingTime() {
            return makingTime;
        }

        public static class SourceBean {

            private boolean displayAuthor;
            private String authorSummary;
            private String authorName;
            private String authorId;
            private String authorImageUrl;

            public void setDisplayAuthor(boolean displayAuthor) {
                this.displayAuthor = displayAuthor;
            }

            public void setAuthorSummary(String authorSummary) {
                this.authorSummary = authorSummary;
            }

            public void setAuthorName(String authorName) {
                this.authorName = authorName;
            }

            public void setAuthorId(String authorId) {
                this.authorId = authorId;
            }

            public void setAuthorImageUrl(String authorImageUrl) {
                this.authorImageUrl = authorImageUrl;
            }

            public boolean getDisplayAuthor() {
                return displayAuthor;
            }

            public String getAuthorSummary() {
                return authorSummary;
            }

            public String getAuthorName() {
                return authorName;
            }

            public String getAuthorId() {
                return authorId;
            }

            public String getAuthorImageUrl() {
                return authorImageUrl;
            }
        }
    }

    public static class RecipeListBean {

        private String recipe_type;
        private Object locationName;
        private String image_url;
        private String recommend_type;
        private String description;
        private int click_count;
        private String title;
        private int rid;
        private int share_count;
        private String str_date;
        private int recipe_id;
        private int group_id;
        private Object locationId;
        private int favorite_count;
        private boolean favorite;
        private String makingTime;

        public void setRecipe_type(String recipe_type) {
            this.recipe_type = recipe_type;
        }

        public void setLocationName(Object locationName) {
            this.locationName = locationName;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public void setRecommend_type(String recommend_type) {
            this.recommend_type = recommend_type;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setClick_count(int click_count) {
            this.click_count = click_count;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public void setStr_date(String str_date) {
            this.str_date = str_date;
        }

        public void setRecipe_id(int recipe_id) {
            this.recipe_id = recipe_id;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public void setLocationId(Object locationId) {
            this.locationId = locationId;
        }

        public void setFavorite_count(int favorite_count) {
            this.favorite_count = favorite_count;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public void setMakingTime(String makingTime) {
            this.makingTime = makingTime;
        }

        public String getRecipe_type() {
            return recipe_type;
        }

        public Object getLocationName() {
            return locationName;
        }

        public String getImage_url() {
            return image_url;
        }

        public String getRecommend_type() {
            return recommend_type;
        }

        public String getDescription() {
            return description;
        }

        public int getClick_count() {
            return click_count;
        }

        public String getTitle() {
            return title;
        }

        public int getRid() {
            return rid;
        }

        public int getShare_count() {
            return share_count;
        }

        public String getStr_date() {
            return str_date;
        }

        public int getRecipe_id() {
            return recipe_id;
        }

        public int getGroup_id() {
            return group_id;
        }

        public Object getLocationId() {
            return locationId;
        }

        public int getFavorite_count() {
            return favorite_count;
        }

        public boolean getFavorite() {
            return favorite;
        }

        public String getMakingTime() {
            return makingTime;
        }
    }
}
