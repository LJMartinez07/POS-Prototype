/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.Employe;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsEmployees {
    String[] title = {"Nombre", "Apellido P", "Apellido M", "Tipo", "Balance Propina", "% Propina"};
    String[] register = new String[6];
    
       
    public DefaultTableModel initTable(JTable table){
        Employe employe = new Employe();
       
        employe.readFile();
        DefaultTableModel Model;
         
        Model = new DefaultTableModel(null, title);
        
        for (Employe employee : employe.getEmployees()) {
            register[0] = employee.getName();
            register[1] = employee.getLastName1();
            register[2] = employee.getLastName2();
            register[3] = String.valueOf(employee.getKindOfEmploye());
            register[4] = String.valueOf(employee.getBalance());
            register[5] = String.valueOf(employee.getPorcentBalance());
            
            
            Model.addRow(register);
        }
        
        
        
        table.setModel(Model);
        return Model;
    }
    
}
