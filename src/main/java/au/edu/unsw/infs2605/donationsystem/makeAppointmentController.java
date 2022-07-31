/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.data.donationCentreData;
import au.edu.unsw.infs2605.donationsystem.data.donationsData;
import au.edu.unsw.infs2605.donationsystem.database.donorDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
import javafx.scene.image.ImageView;

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
    private ImageView image1;
    
    @FXML 
    private ImageView image2;
    
    //table view for the data 
    donorDatabase database = new donorDatabase();
    
    @FXML
    private TableView<donationCentreData> cenData = new TableView<>();
    
    @FXML 
    TableColumn<donationCentreData, String> centreCol;
    
    @FXML
    TableColumn<donationCentreData, String> addressCol;
    
    @FXML
    TableColumn<donationCentreData, Integer> phoneCol;
    
    @FXML
    private DatePicker apptDatePicker;
    String apptDateString;
    
    @FXML
     public void selectApptDatePicker(ActionEvent event){
        LocalDate apptDate = apptDatePicker.getValue();
        apptDateString = apptDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
     }
    
    @FXML 
    public void initialize() throws SQLException {
        //get list of the donations in the donorDatabase
        ObservableList<donationCentreData> cen = database.getCentreData();
       
        
        //set list into tableview
        cenData.setItems(cen);
        
        //set all the columns into tableview columns
        centreCol.setCellValueFactory(new PropertyValueFactory<>("donationCentre"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("donationAddress"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("donationPhoneNo"));
  
        
        
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
    List<donationsData> don = App.getDonationsRecords();
    
    
    @FXML
    private void confirmBooking() throws IOException {
        don.add(new donationsData(donationTypeChoice.getValue().toString(),
                donationCentreChoice.getValue().toString(),apptDatePicker.getValue().toString(),
                apptTimeChoice.getValue().toString()));
        
        App.setDonationsRecords(don);
        App.setRoot("MyDonationAppointments");
    }
    
    //switch scene back to the main page
    @FXML
    private void switchToMainPage() throws IOException {
        App.setRoot("MyDonationAppointments");
    }
    
    //
    @FXML
    private void switchToNewDonorCentre() throws IOException {
        App.setRoot("RegisterANewDonorCentre");
    }
    
}
