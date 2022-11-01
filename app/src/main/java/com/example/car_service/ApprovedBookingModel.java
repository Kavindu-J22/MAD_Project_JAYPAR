package com.example.car_service;

public class ApprovedBookingModel {

    String CarNo,BookingId;

    ApprovedBookingModel(){

    }

    public ApprovedBookingModel(String carNo, String bookingId) {
        CarNo = carNo;
        BookingId = bookingId;
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
