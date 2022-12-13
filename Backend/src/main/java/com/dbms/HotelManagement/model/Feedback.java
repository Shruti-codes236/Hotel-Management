package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Feedback {
    private UUID feedbackID;
    private String reviews;
    private String suggestions;
    private String fDate;
    private String fTime;
    private UUID bookingID;

    public Feedback() {
    }

    public Feedback(UUID feedbackID, String reviews, String suggestions, String date, String time, UUID bookingID) {
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

    public String getfDate() {
        return fDate;
    }

    public void setfDate(String date) {
        this.fDate = date;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String time) {
        this.fTime = time;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
