package com.launchacademy.reviews.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

  private CategoriesSeeder categoriesSeeder;

  @Autowired
  public MainSeeder(CategoriesSeeder categoriesSeeder) {
    this.categoriesSeeder = categoriesSeeder;
  }

  public void run(String... args) throws Exception {
    categoriesSeeder.seed();
  }

}
