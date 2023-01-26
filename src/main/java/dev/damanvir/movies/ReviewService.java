package dev.damanvir.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private MongoTemplate mongoTemplate; // There are times when a repository just doesn't cut it, maybe you have an operations so complex that it cannot be implemented within a repository, or event if you can implement it within a repository, it will be not suitable.
  public Review createReview(String reviewBody, String imdbId) {
    Review review = reviewRepository.insert(new Review(reviewBody));


    mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIds").value(review))
            .first();

    return review;
  }
}
