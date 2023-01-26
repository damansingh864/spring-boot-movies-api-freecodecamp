package dev.damanvir.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") // this will let the framework know that this class sheet presents each document in the movies collection
@Data // So instead of creating getter and setters for each of the private property. We can use @Data from lombok project. It takes care of all getter setter of the string methods
@AllArgsConstructor // for creating constructor that takes all the private field as arguments
@NoArgsConstructor // Another constructor that not take parameters.
public class Movie {
  @Id   // This will let framework knows that this property treated as unique identifier for each movie inside the database
  private ObjectId id;
  private String imdbId;
  private String title;
  private String releaseDate;
  private String trailerLink;
  private String poster;
  private List<String> genres;
  private List<String> backdrops;
@DocumentReference // So this will cause the database to store only the IDs of the  review. And the  review will be in a separate collection. So this is called manual reference relationship.
  private List<Review> reviewIds; // This will be an embedded relationship. SO all the reviews that are related, this movie will be added to this List of review.
}
