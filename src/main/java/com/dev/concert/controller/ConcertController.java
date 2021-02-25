package com.dev.concert.controller;

import com.dev.concert.model.dto.request.ConcertRequestDto;
import com.dev.concert.model.dto.response.ConcertResponseDto;
import com.dev.concert.service.ConcertService;
import com.dev.concert.service.mapper.ConcertMapper;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;
    private final ConcertMapper concertMapper;

    @Autowired
    public ConcertController(ConcertService concertService, ConcertMapper concertMapper) {
        this.concertService = concertService;
        this.concertMapper = concertMapper;
    }

    @GetMapping
    public List<ConcertResponseDto> getAllConcerts() {
        return concertService
                .getAll().stream()
                .map(concertMapper::toDtoFromObject)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createConcert(@RequestBody @Valid ConcertRequestDto concertRequestDto) {
        concertService.add(concertMapper.fromDtoToObject(concertRequestDto));
    }

}
