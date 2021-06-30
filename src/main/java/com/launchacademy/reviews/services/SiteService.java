package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.repositories.ReviewRepository;
import com.launchacademy.reviews.repositories.SiteRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {
private SiteRepo siteRepo;
private ReviewRepository reviewRepository;

@Autowired
  public SiteService(SiteRepo siteRepo, ReviewRepository reviewRepository)  {
    this.siteRepo = siteRepo;
    this.reviewRepository = reviewRepository;
  }
  public List<Site> findAll(){
  return (List<Site>) siteRepo.findAll();
  }

  public Site findById(Integer id){
  return siteRepo.findById(id).get();
  }

  public Optional<Site> optionalFindById(Integer id){return siteRepo.findById(id);}

  public Site save(Site site) {
    return siteRepo.save(site);
  }

  public void delete(int id) {
    Site site = siteRepo.findById(id).get();
    siteRepo.delete(site);
  }
}
