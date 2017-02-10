package com.orlistar.daydaycookproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/3 0003.
 */
public class NewRecipeBean {

    private String msg;
    private String code;
    private List<DataBean> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {

        private Object pageInfo;
        private int id;
        private String title;
        private String name;
        private String content;
        private String detailsUrl;
        private Object multipleRateUrl;
        private Object indexUrl;
        private String imageUrl;
        private int clickCount;
        private int shareCount;
        private int favoriteCount;
        private Object lable;
        private String maketime;
        private long createDate;
        private long modifyDate;
        private String description;
        private String categoryID;
        private Object displayState;
        private Object area;
        private Object releasePlat;
        private Object imageWidth;
        private Object imageHeight;
        private Object technology;
        private Object taste;
        private Object loadContent;
        private int deleteStatus;
        private Object systemUser;
        private Object difficulty;
        private Object peopleEat;
        private String releaseDate;
        private Object category;
        private Object parentCategoryId;
        private String type;
        private Object imageUrlFlow;
        private Object nivoRelId;
        private Object videoRelId;
        private Object userId;
        private Object source;
        private int clickCountBase;
        private int shareCountBase;
        private int favoriteCountBase;
        private int shareClickCount;
        private Object appUser;
        private boolean favorite;
        private String screeningId;
        private Object shareUrl;

        public void setPageInfo(Object pageInfo) {
            this.pageInfo = pageInfo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setDetailsUrl(String detailsUrl) {
            this.detailsUrl = detailsUrl;
        }

        public void setMultipleRateUrl(Object multipleRateUrl) {
            this.multipleRateUrl = multipleRateUrl;
        }

        public void setIndexUrl(Object indexUrl) {
            this.indexUrl = indexUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public void setClickCount(int clickCount) {
            this.clickCount = clickCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public void setFavoriteCount(int favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public void setLable(Object lable) {
            this.lable = lable;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public void setModifyDate(long modifyDate) {
            this.modifyDate = modifyDate;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setCategoryID(String categoryID) {
            this.categoryID = categoryID;
        }

        public void setDisplayState(Object displayState) {
            this.displayState = displayState;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public void setReleasePlat(Object releasePlat) {
            this.releasePlat = releasePlat;
        }

        public void setImageWidth(Object imageWidth) {
            this.imageWidth = imageWidth;
        }

        public void setImageHeight(Object imageHeight) {
            this.imageHeight = imageHeight;
        }

        public void setTechnology(Object technology) {
            this.technology = technology;
        }

        public void setTaste(Object taste) {
            this.taste = taste;
        }

        public void setLoadContent(Object loadContent) {
            this.loadContent = loadContent;
        }

        public void setDeleteStatus(int deleteStatus) {
            this.deleteStatus = deleteStatus;
        }

        public void setSystemUser(Object systemUser) {
            this.systemUser = systemUser;
        }

        public void setDifficulty(Object difficulty) {
            this.difficulty = difficulty;
        }

        public void setPeopleEat(Object peopleEat) {
            this.peopleEat = peopleEat;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public void setCategory(Object category) {
            this.category = category;
        }

        public void setParentCategoryId(Object parentCategoryId) {
            this.parentCategoryId = parentCategoryId;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setImageUrlFlow(Object imageUrlFlow) {
            this.imageUrlFlow = imageUrlFlow;
        }

        public void setNivoRelId(Object nivoRelId) {
            this.nivoRelId = nivoRelId;
        }

        public void setVideoRelId(Object videoRelId) {
            this.videoRelId = videoRelId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public void setClickCountBase(int clickCountBase) {
            this.clickCountBase = clickCountBase;
        }

        public void setShareCountBase(int shareCountBase) {
            this.shareCountBase = shareCountBase;
        }

        public void setFavoriteCountBase(int favoriteCountBase) {
            this.favoriteCountBase = favoriteCountBase;
        }

        public void setShareClickCount(int shareClickCount) {
            this.shareClickCount = shareClickCount;
        }

        public void setAppUser(Object appUser) {
            this.appUser = appUser;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public void setScreeningId(String screeningId) {
            this.screeningId = screeningId;
        }

        public void setShareUrl(Object shareUrl) {
            this.shareUrl = shareUrl;
        }

        public Object getPageInfo() {
            return pageInfo;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getName() {
            return name;
        }

        public String getContent() {
            return content;
        }

        public String getDetailsUrl() {
            return detailsUrl;
        }

        public Object getMultipleRateUrl() {
            return multipleRateUrl;
        }

        public Object getIndexUrl() {
            return indexUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public int getClickCount() {
            return clickCount;
        }

        public int getShareCount() {
            return shareCount;
        }

        public int getFavoriteCount() {
            return favoriteCount;
        }

        public Object getLable() {
            return lable;
        }

        public String getMaketime() {
            return maketime;
        }

        public long getCreateDate() {
            return createDate;
        }

        public long getModifyDate() {
            return modifyDate;
        }

        public String getDescription() {
            return description;
        }

        public String getCategoryID() {
            return categoryID;
        }

        public Object getDisplayState() {
            return displayState;
        }

        public Object getArea() {
            return area;
        }

        public Object getReleasePlat() {
            return releasePlat;
        }

        public Object getImageWidth() {
            return imageWidth;
        }

        public Object getImageHeight() {
            return imageHeight;
        }

        public Object getTechnology() {
            return technology;
        }

        public Object getTaste() {
            return taste;
        }

        public Object getLoadContent() {
            return loadContent;
        }

        public int getDeleteStatus() {
            return deleteStatus;
        }

        public Object getSystemUser() {
            return systemUser;
        }

        public Object getDifficulty() {
            return difficulty;
        }

        public Object getPeopleEat() {
            return peopleEat;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public Object getCategory() {
            return category;
        }

        public Object getParentCategoryId() {
            return parentCategoryId;
        }

        public String getType() {
            return type;
        }

        public Object getImageUrlFlow() {
            return imageUrlFlow;
        }

        public Object getNivoRelId() {
            return nivoRelId;
        }

        public Object getVideoRelId() {
            return videoRelId;
        }

        public Object getUserId() {
            return userId;
        }

        public Object getSource() {
            return source;
        }

        public int getClickCountBase() {
            return clickCountBase;
        }

        public int getShareCountBase() {
            return shareCountBase;
        }

        public int getFavoriteCountBase() {
            return favoriteCountBase;
        }

        public int getShareClickCount() {
            return shareClickCount;
        }

        public Object getAppUser() {
            return appUser;
        }

        public boolean getFavorite() {
            return favorite;
        }

        public String getScreeningId() {
            return screeningId;
        }

        public Object getShareUrl() {
            return shareUrl;
        }
    }
}
