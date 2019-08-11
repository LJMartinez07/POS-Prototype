/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;

import static com.restaurant.classes.User.x;
import com.restaurant.utilities.FileActions;
import static com.restaurant.utilities.Hash.getMD5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Customer extends Person implements FileActions{
    
    private int IdCustomer;
    private String Email,
            fileName = "Files/Customer.txt";
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
          File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'Customer.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'Customer.txt'");
            }
        }
        
   
    }

    @Override
    public void writeFile() {
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
         try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getCustomers().size();
            for (int i=0;i<size;i++) {
                Customer str = this.getCustomers().get(i);
                String strDate= formatter.format(str.getDateReg());
                writer.write(str.getIdCustomer()+","+str.getEmail()+","+str.getName()+","+str.getLastName1()+","+str.getLastName2()+","+str.getGender()
                +","+str.getAdress()+","+str.getTelephone()+","+str.getPhone()+","+str.getCedula()+","+strDate);

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'Customer.txt' not found write method");
        }
    
    
    }

    @Override
    public void readFile() {
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
   
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.setIdCustomer(x.nextInt());
                this.setEmail(x.next());
                this.setName(x.next());
                this.setLastName1(x.next());
                this.setLastName2(x.next());
                this.setGender(x.next());
                this.setAdress(x.next());
                this.setTelephone(x.next());
                this.setPhone(x.next());
                this.setCedula(x.next());
                
               try {
                  
                   
                    this.setDateReg( dateformat3.parse(x.next()));
                    
                    
                } catch (ParseException e) {
                    System.out.println("Error to parse date");
                }
                
                //String userName, String password, int accesslevel, int IdEmploye, String KindOfEmploye, String Picture, double Balance, double PorcentBalance, String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula, Date DateReg
                this.getCustomers().add(new Customer(this.getIdCustomer(),this.getEmail(),  this.getName(), this.getLastName1(), this.getLastName2(), this.getGender(), this.getAdress(), this.getTelephone(), this.getPhone(), this.getCedula(), this.getDateReg()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'Employe.txt' not found read method");
        }
    
    }

    @Override
    public void validateFile() {
        
         File file = new File(this.fileName);
        if (!file.exists()) {
            Date date = new Date();
            this.createFile();
            this.getCustomers().add(new Customer(1, "LuisIdon@iid.com","Luis", "Martinez", "", "M", "santiago", "809-570-7176", "809-502-2278", "44544564", date));
            this.writeFile();
            System.out.println("Default User has been created");  
        }
    
    }
    
    public void add(int IdCustomer, String Email, String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula){
        Date date = new Date();
        this.getCustomers().add(new Customer(IdCustomer, Email, Name, LastName1, LastName2, Gender, Adress, Telephone, Phone, Cedula, date));
        writeFile();
    }
    
    public void modify(int IdCustomer, String Email, String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula){
         // Employe employe  = this.getEmployees().get(index);
        for (Customer customer : this.getCustomers()) {
              if (customer.getIdCustomer()== IdCustomer) {
                customer.setEmail(Email);
                        
                customer.setName(Name);
                customer.setLastName1(LastName1);
                customer.setLastName2(LastName2);
                customer.setGender(Gender);
                customer.setAdress(Adress);
                customer.setTelephone(Telephone);
                customer.setPhone(Phone);
                customer.setCedula(Cedula);
                
                break;  
            }
        }
        writeFile();  
        
    }
    public void delete(int index){
        this.getCustomers().remove(index);
        writeFile();
        
    }
}
