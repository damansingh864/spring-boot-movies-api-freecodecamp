package dev.damanvir.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


// This controller handle the apiRequest
@RestController
@RequestMapping("/api/v1/movies") // So any request to /api/v1/movies will be handled by this controller
public class MovieController {
  @Autowired
  private MovieService movieService;
  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {  // ResponseEntity<String> this is a generic type
    return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
//    return new ResponseEntity<String>("All Movies!", HttpStatus.OK);
  }

  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) { // @PathVariable -- which lets the framework know that we will be passing the information we got in the mapping as a path variable Or we will be using the information passed in the PATH variable as a string or just objectId
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
  }
}
