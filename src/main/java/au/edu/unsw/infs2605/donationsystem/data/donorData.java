/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem.data;

/**
 *
 * @author vanessa
 */
public class donorData {
     //attributes
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String emailAddress;
    private int mobileNumber;
    private String address;
    private String bloodType;
    private String gender;
    private String notes;
    
    //constructors
    public donorData(String firstName, String lastName, String dateOfBirth, String emailAddress,
            int mobileNumber, String address, String bloodType, String gender, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.bloodType = bloodType;
        this.gender = gender;
        this.notes = notes;
    }
    
    //getters
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getEmail() {
        return emailAddress;
    }
    
    public int getMobileNumber() {
        return mobileNumber;
    }
    
    public String getBloodType() {
        return bloodType;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getNotes() {
        return notes;
    }
    
    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void setEmailAddress(String emailAdress) {
        this.emailAddress = emailAddress;
    }
    
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public void setbloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setNotes(String Notes) {
        this.firstName = firstName;
    }
      
}
