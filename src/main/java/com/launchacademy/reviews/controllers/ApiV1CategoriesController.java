package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.services.CategoriesService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class ApiV1CategoriesController {
  private CategoriesService categoriesService;

  @Autowired
  public ApiV1CategoriesController(CategoriesService categoriesService) {
    this.categoriesService = categoriesService;
  }

  @GetMapping
  public Map<String, List<Category>> getCategories(){
    Map<String, List<Category>> categories= new HashMap<>();
    categories.put("categories", categoriesService.findAll());
    return categories;
  }

  @GetMapping("/{id}")
  public Map<String, Category> getCategory(@PathVariable int id) {
    Optional<Category> category = categoriesService.optionalFindById(id);
    if(category.isEmpty()){
      throw new CategoryNotFoundException();
    }else{
      Map<String, Category> categoryMap = new HashMap<>();
      categoryMap.put("category", category.get());
      return categoryMap;
    }
  }

  @NoArgsConstructor
  private class CategoryNotFoundException extends RuntimeException {
  }

  @ControllerAdvice
  private class CategoryNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ApiV1CategoriesController.CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CategoryNotFoundHandler(ApiV1CategoriesController.CategoryNotFoundException ex) {
      return ex.getMessage();
    }
  }

}
