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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis 
 */
public class Product implements FileActions{
    private int IdProduct, KindOfProduct;
    private String Description, 
            fileName ="Files/Product.txt";
    private double Price, Stock;
    private boolean ITBIS;
    
    private ArrayList<Product> products = new ArrayList<>();

    public Product() {
    }

    public Product(int IdProduct, int KindOfProduct, String Description, double Price, double Stock, boolean ITBIS) {
        this.IdProduct = IdProduct;
        this.KindOfProduct = KindOfProduct;
        this.Description = Description;
        this.Price = Price;
        this.Stock = Stock;
        this.ITBIS = ITBIS;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int IdProduct) {
        this.IdProduct = IdProduct;
    }

    public int getKindOfProduct() {
        return KindOfProduct;
    }

    public void setKindOfProduct(int KindOfProduct) {
        this.KindOfProduct = KindOfProduct;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getStock() {
        return Stock;
    }

    public void setStock(double Stock) {
        this.Stock = Stock;
    }

    public boolean isITBIS() {
        return ITBIS;
    }

    public void setITBIS(boolean ITBIS) {
        this.ITBIS = ITBIS;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'Product.txt' has been created successfully");
            } catch (IOException e) {
                System.out.println("Error to create 'Product.txt'");
            }
        }
   
    }

    @Override
    public void writeFile() {
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getProducts().size();
            for (int i=0;i<size;i++) {
                Product str = this.getProducts().get(i);
                writer.write(str.getIdProduct()+","+str.getKindOfProduct()+","+str.getDescription()+","+str.getPrice()+","+str.getStock()+","+str.isITBIS());
                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al insertar en archivo");
        }
    }

    @Override
    public void readFile() {
         try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.setIdProduct(x.nextInt());
                this.setKindOfProduct(x.nextInt());
                this.setDescription(x.next());
                this.setPrice(x.nextDouble());
                this.setStock(x.nextDouble());
                this.setITBIS(x.nextBoolean());
            
                this.getProducts().add(new Product(this.getIdProduct(), this.getKindOfProduct(), this.getDescription(), this.getPrice(), this.getStock(), this.isITBIS()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'Product.txt' not found read method");
        }
        
        
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            this.createFile();
            this.getProducts().add(new Product(1, 1, "Testing", 150, 0, false));
            this.writeFile();
            System.out.println("Default Product has been created");  
        }
        
    }
    
    
    public void add(int IdProduct, int KindOfProduct, String Description, double Price, double Stock, boolean ITBIS){
        
        this.getProducts().add(new Product(IdProduct, KindOfProduct, Description, Price, Stock, ITBIS));
        writeFile();  
        
    }
    
    public void modify(int IdProduct, int KindOfProduct, String Description, double Price, double Stock, boolean ITBIS){
        for (Product product : this.getProducts()) {
            if (product.getIdProduct() == IdProduct) {
                
                product.setKindOfProduct(KindOfProduct);
                product.setDescription(Description);
                product.setPrice(Price);
                product.setStock(Stock);
                product.setITBIS(ITBIS);
                break; 
            }
        }
        writeFile();
        
    }
    
    public void delete(int index){
        this.getProducts().remove(index);
        writeFile();
        
    }
    
    
    
    
    
    
}
