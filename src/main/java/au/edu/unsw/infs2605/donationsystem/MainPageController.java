/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author vanessa
 */
public class MainPageController {
    @FXML 
    private Button donationApptButton;
    
    @FXML
    private Button newApptButton; 
    
    @FXML
    private Button donorDetailsButton;
    
    @FXML
    private Button logOutButton;
    
    @FXML
    private Label firstName;
    
    @FXML
    private void switchToDonorDetails() throws IOException {
        App.setRoot("AccessMyDonationDetails");
    }
    
    @FXML
    private void switchToMyDonationAppointment() throws IOException {
        App.setRoot("MyDonationAppointments");
    }
    
    @FXML
    private void switchToNewAppointment() throws IOException {
        App.setRoot("MakeANewAppointment");
    }
    
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("LoginScreen");
    }
}
