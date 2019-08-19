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
public class Order implements FileActions{
    int IdOrder, IdEmploye, IdTable, IdCustomer;
    Date OrderDate;
    double OrderValue, ItbisValue, BalanceValue;
    String Description, fileName="Files/Order.txt";
    boolean State;
    
    ArrayList<Order> orders = new ArrayList<>();

    public Order(int IdOrder, int IdEmploye, int IdTable, int IdCustomer, Date OrderDate, double OrderValue, double ItbisValue, double BalanceValue, String Description, boolean State) {
        this.IdOrder = IdOrder;
        this.IdEmploye = IdEmploye;
        this.IdTable = IdTable;
        this.IdCustomer = IdCustomer;
        this.OrderDate = OrderDate;
        this.OrderValue = OrderValue;
        this.ItbisValue = ItbisValue;
        this.BalanceValue = BalanceValue;
        this.Description = Description;
        this.State = State;
    }

    public Order() {
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int IdOrder) {
        this.IdOrder = IdOrder;
    }

    public int getIdEmploye() {
        return IdEmploye;
    }

    public void setIdEmploye(int IdEmploye) {
        this.IdEmploye = IdEmploye;
    }

    public int getIdTable() {
        return IdTable;
    }

    public void setIdTable(int IdTable) {
        this.IdTable = IdTable;
    }

    public int getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(int IdCustomer) {
        this.IdCustomer = IdCustomer;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public double getOrderValue() {
        return OrderValue;
    }

    public void setOrderValue(double OrderValue) {
        this.OrderValue = OrderValue;
    }

    public double getItbisValue() {
        return ItbisValue;
    }

    public void setItbisValue(double ItbisValue) {
        this.ItbisValue = ItbisValue;
    }

    public double getBalanceValue() {
        return BalanceValue;
    }

    public void setBalanceValue(double BalanceValue) {
        this.BalanceValue = BalanceValue;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'Order.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'Order.txt'");
            }
        }
    }

    @Override
    public void writeFile() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
   
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getOrders().size();
            for (int i=0;i<size;i++) {
                Order str = this.getOrders().get(i);
                String strDate= formatter.format(str.getOrderDate()); 
                writer.write(str.getIdOrder()+","+str.getIdTable()+","+str.getIdCustomer()
                        +","+strDate+","+str.getOrderValue()+","+str.getItbisValue()
                        +","+str.getBalanceValue()+","+str.getDescription()+","+str.getDescription());

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'Order.txt' not found write method");
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
                    this.getOrders().add(new Order(x.nextInt(), x.nextInt(), x.nextInt(), x.nextInt(), dateformat3.parse(x.next()), x.nextDouble(), x.nextDouble(), x.nextDouble(), x.next(), x.nextBoolean()));
                } catch (ParseException e) {
                    System.out.println(e);
                }
              }
        } catch (FileNotFoundException e) {
            System.out.println("File 'Order.txt' not found read method");
        }
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
           createFile();
            Date date = new Date();
            this.getOrders().add(new Order(1, 1, 1, 1, date, 500, 20, 25, "Lo otro y lo otro", true));
            writeFile();
            System.out.println("Default Order has been created");
        }
    }
    
    public void add(int IdOrder, int IdEmploye, int IdTable, int IdCustomer, Date OrderDate, double OrderValue, double ItbisValue, double BalanceValue, String Description, boolean State){
        
        this.getOrders().add(new Order(IdOrder, IdEmploye, IdTable, IdCustomer, OrderDate, OrderValue, ItbisValue, BalanceValue, Description, State));       
        this.writeFile();
        
    }
    
    public void modify(int IdOrder, int IdEmploye, int IdTable, int IdCustomer, Date OrderDate, double OrderValue, double ItbisValue, double BalanceValue, String Description, boolean State){
        
        for (Order order : this.getOrders()) {
            if (IdOrder == order.getIdOrder()) {
                order.setDescription(Description);
                order.setIdEmploye(IdEmploye);
                order.setIdTable(IdTable);
                order.setOrderDate(OrderDate);
                order.setOrderValue(OrderValue);
                order.setItbisValue(ItbisValue);
                order.setBalanceValue(BalanceValue);
                order.setState(State);
                
            }
        }
        writeFile();
        
    }
    public void delete(int index){
        this.getOrders().remove(index);
        this.writeFile();
    }
    
    
    
}
