/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;

import java.util.Date;

/**
 *
 * @author Luis
 */
public class Person {
    
    
    private String Name,
            LastName1,
            LastName2,
            Gender,
            Adress,
            Telephone,
            Phone,
            Cedula;
    private Date DateReg;

    public Person(String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula, Date DateReg) {

        this.Name = Name;
        this.LastName1 = LastName1;
        this.LastName2 = LastName2;
        this.Gender = Gender;
        this.Adress = Adress;
        this.Telephone = Telephone;
        this.Phone = Phone;
        this.Cedula = Cedula;
        this.DateReg = DateReg;
    }
    public Person(){
        
    }

   
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName1() {
        return LastName1;
    }

    public void setLastName1(String LastName1) {
        this.LastName1 = LastName1;
    }

    public String getLastName2() {
        return LastName2;
    }

    public void setLastName2(String LastName2) {
        this.LastName2 = LastName2;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public Date getDateReg() {
        return DateReg;
    }

    public void setDateReg(Date DateReg) {
        this.DateReg = DateReg;
    }
    
    
    
    
}
