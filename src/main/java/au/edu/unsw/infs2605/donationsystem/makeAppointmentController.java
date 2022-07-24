/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.data.donationsData;
import au.edu.unsw.infs2605.donationsystem.database.donorDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author vanessa
 */
public class makeAppointmentController {
    @FXML 
    private Button newDonorCentre;
    
    @FXML 
    private Button mainPage;
    
    @FXML
    private Button clearInput;
    
    @FXML
    private Button confirmBooking;
    
    @FXML
    private ChoiceBox donationTypeChoice;
    
    @FXML
    private ChoiceBox donationCentreChoice;
    
    @FXML
    private ChoiceBox apptTimeChoice;
    
    @FXML
    private DatePicker apptDatePicker;
    
    String apptDateString;
    
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
        donationTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        donorCentreCol.setCellValueFactory(new PropertyValueFactory<>("centre"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
   
    }
    
    //gets value from the appt date picker
    @FXML
    public void selectApptDatePicker(ActionEvent event){
        LocalDate apptDate = apptDatePicker.getValue();
        apptDateString = apptDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    @FXML
    private void switchToNewDonorCentre() throws IOException {
        App.setRoot("RegisterANewDonorCentre");
    }
    
    @FXML
    private void switchToMainPage() throws IOException {
        App.setRoot("MainPage");
    }
    
}
