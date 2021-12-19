package de.holhar.spring.netflux.services;

import de.holhar.spring.netflux.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Mono<Movie> getMovieById(String id);
    Flux<Movie> getAllMovies();
}
