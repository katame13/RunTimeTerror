package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="sites")
@Getter
@Setter
@NoArgsConstructor
public class Site {
  @Id
  @SequenceGenerator(name="site_generator", sequenceName = "sites_id_seq ", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "site_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name" , nullable = false)
  private String name;

  @Column(name = "url" , nullable = false)
  private String url;

  @Column(name = "img_url")
  private String imgUrl;

  @ManyToOne
  @JoinColumn(name="category_id", nullable=false)
  @JsonIgnoreProperties("sites")
  private Category category;

  @OneToMany(mappedBy = "site")
  @JsonIgnoreProperties("site")
  private List<Review> reviews;
}
