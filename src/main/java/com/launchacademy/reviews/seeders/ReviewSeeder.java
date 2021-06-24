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
      Site lex = siteService.findById(6);
      Site silverSingles = siteService.findById(7);
      Site ourTime = siteService.findById(8);
      Site seniorMatch = siteService.findById(9);
      Site singleParentMeet = siteService.findById(10);
      Site eliteSingles = siteService.findById(11);
      Site seattleDatingApp = siteService.findById(12);
      Site massProfessionalSingles = siteService.findById(13);

      Review bumble1 = new Review();
      bumble1.setSite(bumble);
      bumble1.setUserName("Sally");
      bumble1.setRating(3);
      bumble1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      bumble1.setLongestRelationship(453);
      reviewList.add(bumble1);

      Review bumble2 = new Review();
      bumble2.setUserName("Tommy");
      bumble2.setSite(bumble);
      bumble2.setRating(2);
      bumble2.setLongestRelationship(9);
      bumble2.setReview(
          "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. ");
      reviewList.add(bumble2);

      Review match1 = new Review();
      match1.setSite(match);
      match1.setUserName("Max");
      match1.setRating(5);
      match1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      match1.setLongestRelationship(16);
      reviewList.add(match1);

      Review match2 = new Review();
      match2.setSite(match);
      match2.setUserName("Samantha");
      match2.setRating(1);
      match2.setReview(
          "ontrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC");
      match2.setLongestRelationship(7);
      reviewList.add(match2);

      Review okCupid1 = new Review();
      okCupid1.setSite(okcupid);
      okCupid1.setUserName("Marco");
      okCupid1.setRating(5);
      okCupid1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      okCupid1.setLongestRelationship(243);
      reviewList.add(okCupid1);

      Review okCupid2 = new Review();
      okCupid2.setSite(okcupid);
      okCupid2.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      okCupid2.setRating(5);
      okCupid2.setLongestRelationship(4);
      reviewList.add(okCupid2);

      Review zoe1 = new Review();
      zoe1.setSite(zoe);
      zoe1.setUserName("Polo");
      zoe1.setRating(2);
      zoe1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      zoe1.setLongestRelationship(45);
      reviewList.add(zoe1);

      Review zoe2 = new Review();
      zoe2.setSite(zoe);
      zoe2.setUserName("Frank");
      zoe2.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      zoe2.setRating(5);
      zoe2.setLongestRelationship(1);
      reviewList.add(zoe2);

      Review grindr1 = new Review();
      grindr1.setSite(grindr);
      grindr1.setReview(
          "in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
      grindr1.setRating(2);
      grindr1.setLongestRelationship(24);
      reviewList.add(grindr1);

      Review grindr2 = new Review();
      grindr2.setSite(grindr);
      grindr2.setUserName("Micheal");
      grindr2.setRating(3);
      grindr2.setReview(
          "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32");
      grindr2.setLongestRelationship(7);
      reviewList.add(grindr2);

      Review lex1 = new Review();
      lex1.setSite(lex);
      lex1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      lex1.setRating(2);
      lex1.setLongestRelationship(24);
      reviewList.add(lex1);

      Review lex2 = new Review();
      lex2.setSite(lex);
      lex2.setUserName("Olive");
      lex2.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      lex2.setRating(3);
      lex2.setLongestRelationship(56);
      reviewList.add(lex2);

      Review silverSingles1 = new Review();
      silverSingles1.setSite(silverSingles);
      silverSingles1.setUserName("Amanda");
      silverSingles1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      silverSingles1.setRating(5);
      silverSingles1.setLongestRelationship(1200);
      reviewList.add(silverSingles1);

      Review silverSingles2 = new Review();
      silverSingles2.setSite(silverSingles);
      silverSingles2.setRating(1);
      silverSingles2.setReview(
          "ontrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC");
      silverSingles2.setLongestRelationship(200);
      reviewList.add(silverSingles2);

      Review ourTime1 = new Review();
      ourTime1.setSite(ourTime);
      ourTime1.setUserName("Florence");
      ourTime1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      ourTime1.setRating(4);
      ourTime1.setLongestRelationship(460);
      reviewList.add(ourTime1);

      Review ourTime2 = new Review();
      ourTime2.setSite(ourTime);
      ourTime2.setUserName("Brayan");
      ourTime2.setReview("This was cool");
      ourTime2.setRating(5);
      ourTime2.setLongestRelationship(1203);
      reviewList.add(ourTime2);

      Review seniorMatch1 = new Review();
      seniorMatch1.setSite(seniorMatch);
      seniorMatch1.setUserName("Simon");
      seniorMatch1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      seniorMatch1.setRating(5);
      seniorMatch1.setLongestRelationship(250);
      reviewList.add(seniorMatch1);

      Review seniorMatch2 = new Review();
      seniorMatch2.setSite(seniorMatch);
      seniorMatch2.setUserName("John");
      seniorMatch2.setReview(
          "and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, ");
      seniorMatch2.setRating(4);
      seniorMatch2.setLongestRelationship(3454);
      reviewList.add(seniorMatch2);

      Review singleParentMeet1 = new Review();
      singleParentMeet1.setSite(singleParentMeet);
      singleParentMeet1.setUserName("Simon");
      singleParentMeet1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      singleParentMeet1.setRating(3);
      singleParentMeet1.setLongestRelationship(45);
      reviewList.add(singleParentMeet1);

      Review eliteSingle1 = new Review();
      eliteSingle1.setSite(eliteSingles);
      eliteSingle1.setUserName("Nick");
      eliteSingle1.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      eliteSingle1.setRating(3);
      eliteSingle1.setLongestRelationship(520);
      reviewList.add(eliteSingle1);

      Review eliteSingles2 = new Review();
      eliteSingles2.setSite(eliteSingles);
      eliteSingles2.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      eliteSingles2.setRating(5);
      eliteSingles2.setLongestRelationship(450);
      reviewList.add(eliteSingles2);

      Review seattleDatingApp1 = new Review();
      seattleDatingApp1.setSite(seattleDatingApp);
      seattleDatingApp1.setUserName("Nick");
      seattleDatingApp1.setReview(
          "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will");
      seattleDatingApp1.setRating(3);
      seattleDatingApp1.setLongestRelationship(520);
      reviewList.add(seattleDatingApp1);

      Review seattleDatingApp2 = new Review();
      seattleDatingApp2.setSite(seattleDatingApp);
      seattleDatingApp2.setUserName("Johnny");
      seattleDatingApp2.setReview(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
      seattleDatingApp2.setRating(4);
      seattleDatingApp2.setLongestRelationship(5206);
      reviewList.add(seattleDatingApp2);

      Review massProfessionalSingles1 = new Review();
      massProfessionalSingles1.setSite(massProfessionalSingles);
      massProfessionalSingles1.setUserName("Mass");
      massProfessionalSingles1.setReview(
          "and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, ");
      massProfessionalSingles1.setRating(4);
      massProfessionalSingles1.setLongestRelationship(777);
      reviewList.add(massProfessionalSingles1);

      Review massProfessionalSingles2 = new Review();
      massProfessionalSingles2.setSite(massProfessionalSingles);
      massProfessionalSingles2.setRating(3);
      massProfessionalSingles2.setReview(
          "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will");
      massProfessionalSingles2.setLongestRelationship(700);
      reviewList.add(massProfessionalSingles2);

      for (Review review : reviewList) {
        reviewService.save(review);
      }

    }
  }
}
