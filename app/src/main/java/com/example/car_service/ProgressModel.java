package com.example.car_service;

public class ProgressModel  {

    String CarNo,BookingId;

    ProgressModel(){

    }

    public ProgressModel(String carNo, String bookingId) {
        this.CarNo = carNo;
        this.BookingId = bookingId;
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
}