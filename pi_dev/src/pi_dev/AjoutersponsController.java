/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;

import crud.SponsCrud;
import entities.Sponsoring;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class AjoutersponsController implements Initializable {

       @FXML
    private TextField nom;

    @FXML
    private TextField domaine;

    @FXML
    private TextField produit;

    @FXML
    private TextField quantiter;

    @FXML
    private Button ajouter;

    @FXML
    void ajouter(ActionEvent event) {
 System.out.println("heyyy");

String nom_ass=nom.getText();
String dom=domaine.getText();
String prod=produit.getText();
int quant=Integer.parseInt(quantiter.getText());
System.out.println(nom_ass);
Sponsoring spons= new Sponsoring(0,nom_ass,dom,prod,quant);
SponsCrud sp=SponsCrud.getInstance();
sp.ajouterspons(spons); 
    }
     @FXML
    private Button back;

   
    @FXML
    void back(ActionEvent event) {
try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Stage stage = (Stage) back.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
