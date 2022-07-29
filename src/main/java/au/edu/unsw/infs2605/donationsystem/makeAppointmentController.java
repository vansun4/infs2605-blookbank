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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author vanessa
 */
public class makeAppointmentController {
    //fxids
    @FXML 
    private Button homeButton;
    
    @FXML
    private Button newDonorCentreButton; 

    @FXML
    private Button clearInputButton;
    
    @FXML
    private Button confirmBookingButton;
    
    @FXML
    private ChoiceBox donationTypeChoice;
    
    @FXML
    private ChoiceBox donationCentreChoice;
    
    @FXML
    private ChoiceBox apptTimeChoice;
    
    @FXML
    private DatePicker apptDatePicker;
    
    @FXML 
    public void initialize() throws SQLException {
        //sets list of options
        ObservableList<String> donorTypeList = FXCollections.observableArrayList("Blood","Plasma","Platelet");
        ObservableList<String> donorCentreList = FXCollections.observableArrayList("Randwick Blood", "Campsie Health", 
                "Chatswood Plus", "Epping Health");
        ObservableList<String> apptTimeList = FXCollections.observableArrayList("9:00AM","9:30AM","10:00AM","10:30AM", "11:00AM",
                "11:30AM","12:00PM","12:30PM","1:00PM","1:30PM","2:00PM","2:30PM","3:00PM","3:30PM","4:00PM", "4:30PM", "5:00PM");
    
        //sets list of options into choice boxes
        donationTypeChoice.setItems(donorTypeList);
        donationTypeChoice.setValue("");
        
        donationCentreChoice.setItems(donorCentreList);
        donationCentreChoice.setValue("");    
        
        apptTimeChoice.setItems(apptTimeList);
        apptTimeChoice.setValue("");
    }
    
    //once apppointment is confirmed, switch to the home page 
    @FXML
    private void confirmBooking() throws IOException {
        App.setRoot("MainPage");
    }
    
    //switch scene back to the main page
    @FXML
    private void switchToMainPage() throws IOException {
        App.setRoot("MainPage");
    }
    
    //
    @FXML
    private void switchToNewDonorCentre() throws IOException {
        App.setRoot("RegisterANewDonorCentre");
    }
    
}
