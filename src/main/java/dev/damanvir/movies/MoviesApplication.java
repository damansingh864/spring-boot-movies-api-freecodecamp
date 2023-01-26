package dev.damanvir.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
*/

/**
 * To set up MongoDB connection or any other database connection we should go to src -> main -< resources -> application.properties. We have to write different application properties for our project.
 * And in api uri remove the content after /test or /anyOtherContent
 * So putting any content in GitHub resource is not fine. So always put that in env file inside the resources' folder. So we will put application.properties in env file
 * Now problem with Spring. Spring does not support reading .env files out of the box. So we need to install a new dependency to the project. In google search for  maven dependencies and search for your dependencies, we are searching for Spring Dotenv by paulschwarz
 * Now open pom.xml inside the dependencies after the last dependency, we will create new one.
 */

/**
 *  In Rest APIs, usually there are multiple layers. So one of the layer is the API layer, which is this Controller file, and it will only concern itself have about the task of getting a request from the user and returning a response and nothing else. That is what it is doing.  All it's doing is it's using a service class and delegating the task of fetching all the movies from the database. And giving it back to the API layer.
 *  So it calls the  all movies method inside the service, gets the list of the movie and return them with  HTTPStatus.Ok. It doesn't know what's going on inside the service class
 *
 *  Now when we come back to the service class, this is  where most of our business logic will go. So the service class does is it uses the repository class and talks to the database, get the list of the movies and return to the API layer.
 *  Finally, the repository layer is kind of the data access layer for our API. It  does the job of actually talking to the database and getting the data back.
 *
 */

@SpringBootApplication
//@RestController                   //  Rest Controller use to framework knows this class is actually rest api controller
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

//	@GetMapping("/root")   // It lets the framework know that the method apiRoot is a get endpoint
//	public String apiRoot() {
//		return "Hello, World!";
//	}

}
