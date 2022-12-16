package com.redhat.bvbackend.team;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


import com.redhat.bvbackend.player.Player;


@Entity
public class Team extends PanacheEntityBase {

  @Id
  @Column(name = "team_id", nullable = false)
  public Long id;
  public String name;
  public int points;
  @ManyToOne
  @JsonIgnore
  public Player players;

}






