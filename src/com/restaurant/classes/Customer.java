/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;

import com.restaurant.utilities.FileActions;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Luis
 */
public class Customer extends Person implements FileActions{
    
    private int IdCustomer;
    private String Email,
            FileName = "Files/Customer.txt";
    private ArrayList<Customer> customers = new ArrayList<>();

    public Customer() {
    }

    public Customer(int IdCustomer, String Email, String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula, Date DateReg) {
        super(Name, LastName1, LastName2, Gender, Adress, Telephone, Phone, Cedula, DateReg);
        this.IdCustomer = IdCustomer;
        this.Email = Email;
    }

    public int getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(int IdCustomer) {
        this.IdCustomer = IdCustomer;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void createFile() {
   
    }

    @Override
    public void writeFile() {
    
    }

    @Override
    public void readFile() {
    
    }

    @Override
    public void validateFile() {
    
    }
    
    public void add(){
        
    }
    
    public void modify(){
        
    }
    public void delete(){
        
    }
    
    

  
    
    
    
    
}
