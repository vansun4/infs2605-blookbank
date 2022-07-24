/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem.database;

import au.edu.unsw.infs2605.donationsystem.data.donationsData;
import au.edu.unsw.infs2605.donationsystem.data.donorData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author vanessa
 */
public class donorDatabase {
    final private String database = "jdbc:sqlite:DonorBank.db";
    
    //set up the database
    public void setUpDatabase() throws SQLException {
        //connect to the database
        Connection conn = DriverManager.getConnection(database);
        
        //create a user table for the blood donors
        //Needs to contain id, username and password fields
        Statement st = conn.createStatement();
        String createQuery = "CREATE TABLE IF NOT EXISTS Users"
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "USERNAME TEXT NOT NULL, "
                + "PASSWORD TEXT NOT NULL "
                + ");";
        st.execute(createQuery);
        
        //insert user accounts to test 
        String insertUserAccount = "INSERT INTO Users (ID, USERNAME, PASSWORD)"
                + "VALUES (1, 'stellarush', 'starlight');";
        
        //execute statement
        st.execute(insertUserAccount);
        
        //Create Donation Table 
        //Needs to contain donation type, donor centre, date, time
        String defineQuery = "CREATE TABLE IF NOT EXISTS Donations"
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "TYPE TEXT NOT NULL, "
                + "CENTRE TEXT NOT NULL, "
                + "DATE TEXT NOT NULL, "
                + "TIME TEXT NOT NULL "
                + ");";
        
        //execute query
        st.execute(defineQuery);
        
        //insert data into Donation Table 
        insertDonationData();
        
        //close connection and statements
        st.close();
        conn.close();
    }
    
    public void insertDonationData() throws SQLException {
        //create connection
        Connection conn = DriverManager.getConnection(database);
        
        //create statement 
        Statement st = conn.createStatement();
        
        //create query to insert data for donation
        PreparedStatement pSt = conn.prepareStatement (
            "INSERT OR IGNORE INTO Donations (id, type, centre, date, time) VALUES (?,?,?,?,?)"
        );
        
        //data to be inserted
        String[] type = {"plasma", "blood", "platelets", "blood"};
        String[] centre = {"Randwick Blood", "Campsie Health", "Chatswood Plus", "Epping Health"};
        String[] date = {"12/2/2012", "31/5/2009", "23/1/2019", "20/6/2022"};
        String[] time = {"12:00PM", "04:30PM", "02:00PM", "09:00AM"};
        
        //loop the insert the data
        for (int i = 0; i < 4; i++) {
            pSt.setInt(1, i);
            pSt.setString(2, type[i]);
            pSt.setString(3, centre[i]);
            pSt.setString(4, date[i]);
            pSt.setString(5, time[i]);
            pSt.executeUpdate();
        }
        
        //close connection and statement
        st.close();
        conn.close();
    }
    
    //validate login credentials
    public boolean login(String username, String password) throws SQLException {
        //open connection
        Connection conn = DriverManager.getConnection(database);
        PreparedStatement pst = conn.prepareStatement (
            "SELECT * FROM Users WHERE USERNAME = ? AND PASSWORD = ?"
        );
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        
        //check if the user exist 
        if (rs.next()) {
            pst.close();
            conn.close();
            return true;
        } else {
            pst.close();
            conn.close();
            return false;
        }
    }
    
    //observable list for donations
    public ObservableList<donationsData> getData() throws SQLException {
        //Get ResultSet of all donation data exisitng in the databasw
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        String query = "SELECT id, type, centre, date, time FROM Donations";
        ResultSet rs = st.executeQuery(query);
        
        ObservableList<donationsData> donationList = FXCollections.observableArrayList();
        
        //add each row in resultset to donationlist 
        while(rs.next()) {
            donationList.add(new donationsData(rs.getInt("id"), rs.getString("type"), 
                rs.getString("centre"), rs.getString("date"), rs.getString("time")));
        }
        
        //close connection
        st.close();
        conn.close();
        return donationList;
    }
        
}
