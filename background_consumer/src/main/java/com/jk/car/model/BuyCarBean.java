package com.jk.car.model;

import java.io.Serializable;
import java.util.Date;

public class BuyCarBean implements Serializable {

    private static final long serialVersionUID = 8454113456373578046L;
    private Integer id;

    private String cartype;

    private String carSeries;

    private Date carLicenseYear;

    private String carLicenseMonth;

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
    private Integer min;
    private Integer max;

    private String startTime;
    private String endTime;


    private String carImg;

    private String carDetails;

    private Integer carTime;

    private Integer carage;

    private Integer mileage;

    private Integer carpart;

    private Integer carshift;

    private Integer carseat;

    private String carYearString;

    private String carMonthString;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCartype() {
        return cartype;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
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

    public String getCarLicenseMonth() {
        return carLicenseMonth;
    }

    public void setCarLicenseMonth(String carLicenseMonth) {
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

    public Integer getCarTime() {
        return carTime;
    }

    public void setCarTime(Integer carTime) {
        this.carTime = carTime;
    }

    public Integer getCarage() {
        return carage;
    }

    public void setCarage(Integer carage) {
        this.carage = carage;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getCarpart() {
        return carpart;
    }

    public void setCarpart(Integer carpart) {
        this.carpart = carpart;
    }

    public Integer getCarshift() {
        return carshift;
    }

    public void setCarshift(Integer carshift) {
        this.carshift = carshift;
    }

    public Integer getCarseat() {
        return carseat;
    }

    public void setCarseat(Integer carseat) {
        this.carseat = carseat;
    }

    public String getCarYearString() {
        return carYearString;
    }

    public void setCarYearString(String carYearString) {
        this.carYearString = carYearString == null ? null : carYearString.trim();
    }

    public String getCarMonthString() {
        return carMonthString;
    }

    public void setCarMonthString(String carMonthString) {
        this.carMonthString = carMonthString == null ? null : carMonthString.trim();
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

    @Override
    public String toString() {
        return "BuyCarBean{" +
                "id=" + id +
                ", cartype='" + cartype + '\'' +
                ", carSeries='" + carSeries + '\'' +
                ", carLicenseYear=" + carLicenseYear +
                ", carLicenseMonth='" + carLicenseMonth + '\'' +
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
                ", min=" + min +
                ", max=" + max +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", carImg='" + carImg + '\'' +
                ", carDetails='" + carDetails + '\'' +
                ", carTime=" + carTime +
                ", carage=" + carage +
                ", mileage=" + mileage +
                ", carpart=" + carpart +
                ", carshift=" + carshift +
                ", carseat=" + carseat +
                ", carYearString='" + carYearString + '\'' +
                ", carMonthString='" + carMonthString + '\'' +
                '}';
    }
}