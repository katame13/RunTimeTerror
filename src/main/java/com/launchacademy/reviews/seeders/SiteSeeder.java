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
    if (siteService.findAll().isEmpty()) {
      List<Site> sitesList = new ArrayList<>();

      Category lgb = categoriesService.findByName("LGBTQIA+").get(0);
      Category goldenYears = categoriesService.findByName("Golden Years").get(0);
      Category parents = categoriesService.findByName("Parents").get(0);
      Category location = categoriesService.findByName("Location").get(0);
      Category general = categoriesService.findByName("General").get(0);

      Site bumble = new Site();
      bumble.setName("Bumble");
      bumble.setUrl("https://bumble.com");
      bumble.setImgUrl("https://play-lh.googleusercontent.com/tH2ui3MqYnTyt7EG9S3DVNDO7SV7eRtts2phjaE-vZNBvf4meAx5_a5LZc_IbZGAFw=s360");
      bumble.setCategory(general);
      sitesList.add(bumble);

      Site match = new Site();
      match.setName("Match");
      match.setUrl("https://www.match.com");
      match.setImgUrl("https://play-lh.googleusercontent.com/Y87F43p1x3GxYQI14TiStMV1-06zRK_PoKGViEGbNie6xqb_LAFDbSj7sdidamaOXtgz=s360");
      match.setCategory(general);
      sitesList.add(match);

      Site okcupid = new Site();
      okcupid.setName("okcupid");
      okcupid.setUrl("https://www.okcupid.com");
      okcupid.setImgUrl("https://i.imgur.com/kt51xbF.png");
      okcupid.setCategory(general);
      sitesList.add(okcupid);

      Site zoe = new Site();
      zoe.setName("Zoe");
      zoe.setUrl("https://www.zoeapp.co/");
      zoe.setImgUrl("https://play-lh.googleusercontent.com/ETDDOvy0AtBPXoLFlHJ6vjt-n0m2ufKRSRV-v568ityBlA7EXfSc1uJKLAWNIRM1Z-Eb=s360");
      zoe.setCategory(lgb);
      sitesList.add(zoe);

      Site grindr = new Site();
      grindr.setName("Grindr");
      grindr.setUrl("https://www.grindr.com/");
      grindr.setImgUrl("https://play-lh.googleusercontent.com/8sTpBWyCCpQGdsrTu_NLRQLwt4zibVidrYeCcEWiVwGRHdhcnwIg_ZicU2XlD9UfxW4=s360");
      grindr.setCategory(lgb);
      sitesList.add(grindr);

      Site lex = new Site();
      lex.setName("Lex");
      lex.setUrl("https://thisislex.app/");
      lex.setImgUrl("");
      lex.setCategory(lgb);
      sitesList.add(lex);

      Site silverSingles = new Site();
      silverSingles.setName("Silver Singles");
      silverSingles.setUrl("https://www.silversingles.com/");
      silverSingles.setImgUrl("https://play-lh.googleusercontent.com/4dER1KAsexkp1RhGR6rAhtLUSBx5mydN5ExEbmBzaK9q7HJJ_AFNhZEXJLtZbxy0pGI=s360");
      silverSingles.setCategory(goldenYears);
      sitesList.add(silverSingles);

      Site ourTime = new Site();
      ourTime.setName("Our Time");
      ourTime.setUrl("https://www.ourtime.com/");
      ourTime.setImgUrl("https://i.imgur.com/zGXnLRC.jpg");
      ourTime.setCategory(goldenYears);
      sitesList.add(ourTime);

      Site seniorMatch = new Site();
      seniorMatch.setName("Senior Match");
      seniorMatch.setUrl("https://www.seniormatch.com/");
      seniorMatch.setCategory(goldenYears);
      seniorMatch.setImgUrl("https://play-lh.googleusercontent.com/dAT7fUB2lqax4I3qPu6SRTkY3_VIGbSgkqYvA926gcIY8JuKTwC3WGA4135Be5R-ysw=s360");
      sitesList.add(seniorMatch);

      Site singleParentMeet = new Site();
      singleParentMeet.setName("Single Parent Meet");
      singleParentMeet.setUrl("https://www.singleparentmeet.com/");
      singleParentMeet.setImgUrl("https://play-lh.googleusercontent.com/-dFdfe8V101P_SAwMLUsmiGIsEsjqev_u_djrzr5YvvXYVBxFPglpajnLqlwAC2R8V21=s360");
      singleParentMeet.setCategory(parents);
      sitesList.add(singleParentMeet);

      Site eliteSingles = new Site();
      eliteSingles.setName("Elite Singles");
      eliteSingles.setUrl("https://www.elitesingles.com/");
      eliteSingles.setImgUrl("https://play-lh.googleusercontent.com/3g0u5RbrxwdSrQVdoH2e2MRRx_1Mce5ag2ZcNamVy-WCxH9_EFt-oufhE_Z_MELcQJ66=s360");
      eliteSingles.setCategory(parents);
      sitesList.add(eliteSingles);

      Site seattleDatingApp = new Site();
      seattleDatingApp.setName("Seatlle Dating App");
      seattleDatingApp.setUrl("https://seattledatingapp.com/");
      seattleDatingApp.setImgUrl("https://play-lh.googleusercontent.com/bsMD-m0V3_A9YnJYd-BBnWNUxQKghKFXRGkZ-G2Y3Y1XxT36pkmIoHq5sgZddwfE4Ms=s360");
      seattleDatingApp.setCategory(location);
      sitesList.add(seattleDatingApp);

      Site massProfessionalSingles = new Site();
      massProfessionalSingles.setName("Mass Professional Singles");
      massProfessionalSingles.setUrl("https://www.massprofessionalsingles.com/");
      massProfessionalSingles.setImgUrl("https://www.massprofessionalsingles.com/images/tie171x174.png");
      massProfessionalSingles.setCategory(location);
      sitesList.add(massProfessionalSingles);

      for (Site site : sitesList) {
        siteService.save(site);
      }
    }
  }
}
