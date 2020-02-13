/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import cnxDB.ConnexionSingleton;
import Isponsoring.Isponsoring;
import entities.Sponsoring;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import refuge.Irefuge.Irefugee;
//import refuge.entities.Refugee;

/**
 *
 * @author hasse
 */
public class SponsCrud {
     private static SponsCrud instance;
    private Statement st;
    private ResultSet rs;
          Connection  myConnex;

    public SponsCrud() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SponsCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static SponsCrud getInstance(){
        if(instance==null) 
            instance=new SponsCrud();
        return instance;
    }
    public void ajouterspons(Sponsoring spons) {
        String req="insert into sponsorings"
                + " (id,nom_assosiation,domaine,produit,quantite)"
                + " values ('"+spons.getid()+"','"+spons.getnom_assosiation()+"','"+spons.getdomaine()+"','"+spons.getproduit()+"','"+spons.getquantite()+"')";
       
        
        
        
        try {
            st.executeUpdate(req);
            System.out.println("spons bien ajouter");
        } catch (SQLException ex) {
            Logger.getLogger(SponsCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
public List<Sponsoring> displayAllList(){
        String req="select * from sponsorings";
        List<Sponsoring> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                 Sponsoring spons=new Sponsoring();
                spons.setnom_assosiation(rs.getString(2));
                spons.setdomaine(rs.getString(3));
                spons.setproduit(rs.getString(4));
                spons.setquantite(rs.getInt(5));
                
           
                list.add(spons);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SponsCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ObservableList<Sponsoring> displayAll(){
        String req="select * from sponsorings";
        ObservableList<Sponsoring> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Sponsoring spons=new Sponsoring();
                spons.setnom_assosiation(rs.getString(2));
                spons.setdomaine(rs.getString(3));
                spons.setproduit(rs.getString(4));
                spons.setquantite(rs.getInt(5));
               
                
           
                list.add(spons);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SponsCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    public void supprimerspons(String nom) {
        
          try {
              String req2 = "DELETE FROM sponsorings  WHERE  nom_assosiation='"+nom+"'";    
              
            st.executeUpdate(req2);
                        System.out.println("spons bien supprimer");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
           
         
    }
        public boolean update(Sponsoring spons) {
        String qry = "UPDATE sponsorings SET nom_assosiation = '"+spons.getnom_assosiation()+"', domaine = '"+spons.getdomaine()+"', produit = '"+spons.getproduit()+"', quantite = '"+spons.getquantite()+"'WHERE nom_assosiation = '"+spons.getnom_assosiation()+"'";
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Sponsoring.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
