package com.dev.concert.model.dto.response;

import java.time.LocalDateTime;

public class ConcertSessionResponseDto {
    private Long id;
    private String concertTitle;
    private int concertHallCapacity;
    private LocalDateTime sessionTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcertTitle() {
        return concertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        this.concertTitle = concertTitle;
    }

    public int getConcertHallCapacity() {
        return concertHallCapacity;
    }

    public void setConcertHallCapacity(int concertHallCapacity) {
        this.concertHallCapacity = concertHallCapacity;
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }
}
