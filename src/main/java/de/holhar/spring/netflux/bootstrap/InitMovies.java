package de.holhar.spring.netflux.bootstrap;

import de.holhar.spring.netflux.domain.Movie;
import de.holhar.spring.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitMovies.class);

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambs", "Aeon Flux", "Enter the Void", "The Terminator", "Back to " +
                                "the Future", "Meet the Parents", "Lord of the Rings")
                                .map(Movie::new)
                                .flatMap(movieRepository::save)
                ).subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(movie -> logger.info("{}", movie));
                });
    }
}
