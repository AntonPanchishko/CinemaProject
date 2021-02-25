package com.dev.cinema.controller;

import com.dev.cinema.model.dto.request.MovieRequestDto;
import com.dev.cinema.model.dto.response.MovieResponseDto;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.mapper.MovieMapper;
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
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovie() {
        return movieService
                .getAll().stream()
                .map(movieMapper::toDtoFromObject)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createMovie(@RequestBody @Valid MovieRequestDto movieRequestDto) {
        movieService.add(movieMapper.fromDtoToObject(movieRequestDto));
    }

}