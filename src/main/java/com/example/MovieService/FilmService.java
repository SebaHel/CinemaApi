package com.example.MovieService;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmService {

    private final filmRepository filmRepository;

    public FilmService(com.example.MovieService.filmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> showAll(){
        return filmRepository.findAll();
    }
    public Optional<Film> showId(Integer id){

        return filmRepository.findById(id);

    }
    public Film addFilm(Film film) throws MovieBadRequestException{
        Film film3 = new Film();
        film3.setKategoria(film.getKategoria());
        film3.setName(film.getName());

        return filmRepository.save(film3);
    }

    public Film updateFilm(Integer id, Film film)  throws MovieNotFoundException{
        Optional<Film> existingFilm = filmRepository.findById(id);
        if (existingFilm.isPresent()) {
            Film UpdatedFilm = existingFilm.get();
            UpdatedFilm.setName(film.getName());
            UpdatedFilm.setKategoria(film.getKategoria());
            UpdatedFilm.setNumber_of_minute(film.getNumber_of_minute());
            return filmRepository.save(UpdatedFilm);
        } else {
            return null;
        }
    }


    public Optional<Film> setFilmAvailable(Integer id) {
        Optional<Film> existingFilm = filmRepository.findById(id);
        if (existingFilm.isPresent()) {
            Film film = existingFilm.get();
            film.setIs_Available(true);
            filmRepository.save(film);
            return Optional.of(film);
        } else {
            return Optional.empty();
        }
    }

    public void delFilm(Integer id){
        filmRepository.deleteById(id);
    }

}
