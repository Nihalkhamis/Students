package com.students.students.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentsModel {

    @SerializedName("TranieeRecordNo")
    @Expose
    private Integer tranieeRecordNo;
    @SerializedName("Tr_Name")
    @Expose
    private String trName;
    @SerializedName("DefaultPricingGroup")
    @Expose
    private Integer defaultPricingGroup;
    @SerializedName("PricingGroupTitle")
    @Expose
    private String pricingGroupTitle;
    @SerializedName("ClassTitle")
    @Expose
    private String classTitle;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("GenderID")
    @Expose
    private Integer genderID;
    @SerializedName("EduClassID")
    @Expose
    private Integer eduClassID;
    @SerializedName("Remark")
    @Expose
    private String remark;

    public Integer getTranieeRecordNo() {
        return tranieeRecordNo;
    }

    public void setTranieeRecordNo(Integer tranieeRecordNo) {
        this.tranieeRecordNo = tranieeRecordNo;
    }

    public String getTrName() {
        return trName;
    }

    public void setTrName(String trName) {
        this.trName = trName;
    }

    public Integer getDefaultPricingGroup() {
        return defaultPricingGroup;
    }

    public void setDefaultPricingGroup(Integer defaultPricingGroup) {
        this.defaultPricingGroup = defaultPricingGroup;
    }

    public String getPricingGroupTitle() {
        return pricingGroupTitle;
    }

    public void setPricingGroupTitle(String pricingGroupTitle) {
        this.pricingGroupTitle = pricingGroupTitle;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getGenderID() {
        return genderID;
    }

    public void setGenderID(Integer genderID) {
        this.genderID = genderID;
    }

    public Integer getEduClassID() {
        return eduClassID;
    }

    public void setEduClassID(Integer eduClassID) {
        this.eduClassID = eduClassID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
