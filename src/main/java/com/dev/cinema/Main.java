package com.dev.cinema;

import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.User;
import com.dev.cinema.security.AuthenticationService;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.cinema");

    public static void main(String[] args) {
        MovieService movieService =
                (MovieService) injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Some title");
        movie.setDescription("Some description");
        movieService.add(movie);
        System.out.println(movieService.getAll());
        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHall.setDescription("Some description");
        cinemaHallService.add(cinemaHall);
        System.out.println(cinemaHallService.getAll());
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setSessionTime(LocalDateTime
                .of(2021, 2, 2, 10, 30));
        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);
        movieSessionService.findAvailableSessions(movie.getId(), LocalDate
                .of(2021, 2, 2)).forEach(System.out::println);

        AuthenticationService authenticationService =
                (AuthenticationService) injector
                        .getInstance(AuthenticationService.class);
        User user = authenticationService.register("SomeEmail@mail.com", "SomePassword");
        try {
            authenticationService.login("SomeEmail@mail.com", "SomePassword");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector
                        .getInstance(ShoppingCartService.class);
        try {
            shoppingCartService.getByUser(authenticationService
                    .login("SomeEmail@mail.com",
                            "SomePassword"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        try {
            shoppingCartService.clear(shoppingCartService
                    .getByUser(authenticationService
                            .login("SomeEmail@mail.com",
                                    "SomePassword")));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        try {
            shoppingCartService.addSession(movieSession, authenticationService
                    .login("SomeEmail@mail.com",
                            "SomePassword"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
