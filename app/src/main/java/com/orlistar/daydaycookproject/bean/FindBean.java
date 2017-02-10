package com.orlistar.daydaycookproject.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/2/3 0003.
 */
public class FindBean {
    @SerializedName("1")
    @Expose
    private List<DataBean> dataBeen_1;
    @SerializedName("2")
    @Expose
    private List<DataBean> dataBeen_2;
    @SerializedName("3")
    @Expose
    private List<DataBean> dataBeen_3;
    @SerializedName("4")
    @Expose
    private List<DataBean> dataBeen_4;
    @SerializedName("5")
    @Expose
    private List<DataBean> dataBeen_5;
    @SerializedName("6")
    @Expose
    private List<DataBean> dataBeen_6;
    @SerializedName("7")
    @Expose
    private List<DataBean> dataBeen_7;
    @SerializedName("8")
    @Expose
    private List<DataBean> dataBeen_8;
    @SerializedName("-1")
    @Expose
    private List<DataBean> dataBeen_9;

    public List<DataBean> getDataBeen_1() {
        return dataBeen_1;
    }

    public void setDataBeen_1(List<DataBean> dataBeen_1) {
        this.dataBeen_1 = dataBeen_1;
    }

    public List<DataBean> getDataBeen_2() {
        return dataBeen_2;
    }

    public void setDataBeen_2(List<DataBean> dataBeen_2) {
        this.dataBeen_2 = dataBeen_2;
    }

    public List<DataBean> getDataBeen_3() {
        return dataBeen_3;
    }

    public void setDataBeen_3(List<DataBean> dataBeen_3) {
        this.dataBeen_3 = dataBeen_3;
    }

    public List<DataBean> getDataBeen_4() {
        return dataBeen_4;
    }

    public void setDataBeen_4(List<DataBean> dataBeen_4) {
        this.dataBeen_4 = dataBeen_4;
    }

    public List<DataBean> getDataBeen_5() {
        return dataBeen_5;
    }

    public void setDataBeen_5(List<DataBean> dataBeen_5) {
        this.dataBeen_5 = dataBeen_5;
    }

    public List<DataBean> getDataBeen_6() {
        return dataBeen_6;
    }

    public void setDataBeen_6(List<DataBean> dataBeen_6) {
        this.dataBeen_6 = dataBeen_6;
    }

    public List<DataBean> getDataBeen_7() {
        return dataBeen_7;
    }

    public void setDataBeen_7(List<DataBean> dataBeen_7) {
        this.dataBeen_7 = dataBeen_7;
    }

    public List<DataBean> getDataBeen_8() {
        return dataBeen_8;
    }

    public void setDataBeen_8(List<DataBean> dataBeen_8) {
        this.dataBeen_8 = dataBeen_8;
    }

    public List<DataBean> getDataBeen_9() {
        return dataBeen_9;
    }

    public void setDataBeen_9(List<DataBean> dataBeen_9) {
        this.dataBeen_9 = dataBeen_9;
    }

    public static class DataBean {
        private String recipe_type;
        private String locationName;
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
        private int locationId;
        private int favorite_count;
        private String favorite;
        private String makingTime;

        public void setRecipe_type(String recipe_type) {
            this.recipe_type = recipe_type;
        }

        public void setLocationName(String locationName) {
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

        public void setLocationId(int locationId) {
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

        public String getLocationName() {
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

        public int getLocationId() {
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
    }
}
