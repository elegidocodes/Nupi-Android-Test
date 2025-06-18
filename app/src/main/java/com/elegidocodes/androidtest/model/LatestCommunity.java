package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class LatestCommunity {

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
    @SerializedName("start_date")
    @Expose
    private Object startDate;
    @SerializedName("end_date")
    @Expose
    private Object endDate;
    @SerializedName("learning_com_type_categorie_id")
    @Expose
    private Integer learningComTypeCategorieId;
    @SerializedName("learning_com_categorie_id")
    @Expose
    private Integer learningComCategorieId;
    @SerializedName("business_id")
    @Expose
    private Integer businessId;
    @SerializedName("created_by")
    @Expose
    private CreatedBy1 createdBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("last_message")
    @Expose
    private Object lastMessage;
    @SerializedName("learning_com_type_categorie")
    @Expose
    private String learningComTypeCategorie;
    @SerializedName("learning_com_categorie")
    @Expose
    private String learningComCategorie;
    @SerializedName("total_users")
    @Expose
    private Integer totalUsers;
    @SerializedName("total_messages")
    @Expose
    private Integer totalMessages;
    @SerializedName("categorie_type")
    @Expose
    private CategorieType categorieType;
    @SerializedName("groups_id")
    @Expose
    private List<GroupsId> groupsId;

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

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    public Integer getLearningComTypeCategorieId() {
        return learningComTypeCategorieId;
    }

    public void setLearningComTypeCategorieId(Integer learningComTypeCategorieId) {
        this.learningComTypeCategorieId = learningComTypeCategorieId;
    }

    public Integer getLearningComCategorieId() {
        return learningComCategorieId;
    }

    public void setLearningComCategorieId(Integer learningComCategorieId) {
        this.learningComCategorieId = learningComCategorieId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public CreatedBy1 getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy1 createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Object lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLearningComTypeCategorie() {
        return learningComTypeCategorie;
    }

    public void setLearningComTypeCategorie(String learningComTypeCategorie) {
        this.learningComTypeCategorie = learningComTypeCategorie;
    }

    public String getLearningComCategorie() {
        return learningComCategorie;
    }

    public void setLearningComCategorie(String learningComCategorie) {
        this.learningComCategorie = learningComCategorie;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Integer getTotalMessages() {
        return totalMessages;
    }

    public void setTotalMessages(Integer totalMessages) {
        this.totalMessages = totalMessages;
    }

    public CategorieType getCategorieType() {
        return categorieType;
    }

    public void setCategorieType(CategorieType categorieType) {
        this.categorieType = categorieType;
    }

    public List<GroupsId> getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(List<GroupsId> groupsId) {
        this.groupsId = groupsId;
    }

}
