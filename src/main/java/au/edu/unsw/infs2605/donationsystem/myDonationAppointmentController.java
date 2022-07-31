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
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;

/**
 *
 * @author vanessa
 */
public class myDonationAppointmentController {    
    //fxids
    @FXML
    private Button makeNewApptButton; 
    
    @FXML
    private Button updateApptButton;
    
    @FXML
    private Button deleteApptButton;
    
    @FXML
    private Button apptReceiptButton;
    
    @FXML 
    private Button Logout;
    
    @FXML 
    private TextField donationTypeText;
    
    @FXML 
    private TextField centreText;
    
    @FXML 
    private TextField dateText;
    
    @FXML 
    private TextField timeText;
    
    @FXML
    private ImageView image1;
    
    @FXML 
    private ImageView image2;
    
    @FXML 
    private TitledPane filterPane;
    
    @FXML
    private Button addData;


    
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
    
//    @FXML
//    private ListView<donationsData> data;
    
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
        //https://www.youtube.com/watch?v=M_kp20qrtLw
        donation.setEditable(true);
        donationTypeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        donorCentreCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        timeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //save data when it has been edited
        donationTypeCol.setOnEditCommit(new EventHandler<CellEditEvent<donationsData, String>>() {
            @Override
            public void handle(CellEditEvent<donationsData, String> event) {
                donationsData donate = event.getRowValue();
                donate.setDonationType(event.getNewValue());
            }
        });
        
        donorCentreCol.setOnEditCommit(new EventHandler<CellEditEvent<donationsData, String>>() {
            @Override
            public void handle(CellEditEvent<donationsData, String> event) {
                donationsData donate = event.getRowValue();
                donate.setDonorCentre(event.getNewValue());
            }
        });
        
        timeCol.setOnEditCommit(new EventHandler<CellEditEvent<donationsData, String>>() {
            @Override
            public void handle(CellEditEvent<donationsData, String> event) {
                donationsData donate = event.getRowValue();
                donate.setTime(event.getNewValue());
            }
        });
        
        dateCol.setOnEditCommit(new EventHandler<CellEditEvent<donationsData, String>>() {
            @Override
            public void handle(CellEditEvent<donationsData, String> event) {
                donationsData donate = event.getRowValue();
                donate.setDate(event.getNewValue());
            }
        });

    }
    
     
    
    
    
    //adding data to the tableview
    //https://www.youtube.com/watch?v=Ijr4VPJzSDg
    @FXML
    public void addButtonAction(ActionEvent event) throws IOException {
        donationsData donationAddition = new donationsData(donationTypeText.getText(), centreText.getText(),
                dateText.getText(), timeText.getText());
                add(donationAddition);
    }
    
    public void add(donationsData donationAddition) {
        donation.getItems().add(donationAddition);
        clearTextFieldData();
    }
    
    private void clearTextFieldData() {
        donationTypeText.clear();
        centreText.clear();
        dateText.clear();
        timeText.clear();
        donationTypeText.requestFocus();
    }
  
    //delete the appointment time 
    @FXML 
    private void deleteAppointment(ActionEvent event) throws IOException { 
        //deleting donor centre and associated time slots
        //https://stackoverflow.com/questions/34857007/how-to-delete-row-from-table-column-javafx
        
        //alert pop up
        //https://www.youtube.com/watch?v=KzxE3ZcSIvQ
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Deletion of Appointment Slot");
        alert.setContentText("You are about to delete your appointment slot. Confirm?");
        
        Optional<ButtonType> results = alert.showAndWait();
        if(results.isPresent() && results.get() == ButtonType.OK) {
            donation.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
            ObservableList<donationsData> selectedRows = donation.getSelectionModel().getSelectedItems();
            ArrayList<donationsData> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> donation.getItems().remove(row));
        }
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
    
    //switch screen to logout
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("Login");
    }
    
    

    
}
