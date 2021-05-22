package com.Carrepair;

public class Customer {
    private int customerId;
    private String customerNm;
    private String carsModel;
    private String carsnumber;
    private String carAdd;
    private String customerPHno;
    private String time;
    private String datetime;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNm() {
        return customerNm;
    }

    public void setCustomerNm(String customerNm) {
        this.customerNm = customerNm;
    }

    public String getCarsModel() {
        return carsModel;
    }

    public void setCarsModel(String carsModel) {
        this.carsModel = carsModel;
    }

    public String getCarsnumber() {
        return carsnumber;
    }

    public void setCarsnumber(String carsnumber) {
        this.carsnumber = carsnumber;
    }

    public String getCarAdd() {
        return carAdd;
    }

    public void setCarAdd(String carAdd) {
        this.carAdd = carAdd;
    }

    public String getCustomerPHno() {
        return customerPHno;
    }

    public void setCustomerPHno(String customerPHno) {
        this.customerPHno = customerPHno;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Customer(int customerId, String customerNm, String carsModel, String carsnumber, String carAdd, String customerPHno, String time, String datetime) {
        super();
        this.customerId = customerId;
        this.customerNm = customerNm;
        this.carsModel = carsModel;
        this.carsnumber = carsnumber;
        this.carAdd = carAdd;
        this.customerPHno = customerPHno;
        this.time = time;
        this.datetime = datetime;
    }

    public Customer(String customerNm, String carsModel, String carsnumber, String carAdd, String customerPHno, String time, String datetime) {
        super();
        this.customerNm = customerNm;
        this.carsModel = carsModel;
        this.carsnumber = carsnumber;
        this.carAdd = carAdd;
        this.customerPHno = customerPHno;
        this.time = time;
        this.datetime = datetime;
    }

    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerNm='" + customerNm + '\'' +
                ", carsModel='" + carsModel + '\'' +
                ", carsnumber='" + carsnumber + '\'' +
                ", carAdd='" + carAdd + '\'' +
                ", customerPHno='" + customerPHno + '\'' +
                ", time='" + time + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
