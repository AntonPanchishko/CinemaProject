package com.dev.concert.controller;

import com.dev.concert.model.dto.request.ConcertHallRequestDto;
import com.dev.concert.model.dto.response.ConcertHallResponseDto;
import com.dev.concert.service.ConcertHallService;
import com.dev.concert.service.mapper.ConcertHallMapper;
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
@RequestMapping("/concert-halls")
public class ConcertHallController {
    private final ConcertHallService concertHallService;
    private final ConcertHallMapper concertHallMapper;

    @Autowired
    public ConcertHallController(ConcertHallService concertHallService,
                                 ConcertHallMapper concertHallMapper) {
        this.concertHallService = concertHallService;
        this.concertHallMapper = concertHallMapper;
    }

    @GetMapping
    public List<ConcertHallResponseDto> getAllConcertHalls() {
        return concertHallService
                .getAll().stream()
                .map(concertHallMapper::toDtoFromObject)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createConcertHall(@RequestBody @Valid ConcertHallRequestDto concertHallRequestDto) {
        concertHallService.add(concertHallMapper.fromDtoToObject(concertHallRequestDto));
    }
}
