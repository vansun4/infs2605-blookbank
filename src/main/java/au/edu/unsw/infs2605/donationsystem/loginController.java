/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author vanessa
 */
public class loginController {
    
    @FXML 
    private TextField emailTextField;
    
    @FXML 
    private TextField passwordField;
    
    @FXML
    private Button login;

    @FXML
    private void switchToHomePage() throws IOException {
        App.setRoot("MainPage");
    }
    
}
