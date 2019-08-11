/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.Customer;
import com.restaurant.classes.Employe;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsCustomers {
    String[] title = {"Id", "Nombre", "Apellido P", "Apellido M", "Celular", "Email"};
    String[] register = new String[6];
    
       
    public DefaultTableModel initTable(JTable table){
        Customer customer = new Customer();
       
        customer.readFile();
        DefaultTableModel Model;
         
        Model = new DefaultTableModel(null, title);
        
        for (Customer customer1 : customer.getCustomers()) {
            
            register[0] = String.valueOf(customer1.getIdCustomer());
            register[1] = customer1.getName();
            register[2] = customer1.getLastName1();
            register[3] = customer1.getLastName2();
            register[4] = customer1.getPhone();
            register[5] = customer1.getEmail();

            
            
            Model.addRow(register);
        }
        
        
        
        table.setModel(Model);
        return Model;
    }
}
