package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.SiteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SiteSeeder {
private SiteService siteService;

@Autowired
  public SiteSeeder(SiteService siteService) {
    this.siteService = siteService;
  }

  public void seed(){
  List<Site> sitesList = new ArrayList<>();

  Site bumble = new Site();
  bumble.setName("Bumble");
  bumble.setUrl("https://bumble.com");
  //general category
  sitesList.add(bumble);

  Site match = new Site();
  match.setName("Match");
  match.setUrl("https://www.match.com");
    //general category
  sitesList.add(match);

  Site okcupid = new Site();
  okcupid.setName("okcupid");
  okcupid.setUrl("https://www.okcupid.com");
    //general category
  sitesList.add(okcupid);

  Site zoe = new Site();
  zoe.setName("Zoe");
  zoe.setUrl("https://www.zoeapp.co/");
  //lqbtq category
    sitesList.add(zoe);

    Site grindr = new Site();
    grindr.setName("Grindr");
    grindr.setUrl("https://www.grindr.com/");
    //lqbtq category
    sitesList.add(grindr);

    Site lex = new Site();
    lex.setName("Lex");
    lex.setUrl("https://thisislex.app/");
    //lqbtq category
    sitesList.add(lex);

    Site silverSingles = new Site();
    silverSingles.setName("Silver Singles");
    silverSingles.setUrl("https://www.silversingles.com/");
    //golden years category
    sitesList.add(silverSingles);

    Site ourTime = new Site();
    ourTime.setName("Our Time");
    ourTime.setUrl("https://www.ourtime.com/");
    //golden years category
    sitesList.add(ourTime);

    Site seniorMatch = new Site();
    seniorMatch.setName("Senior Match");
    seniorMatch.setUrl("https://www.seniormatch.com/");
    //golden years category
    sitesList.add(seniorMatch);

    Site singleParentMeet = new Site();
    singleParentMeet.setName("Single Parent Meet");
    singleParentMeet.setUrl("https://www.singleparentmeet.com/");
    //parents category
    sitesList.add(singleParentMeet);

    Site eliteSingles = new Site();
    eliteSingles.setName("Elite Singles");
    eliteSingles.setUrl("https://www.elitesingles.com/");
    //parents category
    sitesList.add(eliteSingles);

    Site seattleDatingApp = new Site();
    seattleDatingApp.setName("Seatlle Dating App");
    seattleDatingApp.setUrl("https://seattledatingapp.com/");
    //location based category
    sitesList.add(seattleDatingApp);

    Site massProfessionalSingles = new Site();
    massProfessionalSingles.setName("Mass Professional Singles");
    massProfessionalSingles.setUrl("https://www.massprofessionalsingles.com/");
    //location based category
    sitesList.add(massProfessionalSingles);
  }
}
