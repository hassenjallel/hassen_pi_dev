/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;
import javafx.collections.transformation.FilteredList;

import crud.SponsCrud;
import pi_dev.ListData;
import entities.Sponsoring;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.table.DefaultTableModel;
/**
 * FXML Controller class
 *
 * @author hasse
 */
public class AffichersponsController implements Initializable {

    @FXML
    private TextField filterField;
     @FXML
    private TableView<Sponsoring> table; 
     @FXML
    private TableColumn<Sponsoring,String> nom;

    @FXML
    private TableColumn<Sponsoring,String> domaine;

    @FXML
    private TableColumn<Sponsoring,String> produit;
   
    
    @FXML
    private Label var_ss;

               private final ListData listdata = new ListData();

        private final ObservableList<Sponsoring> dataList = FXCollections.observableArrayList();
public static SimpleStringProperty nom_recup;
public static SimpleStringProperty domaine_recup;
public static SimpleStringProperty produit_recup;

public static String mm="";

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         table.setItems(listdata.getUsers());
       nom.setCellValueFactory(cell -> cell.
                getValue().getNom_ass());
       domaine.setCellValueFactory(cell -> cell.
                getValue().getdomaine_ass());
      produit.setCellValueFactory(cell -> cell.
                getValue().getproduit_ass());
    produit.setCellValueFactory(cell -> cell.
                getValue().getproduit_ass());
    
      dataList.addAll(listdata.getUsers());
 FilteredList<Sponsoring> filteredData = new FilteredList<>(dataList, b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Spons -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Spons.getnom_assosiation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Spons.getdomaine().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(Spons.getproduit()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Sponsoring> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
table.setItems(sortedData);
    }    
     @FXML
    private Button supprimer;

    @FXML
    void supprimer(ActionEvent event) {
   Sponsoring spons = table.getSelectionModel().getSelectedItem();
SponsCrud udao = SponsCrud.getInstance();
            udao.supprimerspons(spons.getnom_assosiation());
            table.refresh();
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
    
    @FXML
    private Button modifier;
      @FXML
    void modifier(ActionEvent event) {
        
 Sponsoring ref = table.getSelectionModel().getSelectedItem();
 //String s= var_ss.getText();
 AffichersponsController.nom_recup=ref.getNom_ass();
  AffichersponsController.domaine_recup=ref.getdomaine_ass();
  AffichersponsController.produit_recup=ref.getproduit_ass();

         try {
            Parent root = FXMLLoader.load(getClass().getResource("modifierspons.fxml"));
            Stage stage = (Stage) modifier.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
