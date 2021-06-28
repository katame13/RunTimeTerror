package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.CategoriesService;
import com.launchacademy.reviews.services.ReviewService;
import com.launchacademy.reviews.services.SiteService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reviews")
public class ApiV1ReviewsController {

  private ReviewService reviewService;
  private CategoriesService categoriesService;
  private SiteService siteService;

  @Autowired
  public ApiV1ReviewsController(SiteService siteService,
    ReviewService reviewService,
    CategoriesService categoriesService) {
    this.siteService = siteService;
    this.reviewService = reviewService;
    this.categoriesService = categoriesService;
  }


    @PostMapping("/{id}/addreview")
  public ResponseEntity createReview(@PathVariable Integer id, @RequestBody @Valid Review review,
    BindingResult bindingResult) {
    System.out.println("inside addReview");
    if (bindingResult.hasErrors()) {
      System.out.println("has errors");
      Map<String, Map<String, String>> errorsData = new HashMap<>();
      Map<String, String> errorsMap = new HashMap<>();
      for (FieldError error : bindingResult.getFieldErrors()) {
        errorsMap.put(error.getField(), error.getDefaultMessage());
      }
      errorsData.put("errors", errorsMap);
      return new ResponseEntity<Object>(errorsData, HttpStatus.UNPROCESSABLE_ENTITY);
    } else {
      System.out.println("happy path");
      Site site = siteService.findById(id);
      review.setSite(site);
      Map<String, Review> reviewData = new HashMap<>();
      reviewService.save(review);
      reviewData.put("review", review);
      return new ResponseEntity<Object>(reviewData, HttpStatus.CREATED);
    }
  }
}