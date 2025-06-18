package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class CreatedBy1 {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("business_id")
    @Expose
    private Integer businessId;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("profile_picture_name")
    @Expose
    private Object profilePictureName;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;
    @SerializedName("phone_number")
    @Expose
    private Object phoneNumber;
    @SerializedName("business")
    @Expose
    private Business business;
    @SerializedName("register_date")
    @Expose
    private String registerDate;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("group_id")
    @Expose
    private Integer groupId;
    @SerializedName("groups_id")
    @Expose
    private List<Integer> groupsId;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("regions_id")
    @Expose
    private List<Integer> regionsId;
    @SerializedName("region")
    @Expose
    private Boolean region;
    @SerializedName("job_id")
    @Expose
    private Integer jobId;
    @SerializedName("jobs_id")
    @Expose
    private List<Integer> jobsId;
    @SerializedName("job")
    @Expose
    private Boolean job;
    @SerializedName("status_activate_name")
    @Expose
    private String statusActivateName;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Object getProfilePictureName() {
        return profilePictureName;
    }

    public void setProfilePictureName(Object profilePictureName) {
        this.profilePictureName = profilePictureName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public List<Integer> getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(List<Integer> groupsId) {
        this.groupsId = groupsId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Integer> getRegionsId() {
        return regionsId;
    }

    public void setRegionsId(List<Integer> regionsId) {
        this.regionsId = regionsId;
    }

    public Boolean getRegion() {
        return region;
    }

    public void setRegion(Boolean region) {
        this.region = region;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public List<Integer> getJobsId() {
        return jobsId;
    }

    public void setJobsId(List<Integer> jobsId) {
        this.jobsId = jobsId;
    }

    public Boolean getJob() {
        return job;
    }

    public void setJob(Boolean job) {
        this.job = job;
    }

    public String getStatusActivateName() {
        return statusActivateName;
    }

    public void setStatusActivateName(String statusActivateName) {
        this.statusActivateName = statusActivateName;
    }

}
