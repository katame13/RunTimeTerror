package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.SiteService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    System.out.println("Inside getSites");
    Map<String, List<Site>> siteMap = new HashMap<>();
    siteMap.put("sites", siteService.findAll());
    return siteMap;
  }

  @GetMapping("/{id}")
  public Map<String, Site> getSite(@PathVariable int id){
    Optional<Site> site = siteService.optionalFindById(id);
    if(site.isEmpty()){
      throw new SiteNotFoundException();
    }
    Map<String, Site> siteMap = new HashMap<>();
    siteMap.put("site", site.get());
    return siteMap;
  }

  @NoArgsConstructor
  private class SiteNotFoundException extends RuntimeException {

  }

  @ControllerAdvice
  private class SiteNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ApiV1SitesController.SiteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String SiteNotFoundHandler(ApiV1SitesController.SiteNotFoundException ex) {
      return ex.getMessage();
    }
  }

}
