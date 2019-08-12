/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.KindProduct;
import com.restaurant.classes.Product;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsKindOfProducts {
       String[] title = {"Id", "Nombre"};
    String[] register = new String[2];
    
       
    public DefaultTableModel initTable(JTable table){
        KindProduct KindProduct = new KindProduct();
       
        KindProduct.readFile();
        DefaultTableModel Model;
         
        Model = new DefaultTableModel(null, title);
        
        for (KindProduct KindProduct1 : KindProduct.getKindsProducts()) {
            
            register[0] = String.valueOf(KindProduct1.getIdKindOfProduct());
            register[1] = KindProduct1.getName();

            
            
            Model.addRow(register);
        }
        
        
        
        table.setModel(Model);
        return Model;
    }
    
}
