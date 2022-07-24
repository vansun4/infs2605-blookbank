/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;


import au.edu.unsw.infs2605.donationsystem.data.donationsData;
import au.edu.unsw.infs2605.donationsystem.database.donorDatabase;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author vanessa
 */
public class makeAppointmentController {
    donorDatabase database = new donorDatabase();
    
    @FXML
    TableView<donationsData> donationsTbl;
    
    @FXML 
    TableColumn<donationsData, String> donationTypeCol;
    
    @FXML
    TableColumn<donationsData, String> donorCentreCol;
    
    @FXML
    TableColumn<donationsData, String> dateCol;
    
    @FXML
    TableColumn<donationsData, String> timeCol;
    
    @FXML 
    public void initialize() throws SQLException {
        //get list of the donations in the donorDatabase
        ObservableList<donationsData> donations = database.getData();
        
        //set list into tableview
        donationsTbl.setItems(donations);
        
        //set all the columns into tableview columns
        donationTypeCol.setCellValueFactory(new PropertyValueFactory<>("donationType"));
        donorCentreCol.setCellValueFactory(new PropertyValueFactory<>("donorCentre"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
    }
        
    
    
    
}
