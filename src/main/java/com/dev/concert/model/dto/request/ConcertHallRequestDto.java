package com.dev.concert.model.dto.request;

import jakarta.validation.constraints.Min;

public class ConcertHallRequestDto {
    @Min(1)
    private int capacity;
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
