/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.data.donationCentreData;
import au.edu.unsw.infs2605.donationsystem.data.donationsData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author vanessa
 */
public class registerNewDonorCentreController {
    @FXML
    private Button backButton;
    
    @FXML
    private Button clearInputButton;
    
    @FXML
    private Button registerCentreButton;
    
    @FXML
    private TextField centreTextField;
    
    @FXML
    private TextField centreAddressTextField;
    
    @FXML
    private TextField centreNumberTextField;
    
    @FXML 
    private ImageView image1;
    
    @FXML
    private ImageView image2;
    
    //switch to main when a new donor centre
    //https://stackoverflow.com/questions/36358044/convert-the-content-of-javafx-textfield-into-integer
    @FXML
    private void saveDataWhenCreated (ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Unconfirmed Appointment Slot");
        alert.setContentText("Are the details correct for your appointment?");
        
        Optional<ButtonType> results = alert.showAndWait();
        if(results.isPresent() && results.get() == ButtonType.OK) {
            List<donationCentreData> centre = App.getDonationsCentre();
            centre.add(new donationCentreData(centreTextField.getText(), 
                    centreAddressTextField.getText(), Integer.parseInt(centreNumberTextField.getText())));

            App.setDonationsCentre(centre);
            App.setRoot("MyDonationAppointments");
        }
        
    }
}
