package com.dev.concert.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class ConcertSessionRequestDto {
    @NotNull
    private Long concertId;
    @NotNull
    private Long concertHallId;
    @NotNull
    private String sessionTime;

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public Long getConcertHallId() {
        return concertHallId;
    }

    public void setConcertHallId(Long concertHallId) {
        this.concertHallId = concertHallId;
    }
}
