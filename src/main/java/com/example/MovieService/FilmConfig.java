package com.example.MovieService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FilmConfig {
    @Bean
    CommandLineRunner commandLineRunner(filmRepository jpaTaskRepository) {
        return args -> {
            Film film1 = new Film(1, "Hobbit", category.FANTASY, 125);
            Film film2 = new Film(2, "Terminator", category.ACTION, 135);

            jpaTaskRepository.saveAll(List.of(film1, film2));

        };
    }
}
