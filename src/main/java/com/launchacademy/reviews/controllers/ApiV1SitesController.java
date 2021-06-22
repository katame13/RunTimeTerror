package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.SiteService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sites")
public class ApiV1SitesController {

  private SiteService siteService;

  @Autowired
  public ApiV1SitesController(SiteService siteService) {
    this.siteService = siteService;
  }

  @GetMapping
  public Map<String, List<Site>> getSites() {
    Map<String, List<Site>> siteMap = new HashMap<>();
    siteMap.put("sites", siteService.findAll());
    return siteMap;
  }
}
