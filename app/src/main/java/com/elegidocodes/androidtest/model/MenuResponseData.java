package com.elegidocodes.androidtest.model;

import android.view.Menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class MenuResponseData {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("menu_version")
    @Expose
    private MenuVersion menuVersion;
    @SerializedName("extra")
    @Expose
    private Extra extra;
    @SerializedName("latest_new")
    @Expose
    private LatestNew latestNew;
    @SerializedName("latest_communities")
    @Expose
    private List<LatestCommunity> latestCommunities;
    @SerializedName("news")
    @Expose
    private News news;
    @SerializedName("menu")
    @Expose
    private List<Menu> menu;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MenuVersion getMenuVersion() {
        return menuVersion;
    }

    public void setMenuVersion(MenuVersion menuVersion) {
        this.menuVersion = menuVersion;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public LatestNew getLatestNew() {
        return latestNew;
    }

    public void setLatestNew(LatestNew latestNew) {
        this.latestNew = latestNew;
    }

    public List<LatestCommunity> getLatestCommunities() {
        return latestCommunities;
    }

    public void setLatestCommunities(List<LatestCommunity> latestCommunities) {
        this.latestCommunities = latestCommunities;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

}
