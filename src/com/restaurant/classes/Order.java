/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;

import com.restaurant.utilities.FileActions;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

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
    
    }

    @Override
    public void writeFile() {
    
    }

    @Override
    public void readFile() {
    
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
            if (Id) {
                
            }
        }
        
    }
    public void delete(int index){
        this.getOrders().remove(index);
        this.writeFile();
    }
    
    
    
}
