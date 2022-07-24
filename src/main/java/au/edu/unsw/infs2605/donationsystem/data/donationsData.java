/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem.data;

/**
 *
 * @author vanessa
 */
public class donationsData {
    
    //attributes
    protected int id;
    protected String donationType;
    protected String donorCentre; 
    protected String date;
    protected String time;
    
    //constructor
    public donationsData(int id, String donationType, String donorCentre, String date, String time) {
        this.id = id;
        this.donationType = donationType;
        this.donorCentre = donorCentre;
        this.date = date;
        this.time = time;
    }
    
    //getters
    public int getID() {
        return id;
    }
    
    public String getDonationType() {
        return donationType;
    }
    
    public String getDonorCentre() {
        return donorCentre;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTime() {
        return time;
    }
    
    //setters
    public void setID(int id) {
        this.id = id;
    }    

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }
    
    public void setDonorCentre(String donorCentre) {
        this.donorCentre = donorCentre;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    
    
}
