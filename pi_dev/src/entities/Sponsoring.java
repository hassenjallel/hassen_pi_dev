/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hasse
 */
public class Sponsoring {
    private SimpleIntegerProperty id;
    private SimpleStringProperty  nom_assosiation;
    private SimpleStringProperty  domaine;
    private SimpleStringProperty produit;
    private SimpleIntegerProperty quantite;
    
     public Sponsoring(int id, String nom_assosiation, String domaine, String produit, String quantite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public Sponsoring() {
    }
    public Sponsoring(int id, String nom_assosiation , String domaine , String produit , int quantite) {
        this.nom_assosiation=new SimpleStringProperty (nom_assosiation);
        this.domaine=new SimpleStringProperty(domaine);
        this.produit=new SimpleStringProperty(produit);
        this.quantite=new SimpleIntegerProperty(quantite);
        this.id=new SimpleIntegerProperty(id);
    }
   
    public String getnom_assosiation() {
        return nom_assosiation.get();
    }
    public int getid() {
        return id.get();
    }

    public void setnom_assosiation( String nom_assosiation) {
        this.nom_assosiation = new SimpleStringProperty(nom_assosiation);
    }
     public String getdomaine() {
        return domaine.get();
    }

    public void setdomaine( String domaine) {
        this.domaine = new SimpleStringProperty(domaine);
        
    }
     public void setid( int id) {
        this.id =new SimpleIntegerProperty(id);}
      public String getproduit() {
        return produit.get();
    }

    public void setproduit( String produit) {
        this.produit = new SimpleStringProperty(produit);
    }
         public int  getquantite() {
        return quantite.get();
    }

    public void setquantite( int quantite) {
        this.quantite = new SimpleIntegerProperty(quantite);
    }
    public SimpleStringProperty getNom_ass(){
        return nom_assosiation;}
    public SimpleStringProperty getdomaine_ass(){
        return domaine;}
    public SimpleStringProperty getproduit_ass(){
        return produit;}
    public SimpleIntegerProperty getid_ass(){
        return id;}
     public SimpleIntegerProperty getquantite_ass(){
        return quantite;}
     
      public Sponsoring(String nom){
             this.nom_assosiation = new SimpleStringProperty(nom);

     
     }
    
}
