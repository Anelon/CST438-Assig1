package com.example.assig1;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Movie {

  @Id
  @GeneratedValue
  private long id;

  @NotNull
  @Size(min=3, max=25)
  private String title;
  @NotNull
  @Min(1)
  @Max(5)
  private int rating;
  @NotNull
  @Size(min=3, max=25)
  private String name;

  @GeneratedValue
  @Basic
  private Timestamp date;

  public Movie() {
  }

  public Movie(long id, String title, int rating, String name, Timestamp date) {
    this.id = id;
    this.title = title;
    this.rating = rating;
    this.name = name;
    this.date = date;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }
}
