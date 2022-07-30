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
    //fxids
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

    //switch screen to access the list of donation appointments made
    @FXML
    private void switchToMyDonationAppointment() throws IOException {
        App.setRoot("MyDonationAppointments");
    }
    
    //switch screen to create a new appointment
    @FXML
    private void switchToNewAppointment() throws IOException {
        App.setRoot("MakeANewAppointment");
    }
    
    //switch screen to logout
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("Login");
    }
}
