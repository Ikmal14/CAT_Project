package com.example.healthpoint_final;

public class AppointmentObj {
    public AppointmentObj() {
    }


    public AppointmentObj(String status, String userEmail, String feedback, String date, String appointmentId) {
        this.status = status;
        this.userEmail = userEmail;
        this.feedback = feedback;
        this.date = date;
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }


    String status;
    String userEmail;
    String feedback;
    String date;
    String appointmentId;
}
