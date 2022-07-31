/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.database.donorDatabase;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author vanessa
 */
public class loginController {
    //access the database
    donorDatabase database = new donorDatabase();
    
    //fxids
    @FXML 
    private TextField emailTextField;
    
    @FXML 
    private PasswordField passwordField;
    
    @FXML
    private Label errorMessage;
    
    @FXML
    private Button loginButton;
    
   
    //method to login into the program
    @FXML
    private void handleLoginButtonFunction(ActionEvent event) throws IOException, SQLException {
        System.out.println("attempted login");
        
        boolean validateLogin = database.login(emailTextField.getText(), passwordField.getText());
        if (validateLogin) {
            switchToHomePage();
        } else {
            errorMessage.setText("Incorrect username or password");
            errorMessage.setVisible(true);
        }
    }
    
    @FXML
    private void switchToHomePage() throws IOException {
        App.setRoot("MyDonationAppointments");
    }
    
}
