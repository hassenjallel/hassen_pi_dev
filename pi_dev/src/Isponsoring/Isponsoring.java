package Isponsoring;


import entities.Sponsoring;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hasse
 * @param 
 */
public interface Isponsoring <T>{
    void ajouterspons(Sponsoring spons);
    void supp(ActionEvent event);
public ObservableList<Sponsoring> displayAll();  
public List<Sponsoring> displayAllList();}
