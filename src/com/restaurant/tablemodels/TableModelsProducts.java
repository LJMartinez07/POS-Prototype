/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.Product;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsProducts {
    String[] title = {"Id", "Descripcion", "Tipo", "Precio", "Existencia", "ITBIS"};
    String[] register = new String[6];
    
       
    public DefaultTableModel initTable(JTable table){
        Product product = new Product();
       
        product.readFile();
        DefaultTableModel Model;
         
        Model = new DefaultTableModel(null, title);
        
        for (Product product1 : product.getProducts()) {
            
            register[0] = String.valueOf(product1.getIdProduct());
            register[1] = product1.getDescription();
            register[2] = String.valueOf(product1.getKindOfProduct());
            register[3] = String.valueOf(product1.getPrice());
            register[4] = String.valueOf(product1.getStock());
            register[5] = String.valueOf(product1.isITBIS());

            
            
            Model.addRow(register);
        }
        
        
        
        table.setModel(Model);
        return Model;
    }
    
}
