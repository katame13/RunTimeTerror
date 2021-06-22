package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.SiteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SitesController {
private SiteService siteService;

@Autowired
  public SitesController(SiteService siteService) {
    this.siteService = siteService;
  }

  @GetMapping
  public Map<String, List<Site>> siteMap
}
