package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.Feedback;
import com.dbms.HotelManagement.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void addFeedback(UUID feedbackID, String reviews, String suggestions, LocalDate date, LocalTime time, UUID customerID) {
        feedbackRepository.addFeedback(feedbackID, reviews, suggestions, date, time, customerID);
    }

    public List<Feedback> getAllFeedback(){
        return feedbackRepository.getAllFeedback();
    }
}