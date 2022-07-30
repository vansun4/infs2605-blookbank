package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.data.donationCentreData;
import au.edu.unsw.infs2605.donationsystem.data.donationsData;
import au.edu.unsw.infs2605.donationsystem.database.donorDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 **/
public class App extends Application {
    
    private static Scene scene;
    
    private donorDatabase database = new donorDatabase();
    
    private static List<donationsData> donationsRecords = new ArrayList<donationsData>();
    
    private static List<donationCentreData> centreData = new ArrayList<donationCentreData>();
    
    //records
    
    
     @Override
    public void start(Stage stage) throws IOException, SQLException {
        database.setUpDatabase();
        stage.setTitle("Donation Management System");
        scene = new Scene(loadFXML("Login"), 1366, 768);
        stage.setScene(scene);
        stage.show();
        
        donationsRecords.add(new donationsData("", "plasma", "Randwick Blood","12/02/2012","12:00PM"));
        donationsRecords.add(new donationsData("", "blood", " Campsie Health","31/05/2009","04:30PM"));
        donationsRecords.add(new donationsData("", "platelets", "Chatswood Plus","23/01/2019","02:00PM"));
        donationsRecords.add(new donationsData("", "blood", "Epping Health","20/06/2022","09:00AM"));
        
        
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    //get and set donation records
    public static List<donationsData> getDonationsRecords() {
        return donationsRecords;
    }
    
    public static void setDonationsRecords(List<donationsData> donationsRecords) {
        App.donationsRecords = donationsRecords;
    }
    
    //get and set centre data
    public static List<donationCentreData> getDonationsCentre() {
        return centreData;
    }
    
    public static void setDonationsCentre(List<donationCentreData> centreData) {
        App.centreData = centreData;
    }

}