package com.dev.concert.controller;

import com.dev.concert.model.ConcertSession;
import com.dev.concert.model.dto.request.ConcertSessionRequestDto;
import com.dev.concert.model.dto.response.ConcertSessionResponseDto;
import com.dev.concert.service.ConcertSessionService;
import com.dev.concert.service.mapper.ConcertSessionMapper;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concert-sessions")
public class ConcertSessionController {
    private final ConcertSessionService concertSessionService;
    private final ConcertSessionMapper concertSessionMapper;

    @Autowired
    public ConcertSessionController(ConcertSessionService concertSessionService,
                                    ConcertSessionMapper concertSessionMapper) {
        this.concertSessionService = concertSessionService;
        this.concertSessionMapper = concertSessionMapper;
    }

    @GetMapping("/available")
    public List<ConcertSessionResponseDto> getSessionByDate(@RequestBody Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return concertSessionService
                .findAvailableSessions(movieId, date)
                .stream()
                .map(concertSessionMapper::toDtoFromObject)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createConcertSession(@RequestBody
                                       @Valid ConcertSessionRequestDto concertSessionRequestDto) {
        concertSessionService.add(concertSessionMapper.fromDtoToObject(concertSessionRequestDto));
    }

    @PutMapping("/{id}")
    public void updateConcertSession(@PathVariable Long id, @RequestBody
            @Valid ConcertSessionRequestDto concertSessionRequestDto) {
        ConcertSession concertSession = concertSessionMapper
                .fromDtoToObject(concertSessionRequestDto);
        concertSession.setId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConcertSession(@PathVariable Long id) {
        concertSessionService.delete(id);
    }
}
