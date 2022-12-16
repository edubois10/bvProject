package com.redhat.bvbackend.team;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.inject.Inject;

@ApplicationScoped
public class TeamRepository implements PanacheRepository<Team> {

   // put your custom logic here as instance methods

   public Team findByName(String name){
       return find("name", name).firstResult();
   }

}

