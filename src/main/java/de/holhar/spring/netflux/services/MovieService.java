package de.holhar.spring.netflux.services;

import de.holhar.spring.netflux.domain.Movie;
import de.holhar.spring.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Mono<Movie> getMovieById(String id);
    Flux<Movie> getAllMovies();
    Flux<MovieEvent> streamMovieEvents(String id);
}
