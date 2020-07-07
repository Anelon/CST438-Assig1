package com.example.assig1;

import java.sql.Timestamp;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class Hello { //localhost:8080/hello?name=andrew

  @Autowired
  MovieRepository movieRepository;

  @GetMapping(value="/hello")
  public String hello(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("time", new java.util.Date().toString());
    return "index";
  }

  @GetMapping("/movies/new")
  public String createMovie(Model model) {
    Movie movie = new Movie();
    model.addAttribute("movie", movie);
    return "movie_form";
  }

  @PostMapping(value="/movies/new")
  public String processMovieForm(@Valid Movie movie, BindingResult result, Model model) {
    if(result.hasErrors()) {
      return "movie_form";
    }
    //probably a more automatic way of doing this but this works
    movie.setDate(new Timestamp(System.currentTimeMillis()));
    movieRepository.save(movie);
    return "movies_show";
  }

  @GetMapping(value="/movies")
  public String getAllMovies(Model model) {
    Iterable<Movie> movie = movieRepository.findAllMovieRatingsOrderByTitleDateDesc();
    model.addAttribute("movies", movie);
    return "movies_list";
  }


}
