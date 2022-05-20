package com.interview.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.rest.core.annotation.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
        /*extends JPARepository<Character, Long> {

  List<Character> findByName(@Param("name") String name);

}*/