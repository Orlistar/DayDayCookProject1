package com.orlistar.daydaycookproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/3 0003.
 */
public class BannerBean {

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
        private long createDate;
        private long modifyDate;
        private String title;
        private String type;
        private String content;
        private String path;
        private long beginDate;
        private long endDate;
        private String url;
        private String linkType;
        private String releasePlat;
        private Object filemImg;
        private String area;
        private Object live;

        public void setPageInfo(Object pageInfo) {
            this.pageInfo = pageInfo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public void setModifyDate(long modifyDate) {
            this.modifyDate = modifyDate;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public void setBeginDate(long beginDate) {
            this.beginDate = beginDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setLinkType(String linkType) {
            this.linkType = linkType;
        }

        public void setReleasePlat(String releasePlat) {
            this.releasePlat = releasePlat;
        }

        public void setFilemImg(Object filemImg) {
            this.filemImg = filemImg;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public void setLive(Object live) {
            this.live = live;
        }

        public Object getPageInfo() {
            return pageInfo;
        }

        public int getId() {
            return id;
        }

        public long getCreateDate() {
            return createDate;
        }

        public long getModifyDate() {
            return modifyDate;
        }

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }

        public String getContent() {
            return content;
        }

        public String getPath() {
            return path;
        }

        public long getBeginDate() {
            return beginDate;
        }

        public long getEndDate() {
            return endDate;
        }

        public String getUrl() {
            return url;
        }

        public String getLinkType() {
            return linkType;
        }

        public String getReleasePlat() {
            return releasePlat;
        }

        public Object getFilemImg() {
            return filemImg;
        }

        public String getArea() {
            return area;
        }

        public Object getLive() {
            return live;
        }
    }
}
