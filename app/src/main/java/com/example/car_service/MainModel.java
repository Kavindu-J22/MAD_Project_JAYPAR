package com.example.car_service;

public class MainModel {

    String CarNo,BookingId,Date,Problem,TotalCost;

    MainModel(){

    }

    public MainModel(String carNo, String bookingId, String date, String problem, String totalCost) {
        CarNo = carNo;
        BookingId = bookingId;
        Date = date;
        Problem = problem;
        TotalCost = totalCost;

    }

    public String getCarNo() {
        return CarNo;
    }

    public void setCarNo(String carNo) {
        CarNo = carNo;
    }

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }

    public String getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(String totalCost) {
        TotalCost = totalCost;
    }

}