/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.Employe;
import com.restaurant.classes.Table;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsTables {
    
       String[] title = {"Id", "Max_Comersales", "Cant_Comersales", "Estatus", "Numero"};
    String[] register = new String[5];
    
       
    public DefaultTableModel initTable(JTable table){
        Table table1 = new Table();
       
        table1.readFile();
        DefaultTableModel Model;
         
        Model = new DefaultTableModel(null, title);
        
        for (Table table2 : table1.getTables()) {
            register[0] = String.valueOf(table2.getIdTable());
            register[1] = String.valueOf(table2.getMaxComersales());
            register[2] = String.valueOf(table2.getCantComersales());
            register[3] = table2.isState() == true ? "Activa" : "No Activa";
            register[4] = String.valueOf(table2.getNumTables());
            Model.addRow(register);
        }
        
        
        
        table.setModel(Model);
        return Model;
    }
    
}
