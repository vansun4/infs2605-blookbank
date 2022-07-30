/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.data.donationsData;
import au.edu.unsw.infs2605.donationsystem.database.donorDatabase;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author vanessa
 */
public class myDonationAppointmentController {
    private donationsData newRec = null;
    
    //fxids
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
    
    private Label id;
    
    

    
    @FXML
    private DatePicker apptDatePicker;
    
    String apptDateString;
    
    //table view for the data 
    donorDatabase database = new donorDatabase();
    
    @FXML
    private TableView<donationsData> donation = new TableView<>();
    
    @FXML 
    TableColumn<donationsData, String> donationTypeCol;
    
    @FXML
    TableColumn<donationsData, String> donorCentreCol;
    
    @FXML
    TableColumn<donationsData, String> dateCol;
    
    @FXML
    TableColumn<donationsData, String> timeCol;
    
    @FXML
    private ListView<donationsData> data;
    
    @FXML 
    public void initialize() throws SQLException {
        //get list of the donations in the donorDatabase
        ObservableList<donationsData> Donations = database.getData();
       
        
        //set list into tableview
        donation.setItems(Donations);
        
        //set all the columns into tableview columns
        donationTypeCol.setCellValueFactory(new PropertyValueFactory<>("donationType"));
        donorCentreCol.setCellValueFactory(new PropertyValueFactory<>("donorCentre"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        //edit tableview data
        donationTypeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        //donationTypeCol.setOnEditCommit(getDonationsTbl().getItems());
        
        //observable list data
        ObservableList<String> donorTypeList = FXCollections.observableArrayList("Blood","Plasma","Platelet");
        ObservableList<String> donorCentreList = FXCollections.observableArrayList("Randwick Blood", "Campsie Health", 
                "Chatswood Plus", "Epping Health");
        ObservableList<String> apptTimeList = FXCollections.observableArrayList("9:00AM","9:30AM","10:00AM","10:30AM",
                "11:00AM","11:30AM","12:00PM","12:30PM","1:00PM","1:30PM","2:00PM","2:30PM","3:00PM","3:30PM","4:00PM",
                "4:30PM","5:00PM");
        //sets list of options into choice boxes
        donationTypeChoice.setItems(donorTypeList);
        donationTypeChoice.setValue("");
        
        donationCentreChoice.setItems(donorCentreList);
        donationCentreChoice.setValue("");    
        
        apptTimeChoice.setItems(apptTimeList);
        apptTimeChoice.setValue("");  
 
        
        
        List<donationsData> donationsRecord = App.getDonationsRecords();
        
        for(donationsData donation: donationsRecord) {
            data.getItems().add(donation);
        }
        
    }
    
    //return to the main screen 
    @FXML
    private void switchToMainPage() throws IOException {
        App.setRoot("MainPage");
    }
    
    //delete the appointment time 
    @FXML 
    private void deleteAppointment(ActionEvent event) throws IOException { 
        //deleting donor centre and associated time slots
        //https://stackoverflow.com/questions/34857007/how-to-delete-row-from-table-column-javafx
        donation.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        ObservableList<donationsData> selectedRows = donation.getSelectionModel().getSelectedItems();
        ArrayList<donationsData> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> donation.getItems().remove(row));
    }
    
    //update the appointment time 
     @FXML
     public void selectApptDatePicker(ActionEvent event){
        LocalDate apptDate = apptDatePicker.getValue();
        apptDateString = apptDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
     }
     
     @FXML 
     private void userClickedOnDonations() throws FileNotFoundException {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         
         donationsData selected = data.getSelectionModel().getSelectedItem();
         donationTypeChoice.setValue(selected.getDonationType());
         donationCentreChoice.setValue(selected.getDonorCentre());
         apptDatePicker.setValue(LocalDate.parse(selected.getDate(), formatter));
         apptTimeChoice.setValue(selected.getTime());  
     }
     
     @FXML
     private void saveUpdatedRecords(ActionEvent event) throws IOException {
         List<donationsData> updatedRecords = new ArrayList<>();
         
         List<donationsData> newRecords = new ArrayList<>();
         
         for(donationsData d: updatedRecords) {
             if(d.equals(newRec)) {
                 donationsData upData = new donationsData(id.getText(), donationTypeChoice.getValue().toString(),
                 donationCentreChoice.getValue().toString(), apptDatePicker.getValue().toString(),
                 apptTimeChoice.getValue().toString());

             }
             else {
                 newRecords.add(d);
             }
         }
         
         App.setDonationsRecords(newRecords);
         App.setRoot("MyDonationAppointments");
     }
    
    //generate appointment receipt 
    @FXML
    private void generateAppointmentReceipt() throws IOException {
        //set visible method
        
    }
    
    //make a new appointment 
    @FXML
    private void switchToMakeNewAppointments() throws IOException {
        App.setRoot("MakeANewAppointment");
    }
    
    
    
}
