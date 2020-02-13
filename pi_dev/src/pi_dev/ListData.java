/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;

import entities.Sponsoring;
import crud.SponsCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Houssem
 */
public class ListData {
    
     
    private ObservableList<Sponsoring> users=FXCollections.observableArrayList();

    public ListData() {
        
        SponsCrud udao=SponsCrud.getInstance();
        users= udao.displayAll();
        
    }
    
    public ObservableList<Sponsoring> getUsers(){
        return users;
    }
    
}
