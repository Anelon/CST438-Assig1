package com.example.assig1;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
  @Query("select m from Movie m order by m.title, m.date desc")
  List<Movie> findAllMovieRatingsOrderByTitleDateDesc();
}
