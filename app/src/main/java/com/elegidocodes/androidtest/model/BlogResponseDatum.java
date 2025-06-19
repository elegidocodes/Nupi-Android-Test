package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class BlogResponseDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_preview")
    @Expose
    private String imagePreview;
    @SerializedName("file_post")
    @Expose
    private String filePost;
    @SerializedName("file_type")
    @Expose
    private String fileType;
    @SerializedName("wall_post_type_categorie_id")
    @Expose
    private Integer wallPostTypeCategorieId;
    @SerializedName("created_by")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("business_id")
    @Expose
    private Object businessId;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("total_comments")
    @Expose
    private Integer totalComments;
    @SerializedName("total_likes")
    @Expose
    private Integer totalLikes;
    @SerializedName("total_shareds")
    @Expose
    private Integer totalShareds;
    @SerializedName("liked")
    @Expose
    private Boolean liked;
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

    public Integer getWallPostTypeCategorieId() {
        return wallPostTypeCategorieId;
    }

    public void setWallPostTypeCategorieId(Integer wallPostTypeCategorieId) {
        this.wallPostTypeCategorieId = wallPostTypeCategorieId;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Object businessId) {
        this.businessId = businessId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(Integer totalComments) {
        this.totalComments = totalComments;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Integer getTotalShareds() {
        return totalShareds;
    }

    public void setTotalShareds(Integer totalShareds) {
        this.totalShareds = totalShareds;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public List<Object> getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(List<Object> groupsId) {
        this.groupsId = groupsId;
    }

}
