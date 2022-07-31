module au.edu.unsw.infs2605.donationsystem {
    requires javafx.baseEmpty;
    requires javafx.base;
    requires javafx.fxmlEmpty;
    requires javafx.fxml;
    requires javafx.controlsEmpty;
    requires javafx.controls;
    requires javafx.graphicsEmpty;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    requires java.logging;

    opens au.edu.unsw.infs2605.donationsystem to javafx.fxml;
    opens au.edu.unsw.infs2605.donationsystem.data to javafx.fxml;
    //opens au.edu.unsw.infs2605.donationsystem.data.donationCentreData to javafx.fxml;
    exports au.edu.unsw.infs2605.donationsystem;
    exports au.edu.unsw.infs2605.donationsystem.data;
    //exports au.edu.unsw.infs2605.donationsystem.data.donationCentreData;
    
}