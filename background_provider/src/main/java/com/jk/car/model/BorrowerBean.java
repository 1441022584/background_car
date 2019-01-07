package com.jk.car.model;

import java.io.Serializable;

public class BorrowerBean implements Serializable {

    private  Integer id;
    private  Integer marriage;  //婚姻状况
    private  Integer work ;     //工作状况
    private  Integer education; //教育水平
    private  Integer housing;   //住房状况
    private  String phone;     //手机号
    private  Integer statusLoans;//当前的贷款状态
    private  String followTime;//最后跟单时间
    private  String applyTime; //贷款申请时间
    private  String startTime; //条查开始时间
    private  String endTime;    //条查结束时间
    private Integer staffId;    //陪看人员id
    private String staffName;    //陪看人员id
    private String staffPhone;    //陪看人员id
    private String loansCompact;   //贷款合同


    public String getLoansCompact() {
        return loansCompact;
    }

    public void setLoansCompact(String loansCompact) {
        this.loansCompact = loansCompact;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStatusLoans() {
        return statusLoans;
    }
    public void setStatusLoans(Integer statusLoans) {
        this.statusLoans = statusLoans;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFollowTime() {
        return followTime;
    }

    public void setFollowTime(String followTime) {
        this.followTime = followTime;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getHousing() {
        return housing;
    }

    public void setHousing(Integer housing) {
        this.housing = housing;
    }
}
