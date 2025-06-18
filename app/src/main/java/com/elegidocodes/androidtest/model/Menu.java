package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Menu {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("icon")
    @Expose
    private Object icon;
    @SerializedName("image_button")
    @Expose
    private String imageButton;
    @SerializedName("meta")
    @Expose
    private Object meta;
    @SerializedName("path")
    @Expose
    private Object path;
    @SerializedName("component")
    @Expose
    private Object component;
    @SerializedName("hired_service_id")
    @Expose
    private Object hiredServiceId;
    @SerializedName("service_id")
    @Expose
    private Integer serviceId;
    @SerializedName("main_menu")
    @Expose
    private Integer mainMenu;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("icon_path")
    @Expose
    private Object iconPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public String getImageButton() {
        return imageButton;
    }

    public void setImageButton(String imageButton) {
        this.imageButton = imageButton;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public Object getPath() {
        return path;
    }

    public void setPath(Object path) {
        this.path = path;
    }

    public Object getComponent() {
        return component;
    }

    public void setComponent(Object component) {
        this.component = component;
    }

    public Object getHiredServiceId() {
        return hiredServiceId;
    }

    public void setHiredServiceId(Object hiredServiceId) {
        this.hiredServiceId = hiredServiceId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(Integer mainMenu) {
        this.mainMenu = mainMenu;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Object getIconPath() {
        return iconPath;
    }

    public void setIconPath(Object iconPath) {
        this.iconPath = iconPath;
    }

}
