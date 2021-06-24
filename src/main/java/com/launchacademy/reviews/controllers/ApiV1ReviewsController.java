package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.services.CategoriesService;
import com.launchacademy.reviews.services.ReviewService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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

//  @PostMapping
//  public ResponseEntity addPet(@RequestBody @Valid Pet pet, BindingResult bindingResult) {
//    if (bindingResult.hasErrors()) {
//      Map<String, Map<String, String>> errorsData = new HashMap<>();
//      Map<String, String> errorsMap = new HashMap<>();
//      for(FieldError error :  bindingResult.getFieldErrors()){
//        errorsMap.put(error.getField(), error.getDefaultMessage());
//      }
//      errorsData.put("errors", errorsMap);
//      return new ResponseEntity<Object>(errorsData, HttpStatus.UNPROCESSABLE_ENTITY);
//    } else {
//      PetType petType= petTypeService.findById(pet.getPetTypeId());
//      pet.setPetType(petType);
//      Map<String, Pet> petData = new HashMap<>();
//      petService.saveAsAvailable(pet);
//      petData.put("pet", pet);
//      return new ResponseEntity<Object>(petData, HttpStatus.CREATED);
//    }
//  }


//
//  @PostMapping
//  public Map<String, Review> createReview(@RequestBody Map<String, String> newReview) {
//    Review review = new Review();
//    Map<String, Review> persistedReview = new HashMap<>();
//    review.setUserName(newReview.get("name"));
//    review.setRating(Integer.valueOf(newReview.get("rating")));
//    review.setReview(newReview.get("review"));
//    review.setLongestRelationship(Integer.valueOf(newReview.get("longestRelationship")));
//    reviewService.save(review);
//    persistedReview.put("review", review);
//
//    return persistedReview;
//  }

}
