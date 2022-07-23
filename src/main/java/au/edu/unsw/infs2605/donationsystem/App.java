package au.edu.unsw.infs2605.donationsystem;

import au.edu.unsw.infs2605.donationsystem.database.donorDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;

import java.io.IOException;

/**
 * JavaFX App
 **/
public class App extends Application {
    
    private static Scene scene;
    private donorDatabase database = new donorDatabase();
    
     @Override
    public void start(Stage stage) throws IOException, SQLException {
        database.setUpDatabase();
        stage.setTitle("Donation Management System");
        scene = new Scene(loadFXML("LoginScreen"), 640, 480);
        stage.setScene(scene);
        stage.show();
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

}