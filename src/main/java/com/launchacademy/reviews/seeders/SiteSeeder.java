package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.models.Site;
import com.launchacademy.reviews.services.CategoriesService;
import com.launchacademy.reviews.services.SiteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class SiteSeeder {

  private SiteService siteService;
  private CategoriesService categoriesService;

  @Autowired
  public SiteSeeder(SiteService siteService,
      CategoriesService categoriesService) {
    this.siteService = siteService;
    this.categoriesService = categoriesService;
  }

  public void seed() {
    List<Site> sitesList = new ArrayList<>();

    Category lgb = categoriesService.findByName("LGBTQIA+").get(0);
    Category goldenYears = categoriesService.findByName("Golden Years").get(0);
    Category parents = categoriesService.findByName("Parents").get(0);
    Category location = categoriesService.findByName("Location").get(0);
    Category general = categoriesService.findByName("General").get(0);

    Site bumble = new Site();
    bumble.setName("Bumble");
    bumble.setUrl("https://bumble.com");
    bumble.setCategory(general);
    sitesList.add(bumble);

    Site match = new Site();
    match.setName("Match");
    match.setUrl("https://www.match.com");
    match.setCategory(general);
    sitesList.add(match);

    Site okcupid = new Site();
    okcupid.setName("okcupid");
    okcupid.setUrl("https://www.okcupid.com");
    okcupid.setCategory(general);
    sitesList.add(okcupid);

    Site zoe = new Site();
    zoe.setName("Zoe");
    zoe.setUrl("https://www.zoeapp.co/");
    zoe.setCategory(lgb);
    sitesList.add(zoe);

    Site grindr = new Site();
    grindr.setName("Grindr");
    grindr.setUrl("https://www.grindr.com/");
    grindr.setCategory(lgb);
    sitesList.add(grindr);

    Site lex = new Site();
    lex.setName("Lex");
    lex.setUrl("https://thisislex.app/");
    lex.setCategory(lgb);
    sitesList.add(lex);

    Site silverSingles = new Site();
    silverSingles.setName("Silver Singles");
    silverSingles.setUrl("https://www.silversingles.com/");
    silverSingles.setCategory(goldenYears);
    sitesList.add(silverSingles);

    Site ourTime = new Site();
    ourTime.setName("Our Time");
    ourTime.setUrl("https://www.ourtime.com/");
    ourTime.setCategory(goldenYears);
    sitesList.add(ourTime);

    Site seniorMatch = new Site();
    seniorMatch.setName("Senior Match");
    seniorMatch.setUrl("https://www.seniormatch.com/");
    seniorMatch.setCategory(goldenYears);
    sitesList.add(seniorMatch);

    Site singleParentMeet = new Site();
    singleParentMeet.setName("Single Parent Meet");
    singleParentMeet.setUrl("https://www.singleparentmeet.com/");
    singleParentMeet.setCategory(parents);
    sitesList.add(singleParentMeet);

    Site eliteSingles = new Site();
    eliteSingles.setName("Elite Singles");
    eliteSingles.setUrl("https://www.elitesingles.com/");
    eliteSingles.setCategory(parents);
    sitesList.add(eliteSingles);

    Site seattleDatingApp = new Site();
    seattleDatingApp.setName("Seatlle Dating App");
    seattleDatingApp.setUrl("https://seattledatingapp.com/");
    seattleDatingApp.setCategory(location);
    sitesList.add(seattleDatingApp);

    Site massProfessionalSingles = new Site();
    massProfessionalSingles.setName("Mass Professional Singles");
    massProfessionalSingles.setUrl("https://www.massprofessionalsingles.com/");
    massProfessionalSingles.setCategory(location);
    sitesList.add(massProfessionalSingles);
  }
}
