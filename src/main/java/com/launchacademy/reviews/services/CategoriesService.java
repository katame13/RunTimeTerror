package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.repositories.CategoriesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

  private CategoriesRepository categoriesRepository;

  @Autowired
  public CategoriesService(
      CategoriesRepository categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public void save(Category category) {
    categoriesRepository.save(category);
  }

  public List<Category> findByName(String name) {
    return (List<Category>)categoriesRepository.findByName(name);
  }

  public List<Category> findAll() {
    return (List<Category>) categoriesRepository.findAll();
  }

  public Category findById(Integer id) {
    return categoriesRepository.findById(id).get();
  }

}
