package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class News {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("labels")
    @Expose
    private String labels;
    @SerializedName("image_preview")
    @Expose
    private String imagePreview;
    @SerializedName("file_post")
    @Expose
    private String filePost;
    @SerializedName("file_type")
    @Expose
    private String fileType;
    @SerializedName("library_elements_categorie_id")
    @Expose
    private Integer libraryElementsCategorieId;
    @SerializedName("business_id")
    @Expose
    private Object businessId;
    @SerializedName("status_activate")
    @Expose
    private String statusActivate;
    @SerializedName("deactivate_date")
    @Expose
    private Object deactivateDate;
    @SerializedName("updated_by")
    @Expose
    private Object updatedBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("category")
    @Expose
    private Category1 category;
    @SerializedName("groups")
    @Expose
    private Object groups;
    @SerializedName("score_user")
    @Expose
    private Integer scoreUser;
    @SerializedName("score_average")
    @Expose
    private Integer scoreAverage;
    @SerializedName("groups_id")
    @Expose
    private List<Object> groupsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getImagePreview() {
        return imagePreview;
    }

    public void setImagePreview(String imagePreview) {
        this.imagePreview = imagePreview;
    }

    public String getFilePost() {
        return filePost;
    }

    public void setFilePost(String filePost) {
        this.filePost = filePost;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getLibraryElementsCategorieId() {
        return libraryElementsCategorieId;
    }

    public void setLibraryElementsCategorieId(Integer libraryElementsCategorieId) {
        this.libraryElementsCategorieId = libraryElementsCategorieId;
    }

    public Object getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Object businessId) {
        this.businessId = businessId;
    }

    public String getStatusActivate() {
        return statusActivate;
    }

    public void setStatusActivate(String statusActivate) {
        this.statusActivate = statusActivate;
    }

    public Object getDeactivateDate() {
        return deactivateDate;
    }

    public void setDeactivateDate(Object deactivateDate) {
        this.deactivateDate = deactivateDate;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Category1 getCategory() {
        return category;
    }

    public void setCategory(Category1 category) {
        this.category = category;
    }

    public Object getGroups() {
        return groups;
    }

    public void setGroups(Object groups) {
        this.groups = groups;
    }

    public Integer getScoreUser() {
        return scoreUser;
    }

    public void setScoreUser(Integer scoreUser) {
        this.scoreUser = scoreUser;
    }

    public Integer getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(Integer scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public List<Object> getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(List<Object> groupsId) {
        this.groupsId = groupsId;
    }

}