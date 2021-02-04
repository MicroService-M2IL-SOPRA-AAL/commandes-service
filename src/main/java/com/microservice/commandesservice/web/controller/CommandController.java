package com.microservice.commandesservice.web.controller;

import com.microservice.commandesservice.dao.CommandDao;
import com.microservice.commandesservice.model.Commande;
import com.microservice.commandesservice.web.exceptions.CommandeIntrouvableException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@Api(value = "API pour les opérations CRUD sur les commandes")
public class CommandController {

    private static final Logger logger = LoggerFactory.getLogger(CommandController.class);
    @Autowired
    private CommandDao commandDao;
    @Autowired
    private HttpServletRequest requestContext;

    @ApiOperation(value = "Récupère la liste des commandes !")
    @GetMapping(value = "/Commands")
    public List<Commande> listeCommands() {
        logger.info("Début d'appel au service Commands pour la requête : " + requestContext.getHeader("req-id"));
        return commandDao.findAll();
    }

    //Récupérer un command par son Id
    @ApiOperation(value = "Récupère une commande grâce à son ID à condition que celui-ci soit en stock !")
    @GetMapping(value = "/Commandes/{id}")
    public Commande afficherUnCommand(@PathVariable int id) {
        logger.info("Début d'appel au service Commands pour la requête : " + requestContext.getHeader("req-id"));
        return commandDao.findById(id).orElseThrow(() -> new CommandeIntrouvableException("La commande avec l'id " + id + " est INTROUVABLE"));
    }

    //ajouter un command
    @ApiOperation(value = "Permet de créer un command !")
    @PostMapping(value = "/Commandes")
    public ResponseEntity<Void> ajouterCommand(@RequestBody Commande commande) {
        logger.info("Début d'appel au service Commands pour la requête : " + requestContext.getHeader("req-id"));
        Commande commandeAdded = commandDao.save(commande);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(commandeAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
