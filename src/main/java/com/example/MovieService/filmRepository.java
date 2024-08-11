package com.example.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface filmRepository extends JpaRepository<Film,Integer> {
}
