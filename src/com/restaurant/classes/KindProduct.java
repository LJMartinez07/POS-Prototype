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
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class KindProduct implements FileActions{
    
    private int IdKindOfProduct;
    private String Name,
            fileName = "Files/KindProduct.txt";
    
    private ArrayList<KindProduct> kindsProducts = new ArrayList<>();

    public KindProduct() {
    }

    public KindProduct(int IdKindOfProduct, String Name) {
        this.IdKindOfProduct = IdKindOfProduct;
        this.Name = Name;
    }

    public int getIdKindOfProduct() {
        return IdKindOfProduct;
    }

    public void setIdKindOfProduct(int IdKindOfProduct) {
        this.IdKindOfProduct = IdKindOfProduct;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<KindProduct> getKindsProducts() {
        return kindsProducts;
    }

    public void setKindsProducts(ArrayList<KindProduct> kindsProducts) {
        this.kindsProducts = kindsProducts;
    }

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'KindOfProduct.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'KindOfProduct.txt'");
            }
        }
    
    }

    @Override
    public void writeFile() {
         try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getKindsProducts().size();
            for (int i=0;i<size;i++) {
                KindProduct str = this.getKindsProducts().get(i);
                
                writer.write(str.getIdKindOfProduct()+","+str.getName());

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'KindOfProduct.txt' not found write method");
        }
    
    }

    @Override
    public void readFile() {
        
         try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                
                this.setIdKindOfProduct(x.nextInt());
                this.setName(x.next());
               
                this.getKindsProducts().add(new KindProduct(this.getIdKindOfProduct(), this.getName()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'KindOfProduct.txt' not found read method");
        }
    
    }

    @Override
    public void validateFile() {
          File file = new File(this.fileName);
        if (!file.exists()) {
            this.createFile();
            this.getKindsProducts().add(new KindProduct(1, "teting 1"));
            this.writeFile();
            System.out.println("Default kind of product has been created");  
        }
    
    }
    
    public void add(int id, String name){
        this.getKindsProducts().add(new KindProduct(id, name));
        writeFile();
        
    }
    
    public String NameKind(int id){
        
        readFile();
        for (KindProduct kindsProduct : this.getKindsProducts()) {
            if (id == kindsProduct.getIdKindOfProduct()) 
                return kindsProduct.getName();
      
        }
            return null;
        
    }
    
    public void modify(int id, String name){
         for (KindProduct kindOfproduct : this.getKindsProducts()) {
              if (kindOfproduct.getIdKindOfProduct()== id) {
                kindOfproduct.setName(name);
                        
               
                
                break;  
            }
        }
        writeFile();  
        
    }
    
    public void delete(int index){
        this.kindsProducts.remove(index);
        writeFile();     
    }
    
    
    
    
    
}
