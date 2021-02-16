package com.dev.cinema.model.dto.response;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private String movieTitle;
    private int cinemaHallCapacity;
    private LocalDateTime sessionTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getCinemaHallCapacity() {
        return cinemaHallCapacity;
    }

    public void setCinemaHallCapacity(int cinemaHallCapacity) {
        this.cinemaHallCapacity = cinemaHallCapacity;
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }
}
