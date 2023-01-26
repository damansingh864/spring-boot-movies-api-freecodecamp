package dev.damanvir.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
  @Autowired // Autowired will let framework know we want the framework to instantiate this class here for us.
  private MovieRepository movieRepository; // Reference Of Repository
  public List<Movie> allMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> singleMovie(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
  }
}
