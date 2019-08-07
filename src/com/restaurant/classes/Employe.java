/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;

import static com.restaurant.classes.User.x;
import com.restaurant.utilities.FileActions;
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
public class Employe extends Person implements FileActions{
    
    private int IdEmploye;
    private String KindOfEmploye, 
            Picture, 
            fileName="Employe.txt";
    private double Balance, 
            PorcentBalance;
   
    public ArrayList<Employe> employees = new ArrayList<>();
    
    public Employe(int IdEmploye, String KindOfEmploye, String Picture, double Balance, double PorcentBalance, String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula, Date DateReg) {
        super( Name, LastName1, LastName2, Gender, Adress, Telephone, Phone, Cedula, DateReg);
        this.IdEmploye = IdEmploye;
        this.KindOfEmploye = KindOfEmploye;
        this.Picture = Picture;
        this.Balance = Balance;
        this.PorcentBalance = PorcentBalance;
    }
    
    public Employe(){
        super();
        
    }
    
    //getter and setter END

    public int getIdEmploye() {
        return IdEmploye;
    }

    public void setIdEmploye(int IdEmploye) {
        this.IdEmploye = IdEmploye;
    }

    public String getKindOfEmploye() {
        return KindOfEmploye;
    }

    public void setKindOfEmploye(String KindOfEmploye) {
        this.KindOfEmploye = KindOfEmploye;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public double getPorcentBalance() {
        return PorcentBalance;
    }

    public void setPorcentBalance(double PorcentBalance) {
        this.PorcentBalance = PorcentBalance;
    }

    public ArrayList<Employe> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employe> employees) {
        this.employees = employees;
    }

    //Getter and setter END
    

    @Override
    public void createFile() {
      File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                 file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error to create 'Employe.txt'");
            }
        }
        System.out.println("'Employe.txt' has been created successfully"); 
    }

    @Override
    public void writeFile() {
       
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
   
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getEmployees().size();
            for (int i=0;i<size;i++) {
                Employe str = this.getEmployees().get(i);
                String strDate= formatter.format(str.getDateReg()); 
                writer.write(str.getIdEmploye()+","+str.getKindOfEmploye()+","+str.getPicture() +","+str.getBalance()+","+str.getPorcentBalance()+","+str.getName()+","+str.getLastName1()+","+str.getLastName2()+","+str.getGender()
                +","+str.getAdress()+","+str.getTelephone()+","+str.getPhone()+","+str.getCedula()+","+strDate);

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'Employe.txt' not found write method");
        }
    
    }

    @Override
    public void ReadFile() {
         SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
      //  
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.setIdEmploye(x.nextInt());
                this.setKindOfEmploye(x.next());
                this.setPicture(x.next());
                this.setBalance(x.nextDouble());
                this.setPorcentBalance(x.nextDouble());
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
                this.getEmployees().add(new Employe(this.getIdEmploye(),this.getKindOfEmploye(), this.getPicture(), this.getBalance(), this.getPorcentBalance(), this.getName(), this.getLastName1(), this.getLastName2(), this.getGender(), this.getAdress(), this.getTelephone(), this.getPhone(), this.getCedula(), this.getDateReg()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'Employe.txt' not found read method");
        }
      
    }
    
    
}
