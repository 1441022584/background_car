/**
 * 瓜子预约陪同员工
 */
package com.jk.car.model;

import java.io.Serializable;

public class StaffBean implements Serializable {

    private Integer staffId;
    private String staffName;
    private String staffPhone;
    private String staffArea;
    private Integer staffOrder;


    public String getStaffArea() {
        return staffArea;
    }

    public void setStaffArea(String staffArea) {
        this.staffArea = staffArea;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public Integer getStaffOrder() {
        return staffOrder;
    }

    public void setStaffOrder(Integer staffOrder) {
        this.staffOrder = staffOrder;
    }
}
