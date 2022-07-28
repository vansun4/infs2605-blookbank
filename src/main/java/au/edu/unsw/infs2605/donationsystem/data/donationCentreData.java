/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem.data;

/**
 *
 * @author vanessa
 */
public class donationCentreData {
    
    //attributes
    private String donationCentre;
    private String donationAddress;
    private int donationPhoneNo;
    
    
    //constructors
    public donationCentreData(String donationCentre, String donationAddress, int donationPhoneNo) {
        this.donationCentre = donationCentre;
        this.donationAddress = donationAddress;
        this.donationPhoneNo = donationPhoneNo;
    }
    
    //getters
    public String getDonationCentre() {
        return donationCentre;
    }
    
    public String getDonationAddress() {
        return donationAddress;
    }
    
    public int getDonationPhoneNo() {
        return donationPhoneNo;
    }
    
    //setters 
    public void setDonationCentre(String donationCentre) {
        this.donationCentre = donationCentre;
    }
    
    public void setDonationAddress(String donationAddress) {
        this.donationAddress = donationAddress;
    }
    
    public void setDonationPhoneNo(int donationPhoneNo) {
        this.donationPhoneNo = donationPhoneNo;
    }
    
}
