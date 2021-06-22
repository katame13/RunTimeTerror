package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Integer> {
  List<Category> findByName(String name);
}
