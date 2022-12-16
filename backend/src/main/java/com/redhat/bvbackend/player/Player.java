package com.redhat.bvbackend.player;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.redhat.bvbackend.team.Team;


@Entity
public class Player extends PanacheEntityBase {

  @Id
  @Column(name = "player_id", nullable = false)
  public Long id;
  public String name;
  public String familyName;
  public int age;
  @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) 
  public List<Team> teams;

  @NotNull
  @Size(min = 1, max = 1, message = "Handed must be either Left or Right")
  public String handed;

}





