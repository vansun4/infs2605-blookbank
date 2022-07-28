/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.data.donationCentreData;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    
    //switch to main when a new donor centre
    @FXML
    private void saveDataWhenCreated (ActionEvent event) throws IOException {
        List<donationCentreData> centre = App.getDonationsCentre();
        centre.add(new donationCentreData(centreTextField.getText(), 
                centreAddressTextField.getText(), Integer.parseInt(centreNumberTextField.getText())));
        
        App.setDonationsCentre(centre);
        App.setRoot("MainPage");
    }
}
