package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Advisor {

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
    @SerializedName("employee_number")
    @Expose
    private String employeeNumber;
    @SerializedName("status_invitation")
    @Expose
    private String statusInvitation;
    @SerializedName("register_date")
    @Expose
    private String registerDate;
    @SerializedName("status_activate")
    @Expose
    private String statusActivate;
    @SerializedName("desactivate_date")
    @Expose
    private Object desactivateDate;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
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
    private Business1 business;
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

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getStatusInvitation() {
        return statusInvitation;
    }

    public void setStatusInvitation(String statusInvitation) {
        this.statusInvitation = statusInvitation;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getStatusActivate() {
        return statusActivate;
    }

    public void setStatusActivate(String statusActivate) {
        this.statusActivate = statusActivate;
    }

    public Object getDesactivateDate() {
        return desactivateDate;
    }

    public void setDesactivateDate(Object desactivateDate) {
        this.desactivateDate = desactivateDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public Business1 getBusiness() {
        return business;
    }

    public void setBusiness(Business1 business) {
        this.business = business;
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
