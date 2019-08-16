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
public class Reservation implements FileActions{
   private int IdReservation, IdCustomer, IdTable;
   private Date DateReservation, DropReservation;
   private boolean state;
   private String CurrentHour, fileName="Files/Reservation.txt";
   private ArrayList<Reservation> Reservations = new ArrayList<>();

    public Reservation(int IdReservation, int IdCustomer, int IdTable, Date DateReservation, Date DropReservation, boolean state, String CurrentHour) {
        this.IdReservation = IdReservation;
        this.IdCustomer = IdCustomer;
        this.IdTable = IdTable;
        this.DateReservation = DateReservation;
        this.DropReservation = DropReservation;
        this.state = state;
        this.CurrentHour = CurrentHour;
    }

    public int getIdReservation() {
        return IdReservation;
    }

    public void setIdReservation(int IdReservation) {
        this.IdReservation = IdReservation;
    }

    public int getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(int IdCustomer) {
        this.IdCustomer = IdCustomer;
    }

    public int getIdTable() {
        return IdTable;
    }

    public void setIdTable(int IdTable) {
        this.IdTable = IdTable;
    }

    public Date getDateReservation() {
        return DateReservation;
    }

    public void setDateReservation(Date DateReservation) {
        this.DateReservation = DateReservation;
    }

    public Date getDropReservation() {
        return DropReservation;
    }

    public void setDropReservation(Date DropReservation) {
        this.DropReservation = DropReservation;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCurrentHour() {
        return CurrentHour;
    }

    public void setCurrentHour(String CurrentHour) {
        this.CurrentHour = CurrentHour;
    }

    public ArrayList<Reservation> getReservations() {
        return Reservations;
    }

    public void setReservations(ArrayList<Reservation> Reservations) {
        this.Reservations = Reservations;
    }

    
    
    

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'Reservation.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'Reservation.txt'");
            }
        }
       
    
    }

    @Override
    public void writeFile() {
    
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
   
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getReservations().size();
            for (int i=0;i<size;i++) {
                Reservation str = this.getReservations().get(i);
                String strDate= formatter.format(str.getDateReservation()); 
                writer.write(str.getIdReservation()+","+str.getIdCustomer()+","+str.getIdTable()+","+strDate+","+strDate+","+str.isState()+","+str.getCurrentHour());

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'Reservation.txt' not found write method");
        }
    
    
    }

    @Override
    public void readFile() {
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.setIdReservation(x.nextInt());
                this.setIdCustomer(x.nextInt());
                this.setIdTable(x.nextInt());
                
                
               try {
                  
                   
                    this.setDateReservation(dateformat3.parse(x.next()));
                    this.setDropReservation(dateformat3.parse(x.next()));
                    
                    
                } catch (ParseException e) {
                    System.out.println("Error to parse date");
                }
                
               this.setState(x.nextBoolean());
               this.setCurrentHour(x.next());
               this.getReservations().add(new Reservation(this.getIdReservation(),this.getIdCustomer(),this.getIdTable(),this.getDateReservation(),this.getDropReservation(),this.isState(),this.getCurrentHour()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'Employe.txt' not found read method");
        }
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
           createFile();
            Date date = new Date();
            this.getReservations().add(new Reservation(1, 1, 1, date, date, true, date.toString()));
            writeFile();
            System.out.println("Default Reservation has been created");
          
        }
    
    }
    
    public void add(int IdReservation, int IdCustomer, int IdTable, Date DateReservation, Date DropReservation, boolean state, String CurrentHour){
        this.getReservations().add(new Reservation(IdReservation, IdCustomer, IdTable, DateReservation, DropReservation, state, CurrentHour));
        writeFile();
        
    }
    
    public void modify(int IdReservation, int IdCustomer, int IdTable, Date DateReservation, Date DropReservation, boolean state, String CurrentHour){
        
       for (Reservation reservation : this.getReservations()) {
           if (reservation.getIdReservation() == IdReservation) {
               reservation.setIdTable(IdTable);
               reservation.setDateReservation(DateReservation);
               reservation.setDropReservation(DropReservation);
               reservation.setState(state);
               reservation.setCurrentHour(CurrentHour);
               break;
               
               
           }
       }
       
       writeFile();
        
    }
    
    public void delete(int index){
        this.getReservations().remove(index);
        writeFile();
        
        
    }
   
   

 
    
}
