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
public class InOutProduct implements FileActions{
    int idInOut, kindInOut;
    Date dateReg;
    boolean status;
    String fileName="Files/InOutProduct.txt";
    
    
    private ArrayList<InOutProduct> InOutProducts = new ArrayList<>();

    public InOutProduct(int idInOut, int kindInOut, Date dateReg, boolean status) {
        this.idInOut = idInOut;
        this.kindInOut = kindInOut;
        this.dateReg = dateReg;
        this.status = status;
    }

    public InOutProduct() {
    
    }

    public int getIdInOut() {
        return idInOut;
    }

    public void setIdInOut(int idInOut) {
        this.idInOut = idInOut;
    }

    public int getKindInOut() {
        return kindInOut;
    }

    public void setKindInOut(int kindInOut) {
        this.kindInOut = kindInOut;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<InOutProduct> getInOutProducts() {
        return InOutProducts;
    }

    public void setInOutProducts(ArrayList<InOutProduct> InOutProducts) {
        this.InOutProducts = InOutProducts;
    }

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'IntOutProduct.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'IntOutProduct.txt'");
            }
        }
    }

    @Override
    public void writeFile() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getInOutProducts().size();
            for (int i=0;i<size;i++) {
                InOutProduct str = this.getInOutProducts().get(i);
               //int idInOut, int kindInOut, Date dateReg, boolean status
                writer.write(str.getIdInOut()+","+str.getKindInOut()+","+formatter.format(str.getDateReg())+","+str.isStatus());

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'InOutProduct.txt' not found write method");
        }
    
    }

    @Override
    public void readFile() {
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
   
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                
                
               try {
                   
                    this.getInOutProducts().add(new InOutProduct(x.nextInt(), x.nextInt(), dateformat3.parse(x.next()), x.nextBoolean()));
                     
                } catch (ParseException e) {
                    System.out.println("Error to parse date");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'InOutProduct.txt' not found read method");
        }
    
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            this.createFile();
            System.out.println("Default InOutProduct has been created");  
        }
    
    }
    
    
    public void add(int idInOut, int kindInOut, Date dateReg){
        this.getInOutProducts().add(new InOutProduct(idInOut, kindInOut, dateReg, false));
        this.writeFile();
    }
    
     public void modify(int idInOut, int kindInOut, Date dateReg){
         for (InOutProduct InOutProduct1 : InOutProducts) {
             if (InOutProduct1.getIdInOut() == idInOut) {
                 InOutProduct1.setDateReg(dateReg);
                 InOutProduct1.setKindInOut(kindInOut);
                break;
                 
                 
             }
             
             
         }
         writeFile();
        
    }
    
    
    
    
}
