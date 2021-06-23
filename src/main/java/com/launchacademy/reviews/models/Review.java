package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reviews")
public class Review {
  @Id
  @SequenceGenerator(name="reviews_generator", sequenceName = "reviewsid_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reviews_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "user_name")
  private String userName = "Anonymous";

  @Min(1)
  @Max(5)
  @NotNull
  @Column(name = "rating")
  private Integer rating;

  @Length(max = 765)
  @Column(name = "review")
  private String review;

  @Column(name="logest_relationship")
  private Integer longestRelationship;

  @ManyToOne
  @JsonIgnoreProperties("reviews")
  @JoinColumn(name = "site_id")
  private Site site;
}
