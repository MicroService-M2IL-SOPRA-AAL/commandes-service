package com.microservice.commandesservice.dao;

import com.microservice.commandesservice.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandDao extends JpaRepository<Commande, Integer> {

    List<Commande> findAllByOrderByNom();

}
