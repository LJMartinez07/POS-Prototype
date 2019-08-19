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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class OrderDetail implements FileActions{
    int IdOrder, SecOrder, IdProduct;
    double Quantity, ProductPrice;
    String fileName="Files/OrderDetail.txt";
    
    ArrayList<OrderDetail> orderDetailes = new ArrayList<>();

    public OrderDetail() {
    }

    public OrderDetail(int IdOrder, int SecOrder, int IdProduct, double Quantity, double ProductPrice) {
        this.IdOrder = IdOrder;
        this.SecOrder = SecOrder;
        this.IdProduct = IdProduct;
        this.Quantity = Quantity;
        this.ProductPrice = ProductPrice;
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int IdOrder) {
        this.IdOrder = IdOrder;
    }

    public int getSecOrder() {
        return SecOrder;
    }

    public void setSecOrder(int SecOrder) {
        this.SecOrder = SecOrder;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int IdProduct) {
        this.IdProduct = IdProduct;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public ArrayList<OrderDetail> getOrderDetailes() {
        return orderDetailes;
    }

    public void setOrderDetailes(ArrayList<OrderDetail> orderDetailes) {
        this.orderDetailes = orderDetailes;
    }

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'OrderDetail.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'OrderDetail.txt'");
            }
        }
    
    }

    @Override
    public void writeFile() {
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.orderDetailes.size();
            for (int i=0;i<size;i++) {
                OrderDetail str = this.getOrderDetailes().get(i);
            
                writer.write(str.getIdOrder()+","+str.getSecOrder()+","+str.getIdProduct()
                        +","+str.getQuantity()+","+str.getProductPrice());

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'OrderDetail.txt' not found write method");
        }
    }

    @Override
    public void readFile() {
         SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.getOrderDetailes().add(new OrderDetail(x.nextInt(), x.nextInt(), x.nextInt(), x.nextDouble(), x.nextDouble()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'OrderDetail.txt' not found read method");
        }
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            this.createFile();
            this.getOrderDetailes().add(new OrderDetail(1, 1, 1, 50, 150));
            this.writeFile();
            System.out.println("Default OrderDetail has been created");
        }
    
    }
    
    public void add(int IdOrder, int SecOrder, int IdProduct, double Quantity, double ProductPrice){
        this.getOrderDetailes().add(new OrderDetail(IdOrder, SecOrder, IdProduct, Quantity, ProductPrice));
        this.writeFile();
        
    }
    
    public void modify(int IdOrder, int SecOrder, int IdProduct, double Quantity, double ProductPrice){
        for (OrderDetail orderDetaile : this.getOrderDetailes()) {
            if (orderDetaile.getIdOrder() == IdOrder) {
                orderDetaile.setIdProduct(IdProduct);
                orderDetaile.setSecOrder(SecOrder);
                orderDetaile.setProductPrice(ProductPrice);
                orderDetaile.setQuantity(Quantity);
                break;
                
            }
            
        }
        this.writeFile();
        
    }
    
    public void delete(int index){
        this.getOrderDetailes().remove(index);
        this.writeFile();
        
    }
    
    
    
    
    
}
