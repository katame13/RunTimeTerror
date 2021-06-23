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
      bumble.setDescription("Bumble was first founded to challenge the antiquated rules of dating. Now, Bumble empowers users to connect with confidence whether dating, networking, or meeting friends online. We’ve made it not only necessary but acceptable for women to make the first move, shaking up outdated gender norms. We prioritise kindness and respect, providing a safe online community for users to build new relationships.");
      bumble.setCategory(general);
      sitesList.add(bumble);

      Site match = new Site();
      match.setName("Match");
      match.setUrl("https://www.match.com");
      match.setImgUrl("https://play-lh.googleusercontent.com/Y87F43p1x3GxYQI14TiStMV1-06zRK_PoKGViEGbNie6xqb_LAFDbSj7sdidamaOXtgz=s360");
      match.setDescription("Match is an online dating service with web sites serving over 50 countries in twelve languages. Its headquarters are in Dallas, Texas. The company has offices in Dallas, West Hollywood, San Francisco, Tokyo, Rio de Janeiro, and Beijing. Match is owned by Match Group, which owns several online dating services");
      match.setCategory(general);
      sitesList.add(match);

      Site okcupid = new Site();
      okcupid.setName("okcupid");
      okcupid.setUrl("https://www.okcupid.com");
      okcupid.setImgUrl("https://i.imgur.com/kt51xbF.png");
      okcupid.setDescription("OkCupid is a U.S.-based, internationally operating online dating, friendship, and formerly also a social networking website and application. It features multiple-choice questions to match members. Registration is free.");
      okcupid.setCategory(general);
      sitesList.add(okcupid);

      Site zoe = new Site();
      zoe.setName("Zoe");
      zoe.setUrl("https://www.zoeapp.co/");
      zoe.setImgUrl("https://play-lh.googleusercontent.com/ETDDOvy0AtBPXoLFlHJ6vjt-n0m2ufKRSRV-v568ityBlA7EXfSc1uJKLAWNIRM1Z-Eb=s360");
      zoe.setCategory(lgb);
      zoe.setDescription("Meet local woman on the best rated lesbian dating app worldwide. Feel safe with verified profiles. See who likes you and like them back. Support available 365 days / year. Swipe and chat for FREE.");
      sitesList.add(zoe);

      Site grindr = new Site();
      grindr.setName("Grindr");
      grindr.setUrl("https://www.grindr.com/");
      grindr.setImgUrl("https://play-lh.googleusercontent.com/8sTpBWyCCpQGdsrTu_NLRQLwt4zibVidrYeCcEWiVwGRHdhcnwIg_ZicU2XlD9UfxW4=s360");
      grindr.setCategory(lgb);
      grindr.setDescription("Grindr is a location-based social networking and online dating application for gay, bi, trans, and queer people. It was one of the first geosocial apps for gay men when it launched in March 2009 and has since become the largest and most popular gay mobile app in the world.");
      sitesList.add(grindr);

      Site lex = new Site();
      lex.setName("Lex");
      lex.setUrl("https://thisislex.app/");
      lex.setImgUrl("");
      lex.setCategory(lgb);
      lex.setDescription("Lex is the text-centered social app that connects queer lovers and friends. Short for lexicon. Text first, selfies second.");
      sitesList.add(lex);

      Site silverSingles = new Site();
      silverSingles.setName("Silver Singles");
      silverSingles.setUrl("https://www.silversingles.com/");
      silverSingles.setImgUrl("https://play-lh.googleusercontent.com/4dER1KAsexkp1RhGR6rAhtLUSBx5mydN5ExEbmBzaK9q7HJJ_AFNhZEXJLtZbxy0pGI=s360");
      silverSingles.setCategory(goldenYears);
      silverSingles.setDescription("SilverSingles is an online dating site designed to help 50+ singles look for a serious relationship. Our intelligent matchmaking delivers compatible partner suggestions in line with your personal search preferences. We carry out daily profile checks to ensure users have a smooth, safe, and enjoyable environment in which to meet other like-minded singles.");
      sitesList.add(silverSingles);

      Site ourTime = new Site();
      ourTime.setName("Our Time");
      ourTime.setUrl("https://www.ourtime.com/");
      ourTime.setImgUrl("https://i.imgur.com/zGXnLRC.jpg");
      ourTime.setCategory(goldenYears);
      ourTime.setDescription("At OurTime.com, we honor the freedom, wisdom and appreciation for life that only comes with time. We also recognize that what people want in their 50s, 60s and beyond is often very different from what they wanted in their 30s and 40s, let alone their 20s. This online dating community focuses on the specific interests and desires of people like you.");
      sitesList.add(ourTime);

      Site seniorMatch = new Site();
      seniorMatch.setName("Senior Match");
      seniorMatch.setUrl("https://www.seniormatch.com/");
      seniorMatch.setCategory(goldenYears);
      seniorMatch.setImgUrl("https://play-lh.googleusercontent.com/dAT7fUB2lqax4I3qPu6SRTkY3_VIGbSgkqYvA926gcIY8JuKTwC3WGA4135Be5R-ysw=s360");
      seniorMatch.setDescription("SeniorMatch focuses on users over 50 years of age and does not allow members under the age of 40. By doing so, we maintain a consistent age range dedicated specifically to mature members interested in meeting others online.\n");
      sitesList.add(seniorMatch);

      Site singleParentMeet = new Site();
      singleParentMeet.setName("Single Parent Meet");
      singleParentMeet.setUrl("https://www.singleparentmeet.com/");
      singleParentMeet.setImgUrl("https://play-lh.googleusercontent.com/-dFdfe8V101P_SAwMLUsmiGIsEsjqev_u_djrzr5YvvXYVBxFPglpajnLqlwAC2R8V21=s360");
      singleParentMeet.setCategory(parents);
      singleParentMeet.setDescription("Where single parents meet.");
      sitesList.add(singleParentMeet);

      Site eliteSingles = new Site();
      eliteSingles.setName("Elite Singles");
      eliteSingles.setUrl("https://www.elitesingles.com/");
      eliteSingles.setImgUrl("https://play-lh.googleusercontent.com/3g0u5RbrxwdSrQVdoH2e2MRRx_1Mce5ag2ZcNamVy-WCxH9_EFt-oufhE_Z_MELcQJ66=s360");
      eliteSingles.setCategory(parents);
      eliteSingles.setDescription("Meet compatible singles looking for a serious relationship in your area today! 1,000's of Local Singles, Get Personalised Matches in Your Area. Serious Online Dating.");
      sitesList.add(eliteSingles);

      Site seattleDatingApp = new Site();
      seattleDatingApp.setName("Seatlle Dating App");
      seattleDatingApp.setUrl("https://seattledatingapp.com/");
      seattleDatingApp.setImgUrl("https://play-lh.googleusercontent.com/bsMD-m0V3_A9YnJYd-BBnWNUxQKghKFXRGkZ-G2Y3Y1XxT36pkmIoHq5sgZddwfE4Ms=s360");
      seattleDatingApp.setCategory(location);
      seattleDatingApp.setDescription("Made just for the Seattle area… Busy schedules and traffic can take a toll on your dating life. We created the Seattle Dating App because we know the Seattle area deserves better");
      sitesList.add(seattleDatingApp);

      Site massProfessionalSingles = new Site();
      massProfessionalSingles.setName("Mass Professional Singles");
      massProfessionalSingles.setUrl("https://www.massprofessionalsingles.com/");
      massProfessionalSingles.setImgUrl("https://www.massprofessionalsingles.com/images/tie171x174.png");
      massProfessionalSingles.setCategory(location);
      massProfessionalSingles.setDescription("Meet compatible singles looking for a serious relationship in your area today! 1,000's of Local Singles, Get Personalised Matches in Your Area. Serious Online Dating.");
      sitesList.add(massProfessionalSingles);

      for (Site site : sitesList) {
        siteService.save(site);
      }
    }
  }
}
