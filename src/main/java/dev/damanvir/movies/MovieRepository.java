package dev.damanvir.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Repository so that framework knows this is repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
  Optional<Movie> findMovieByImdbId(String imdbId);
}
