/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.Customer;
import com.restaurant.classes.Reservation;
import com.restaurant.classes.Table;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsReservations {
    String[] title = {"Id", "Fecha", "Cliente", "Mesa", "Estado"};
    String[] register = new String[5];
    
       
    public DefaultTableModel initTable(JTable table){
      
        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        Table table1 = new Table();
       
        customer.readFile();
        table1.readFile();
        reservation.readFile();
        DefaultTableModel Model;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        Model = new DefaultTableModel(null, title);
        
        for (Reservation reservation1 : reservation.getReservations()) {
            register[0] = String.valueOf(reservation1.getIdReservation());
            register[1] = formatter.format(reservation1.getDateReservation());
            for (Customer customer1 : customer.getCustomers()) {
                if (customer1.getIdCustomer() == reservation1.getIdTable()) {
                    register[2] = customer1.getName();
                    break;  
                }
            }
            for (Table table2 : table1.getTables()) {
                if (table2.getIdTable() == reservation1.getIdTable()){
                    register[3] = String.valueOf(table2.getNumTable());
                    break;

                }
            }
            
            register[4] = reservation1.isState() ? "Activa" : "No Activa";
            
           
            Model.addRow(register);
        }
        
        
        
        table.setModel(Model);
        return Model;
    }
    
}
