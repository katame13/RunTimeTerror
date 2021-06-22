package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriesSeeder {

  private CategoriesService categoriesService;

  @Autowired
  public CategoriesSeeder(CategoriesService categoriesService) {
    this.categoriesService = categoriesService;
  }

  public void seed() {
    if (categoriesService.findAll().isEmpty()) {
      Category category1 = new Category();
      Category category2 = new Category();
      Category category3 = new Category();
      Category category4 = new Category();
      category1.setName("LGBTQIA+");
      category2.setName("Golden Years");
      category3.setName("Parents");
      category4.setName("Location");
      categoriesService.save(category1);
      categoriesService.save(category2);
      categoriesService.save(category3);
      categoriesService.save(category4);
    }
  }
}
