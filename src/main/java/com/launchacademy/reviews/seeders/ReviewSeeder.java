package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.ReviewService;
import com.launchacademy.reviews.services.SiteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReviewSeeder {

  private ReviewService reviewService;
  private SiteService siteService;

  public ReviewSeeder(ReviewService reviewService, SiteService siteService) {
    this.reviewService = reviewService;
    this.siteService = siteService;
  }

  public void seed() {
    if (reviewService.findAll().isEmpty()) {
      List<Review> reviewList = new ArrayList<>();

      Site bumble = siteService.findById(1);
      Site match = siteService.findById(2);
      Site okcupid = siteService.findById(3);
      Site zoe = siteService.findById(4);
      Site grindr = siteService.findById(5);

      Review bumble1 = new Review();
      bumble1.setSite(bumble);
      bumble1.setUserName("Sally");
      bumble1.setRating(3);
      bumble1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      bumble1.setLongestRelationship(453);
      reviewList.add(bumble1);

      Review match1 = new Review();
      match1.setSite(match);
      match1.setUserName("Max");
      match1.setRating(5);
      match1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      match1.setLongestRelationship(16);
      reviewList.add(match1);

      Review okCupid1 = new Review();
      okCupid1.setSite(okcupid);
      okCupid1.setUserName("Marco");
      okCupid1.setRating(5);
      okCupid1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      okCupid1.setLongestRelationship(243);
      reviewList.add(okCupid1);

      Review grindr1 = new Review();
      grindr1.setSite(grindr);
      grindr1.setReview(
          "in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
      grindr1.setRating(2);
      grindr1.setLongestRelationship(24);
      reviewList.add(grindr1);
      
      for (Review review : reviewList) {
        reviewService.save(review);
      }

    }
  }
}
