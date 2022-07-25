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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author vanessa
 */
public class myDonationAppointmentController {
    @FXML 
    private Button homeButton;
    
    @FXML
    private Button makeNewApptButton; 

    @FXML
    private Button deleteSlotButton;
    
    @FXML
    private Button updateApptButton;
    
    @FXML
    private Button deleteApptButton;
    
    @FXML
    private Button apptReceiptButton;
    
    @FXML
    private ChoiceBox donationTypeChoice;
    
    @FXML
    private ChoiceBox apptTimeChoice;
    
    @FXML
    private ChoiceBox donationCentreChoice;

    
    @FXML
    private DatePicker apptDatePicker;
    
    String apptDateString;
    
    //table view for the data 
    donorDatabase database = new donorDatabase();
    
    @FXML
    private TableView donationsTbl;
    
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
        
        //sets list of options
        ObservableList<String> donorTypeList = FXCollections.observableArrayList("Blood","Plasma","Platelet");
        ObservableList<String> donorCentreList = FXCollections.observableArrayList("");
        ObservableList<String> apptTimeList = FXCollections.observableArrayList("7:00AM","7:30AM","8:00AM","8:30AM","9:00AM"
                                            ,"9:30AM","10:00AM","10:30AM","11:00AM","11:30AM","12:00PM","12:30PM","1:00PM"
                                            ,"1:30PM","2:00PM","2:30PM","3:00PM","3:30PM","4:00PM","4:30PM","5:00PM"
                                            ,"5:30PM","6:00PM","6:30PM","7:00PM","7:30PM","8:00PM");
    
        //sets list of options into choice boxes
        donationTypeChoice.setItems(donorTypeList);
        donationTypeChoice.setValue("");
        
        donationCentreChoice.setItems(donorCentreList);
        donationCentreChoice.setValue("");    
        
        apptTimeChoice.setItems(apptTimeList);
        apptTimeChoice.setValue("");  
        
    }
    
    //gets value from the appt date picker
    @FXML
    public void selectApptDatePicker(ActionEvent event){
        LocalDate apptDate = apptDatePicker.getValue();
        apptDateString = apptDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    @FXML
    private void switchToMainPage() throws IOException {
        App.setRoot("MainPage");
    }
    
}
