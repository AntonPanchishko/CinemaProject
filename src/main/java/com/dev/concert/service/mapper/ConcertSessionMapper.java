package com.dev.concert.service.mapper;

import com.dev.concert.model.ConcertSession;
import com.dev.concert.model.dto.request.ConcertSessionRequestDto;
import com.dev.concert.model.dto.response.ConcertSessionResponseDto;
import com.dev.concert.service.ConcertHallService;
import com.dev.concert.service.ConcertService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConcertSessionMapper {
    private final ConcertService concertService;
    private final ConcertHallService concertHallService;

    @Autowired
    public ConcertSessionMapper(ConcertService concertService,
                                ConcertHallService concertHallService) {
        this.concertService = concertService;
        this.concertHallService = concertHallService;
    }

    public ConcertSession fromDtoToObject(ConcertSessionRequestDto concertSessionRequestDto) {
        ConcertSession concertSession = new ConcertSession();
        concertSession.setConcert(concertService.get(concertSessionRequestDto
                .getConcertId()));
        concertSession.setConcertHall(concertHallService.get(concertSessionRequestDto
                .getConcertHallId()));
        concertSession.setSessionTime(LocalDateTime
                .parse(concertSessionRequestDto.getSessionTime(),
                        DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return concertSession;
    }

    public ConcertSessionResponseDto toDtoFromObject(ConcertSession concertSession) {
        ConcertSessionResponseDto concertSessionResponseDto = new ConcertSessionResponseDto();
        concertSessionResponseDto.setId(concertSession.getId());
        concertSessionResponseDto.setConcertTitle(concertSession.getConcert().getTitle());
        concertSessionResponseDto.setSessionTime(concertSession.getSessionTime());
        concertSessionResponseDto.setConcertHallCapacity(concertSession
                .getConcertHall().getCapacity());
        return concertSessionResponseDto;
    }
}
