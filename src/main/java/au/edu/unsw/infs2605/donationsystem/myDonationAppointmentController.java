/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableView donationsTbl;
    
    @FXML
    private ChoiceBox donationTypeChoice;
    
    @FXML
    private ChoiceBox apptTimeChoice;
    
    @FXML
    private TextField donorCentreTextField;
    
    @FXML
    private DatePicker apptDatePicker;
    
}
