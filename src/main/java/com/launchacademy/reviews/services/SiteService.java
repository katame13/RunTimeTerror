package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.repositories.SiteRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {
private SiteRepo siteRepo;

@Autowired
  public SiteService(SiteRepo siteRepo) {
    this.siteRepo = siteRepo;
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
}
