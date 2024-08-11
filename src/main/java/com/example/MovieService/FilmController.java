package com.example.MovieService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {


    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @Operation(summary = "Return All Movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie All Founded :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @GetMapping("/movies")
    public ResponseEntity<List<Film>> film() {
        return ResponseEntity.ok(filmService.showAll());
    }


    @Operation(summary = "Get Movie By it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Movie :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @GetMapping("movies/{id}")
    public ResponseEntity<Optional<Film>> filmid(@PathVariable("id") Integer id){
        return ResponseEntity.ok(filmService.showId(id));

    }
    @Operation(summary = "Adding Film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie has been Added :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @PostMapping("/movies")
    public ResponseEntity<Film> addFilm(@RequestBody Film film){
        return ResponseEntity.ok(filmService.addFilm(film));
    }

    @Operation(summary = "Updating Film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Film Has been Updated :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Integer id, @RequestBody Film film) {
        return ResponseEntity.ok(filmService.updateFilm(id, film));
    }
    @Operation(summary = "Get Movie By it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Movie :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Integer id) {
        filmService.delFilm(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Setting Availablity to True")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie Availablity changed :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @PutMapping("/movies/{id}/available")
    public ResponseEntity<Film> setFilmAvailable(@PathVariable Integer id) {
        Optional<Film> filmA = filmService.setFilmAvailable(id);
        return ResponseEntity.ok(filmA.get());
    }


}
