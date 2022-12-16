package com.redhat.bvbackend.leaderboard;

import com.redhat.bvbackend.team.Team;

import javax.persistence.Id;
import javax.persistence.Column;

import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Leaderboard {

  @Id
  @Column(name = "leaderboard_id", nullable = false)
  public Long id;
  public String name;
  @ManyToOne
  @JsonIgnore
  public Team teams;
    
}
