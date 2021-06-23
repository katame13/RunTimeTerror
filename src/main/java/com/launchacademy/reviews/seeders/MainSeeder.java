package com.launchacademy.reviews.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

  private CategoriesSeeder categoriesSeeder;
  private SiteSeeder siteSeeder;

  @Autowired
  public MainSeeder(CategoriesSeeder categoriesSeeder, SiteSeeder siteSeeder) {
    this.categoriesSeeder = categoriesSeeder;
    this.siteSeeder = siteSeeder;
  }

  public void run(String... args) throws Exception {
    categoriesSeeder.seed();
    siteSeeder.seed();
  }

}
