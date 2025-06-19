package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class UserProfileResponseData {

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
    @SerializedName("isAdmin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("business_id")
    @Expose
    private Integer businessId;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("profile_picture_name")
    @Expose
    private ProfilePictureName profilePictureName;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;

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

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
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

    public ProfilePictureName getProfilePictureName() {
        return profilePictureName;
    }

    public void setProfilePictureName(ProfilePictureName profilePictureName) {
        this.profilePictureName = profilePictureName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

}
