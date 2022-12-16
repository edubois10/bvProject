package com.redhat.bvbackend.player;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.inject.Inject;

@ApplicationScoped
public class PlayerRepository implements PanacheRepository<Player> {

   // put your custom logic here as instance methods

   public Player findByName(String name){
       return find("name", name).firstResult();
   }
   public List<Player> findOrdered() {
    return find("ORDER BY name").list();
}

}
