package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.services.CategoriesService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
