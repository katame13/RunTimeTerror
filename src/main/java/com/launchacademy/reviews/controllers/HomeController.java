package com.launchacademy.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(value = {"/sites",  "/sites/new", "/sites/{id}", "/categories/{id}", "/sites/edit/{id}", "/oops"})

  public String forward() {
    return "forward:/";
  }
}

