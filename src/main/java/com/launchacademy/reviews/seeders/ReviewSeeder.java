package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.services.ReviewService;
import org.springframework.stereotype.Component;

@Component
public class ReviewSeeder {
  private ReviewService reviewService;
  private SiteService siteService;

  public ReviewSeeder(ReviewService reviewService, SiteService siteService) {
    this.reviewService = reviewService;
    this.siteService = siteService;
  }

  public void seed(){
    if(reviewService.findAll().isEmpty()){
      Site site = siteService.findByName("").get(0);
    }
  }
}
