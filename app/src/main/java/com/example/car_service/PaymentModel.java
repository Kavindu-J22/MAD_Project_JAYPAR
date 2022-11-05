package com.example.car_service;

public class PaymentModel  {

    String CarNo,BookingId,Date,OwnerName,FullAmount;
    PaymentModel(){

    }

    public PaymentModel(String carNo, String bookingId, String date, String ownerName, String fullAmount) {
        CarNo = carNo;
        BookingId = bookingId;
        Date = date;
        OwnerName = ownerName;
        FullAmount = fullAmount;
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

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getFullAmount() {
        return FullAmount;
    }

    public void setFullAmount(String fullAmount) {
        FullAmount = fullAmount;
    }
}