package com.dbms.HotelManagement.extraclass;

import java.util.UUID;

public class frontFeedback {
    private UUID feedbackID;
    private String reviews;
    private String suggestions;
    private String fDate;
    private String fTime;
    private String bookingID;

    public frontFeedback() {
    }

    public frontFeedback(UUID feedbackID, String reviews, String suggestions, String date, String time, String bookingID) {
        this.feedbackID = feedbackID;
        this.reviews = reviews;
        this.suggestions = suggestions;
        this.fDate = date;
        this.fTime = time;
        this.bookingID = bookingID;
    }

    public UUID getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(UUID feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getDate() {
        return fDate;
    }

    public void setDate(String date) {
        this.fDate = date;
    }

    public String getTime() {
        return fTime;
    }

    public void setTime(String time) {
        this.fTime = time;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
}
