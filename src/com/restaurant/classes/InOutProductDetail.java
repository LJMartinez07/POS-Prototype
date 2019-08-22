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
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class InOutProductDetail implements FileActions {
    int InOutProductDetail, sec, idProduct;
    double Quantity, Price;
    String fileName="Files/InOutProductDetail.txt";
    
    private ArrayList<InOutProductDetail> InOutProductDetails = new ArrayList<>();

    public InOutProductDetail() {
    }
    

    
    
    public InOutProductDetail(int InOutProductDetail, int sec, int idProduct, double Quantity, double Price) {
        this.InOutProductDetail = InOutProductDetail;
        this.sec = sec;
        this.idProduct = idProduct;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public int getInOutProductDetail() {
        return InOutProductDetail;
    }

    public void setInOutProductDetail(int InOutProductDetail) {
        this.InOutProductDetail = InOutProductDetail;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public ArrayList<InOutProductDetail> getInOutProductDetails() {
        return InOutProductDetails;
    }

    public void setInOutProductDetails(ArrayList<InOutProductDetail> InOutProductDetails) {
        this.InOutProductDetails = InOutProductDetails;
    }

    

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'IntOutProductDetail.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'IntOutProductDetail.txt'");
            }
        }
    }

    @Override
    public void writeFile() {
         try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getInOutProductDetails().size();
            for (int i=0;i<size;i++) {
                InOutProductDetail str = this.getInOutProductDetails().get(i);
               
                writer.write(str.getInOutProductDetail()+","+str.getSec()+","+str.getIdProduct()+","+str.getQuantity()+","+str.getPrice());

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'InOutProductDetail.txt' not found write method");
        }
     
    }

    @Override
    public void readFile() {
      
   
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.getInOutProductDetails().add(new InOutProductDetail(x.nextInt(), x.nextInt(), x.nextInt(), x.nextDouble(), x.nextDouble()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'InOutProductDetail.txt' not found read method");
        }
    
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            this.createFile();
            System.out.println("Default InOutProductDetail has been created");  
        }
    
    }
    
    public void add(int InOutProductDetail, int sec, int idProduct, double Quantity, double Price){
        this.getInOutProductDetails().add(new InOutProductDetail(InOutProductDetail, sec, idProduct, Quantity, Price));
        writeFile();
        
    }
   
    
    
    
    
}
