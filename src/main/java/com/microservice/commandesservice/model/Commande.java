package com.microservice.commandesservice.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commande {
    @Id
//    @GeneratedValue
    private int id;
    private int idProduit;
    private int prix;
    private int quantiteProduit;
    private Date dateCommande;

    public Commande(int id, int idProduit, int prix, int quantiteProduit, Date dateCommande) {
        this.id = id;
        this.idProduit = idProduit;
        this.prix = prix;
        this.quantiteProduit = quantiteProduit;
        this.dateCommande = dateCommande;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", idProduit=" + idProduit +
                ", prix=" + prix +
                ", quantiteProduit=" + quantiteProduit +
                ", dateCommande=" + dateCommande +
                '}';
    }
}
