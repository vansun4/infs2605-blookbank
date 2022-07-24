/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author vanessa
 */
public class MainPageController {
    @FXML 
    private Button donationAppt;
    
    @FXML
    private Button appt; 
    
    @FXML
    private Button donorDetails;
    
    @FXML
    private Button logOut;
    
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
