/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;

import crud.SponsCrud;
import entities.Sponsoring;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class ModifiersponsController implements Initializable {

  
    @FXML
    private TextField nom_association;

    @FXML
    private TextField domaine;

    @FXML
    private TextField produit;

    @FXML
    private TextField quantite;

    @FXML
    private Button modifier;
SimpleStringProperty nom_recup= AffichersponsController.nom_recup;
SimpleStringProperty domaine_recup= AffichersponsController.domaine_recup;
SimpleStringProperty produit_recup= AffichersponsController.produit_recup;

@FXML
    void modifier(ActionEvent event) {
        
  //     nom_association=setText(selected.getnom_assosiation().get());
String nom_ass=nom_association.getText();
String dom=domaine.getText();
String prod=produit.getText();
int quant=Integer.parseInt(quantite.getText());
System.out.println(nom_recup);
Sponsoring spons= new Sponsoring(0,nom_ass,dom,prod,quant);
SponsCrud sp=SponsCrud.getInstance();
sp.update(spons); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            nom_association.setText(nom_recup.get());
domaine.setText(domaine_recup.get());
produit.setText(produit_recup.get());
    }    
    
}
