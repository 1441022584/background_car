package com.jk.car.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Car implements Serializable {

    private static final long serialVersionUID = 6347863424235391297L;

    private Integer id;

    private String carType;

    private String carSeries;

    private Date carLicenseYear;

    private Date carLicenseMonth;

    private String carRoadroller;

    private String carLicencesto;

    private String carVehiclecondition;

    private String carDemand;

    private Integer userId;

    private Double carPrice;

    private Double carDisplacement;

    private String carLicenseplatenumber;

    private Integer carStatus;

    private String carSite;

    private Integer carParameter;

    private String carImg;

    private String carDetails;

    private UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries == null ? null : carSeries.trim();
    }

    public Date getCarLicenseYear() {
        return carLicenseYear;
    }

    public void setCarLicenseYear(Date carLicenseYear) {
        this.carLicenseYear = carLicenseYear;
    }

    public Date getCarLicenseMonth() {
        return carLicenseMonth;
    }

    public void setCarLicenseMonth(Date carLicenseMonth) {
        this.carLicenseMonth = carLicenseMonth;
    }

    public String getCarRoadroller() {
        return carRoadroller;
    }

    public void setCarRoadroller(String carRoadroller) {
        this.carRoadroller = carRoadroller == null ? null : carRoadroller.trim();
    }

    public String getCarLicencesto() {
        return carLicencesto;
    }

    public void setCarLicencesto(String carLicencesto) {
        this.carLicencesto = carLicencesto == null ? null : carLicencesto.trim();
    }

    public String getCarVehiclecondition() {
        return carVehiclecondition;
    }

    public void setCarVehiclecondition(String carVehiclecondition) {
        this.carVehiclecondition = carVehiclecondition == null ? null : carVehiclecondition.trim();
    }

    public String getCarDemand() {
        return carDemand;
    }

    public void setCarDemand(String carDemand) {
        this.carDemand = carDemand == null ? null : carDemand.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public Double getCarDisplacement() {
        return carDisplacement;
    }

    public void setCarDisplacement(Double carDisplacement) {
        this.carDisplacement = carDisplacement;
    }

    public String getCarLicenseplatenumber() {
        return carLicenseplatenumber;
    }

    public void setCarLicenseplatenumber(String carLicenseplatenumber) {
        this.carLicenseplatenumber = carLicenseplatenumber == null ? null : carLicenseplatenumber.trim();
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarSite() {
        return carSite;
    }

    public void setCarSite(String carSite) {
        this.carSite = carSite == null ? null : carSite.trim();
    }

    public Integer getCarParameter() {
        return carParameter;
    }

    public void setCarParameter(Integer carParameter) {
        this.carParameter = carParameter;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg == null ? null : carImg.trim();
    }

    public String getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails == null ? null : carDetails.trim();
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", carSeries='" + carSeries + '\'' +
                ", carLicenseYear=" + carLicenseYear +
                ", carLicenseMonth=" + carLicenseMonth +
                ", carRoadroller='" + carRoadroller + '\'' +
                ", carLicencesto='" + carLicencesto + '\'' +
                ", carVehiclecondition='" + carVehiclecondition + '\'' +
                ", carDemand='" + carDemand + '\'' +
                ", userId=" + userId +
                ", carPrice=" + carPrice +
                ", carDisplacement=" + carDisplacement +
                ", carLicenseplatenumber='" + carLicenseplatenumber + '\'' +
                ", carStatus=" + carStatus +
                ", carSite='" + carSite + '\'' +
                ", carParameter=" + carParameter +
                ", carImg='" + carImg + '\'' +
                ", carDetails='" + carDetails + '\'' +
                ", userBean=" + userBean +
                '}';
    }
}