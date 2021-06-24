package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.services.CategoriesService;
import com.launchacademy.reviews.services.ReviewService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reviews")
public class ApiV1ReviewsController {

  private ReviewService reviewService;
  private CategoriesService categoriesService;

  @Autowired
  public ApiV1ReviewsController(ReviewService reviewService,
      CategoriesService categoriesService) {
    this.reviewService = reviewService;
    this.categoriesService = categoriesService;
  }
}
