package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Feedback;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public class FeedbackRepository {
    private final JdbcTemplate jdbcTemplate;

    public FeedbackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Feedback> getAllFeedback() {
        String sql = "SELECT * FROM Feedback";
        List<Feedback> allFeedback = jdbcTemplate.query(sql, new Object[]{}, FeedbackMapper());
        System.out.println(allFeedback.get(0).getfDate());
        return allFeedback;
    }

    public void addFeedback(UUID feedbackID, String reviews, String suggestions, LocalDate date, LocalTime time, UUID bookingID){
        String sql = "INSERT INTO Feedback(feedbackID, reviews, suggestions, fDate, fTime, bookingID) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, feedbackID.toString(), reviews, suggestions, date, time, bookingID.toString());
    }

    private RowMapper<Feedback> FeedbackMapper() {
        return (resultSet, i) -> {
            return new Feedback(
                    UUID.fromString(resultSet.getString("feedbackID")),
                    resultSet.getString("reviews"),
                    resultSet.getString("suggestions"),
                    resultSet.getDate("fDate").toString(),
                    resultSet.getTime("fTime").toString(),
                    UUID.fromString(resultSet.getString("bookingID"))
            );
        };
    }
}
