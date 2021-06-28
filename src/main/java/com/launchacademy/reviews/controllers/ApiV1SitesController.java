package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.CategoriesService;
import com.launchacademy.reviews.services.SiteService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sites")
public class ApiV1SitesController {

  private SiteService siteService;
  private CategoriesService categoriesService;

  @Autowired
  public ApiV1SitesController(SiteService siteService, CategoriesService categoriesService) {
    this.siteService = siteService;
    this.categoriesService =categoriesService;
  }

  @GetMapping
  public Map<String, List<Site>> getSites() {
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

  @PostMapping
  public ResponseEntity addSite(@RequestBody @Valid Site site, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
      List<FieldError> errorList = bindingResult.getFieldErrors();
      Map<String, String> errorFields = new HashMap<>();
      for(FieldError fieldError : errorList){
        errorFields.put(fieldError.getField(),fieldError.getDefaultMessage());
      }
      Map<String, Map<String, String>> errorMap = new HashMap<>();
      errorMap.put("errors", errorFields);
      return new ResponseEntity<Object>(errorMap, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    Category category = categoriesService.findById(site.getCategoryId());
    site.setCategory(category);
    siteService.save(site);
    Map<String, Site> savedSite = new HashMap<>();
    savedSite.put("site", site);
    return ResponseEntity.ok(savedSite);
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
