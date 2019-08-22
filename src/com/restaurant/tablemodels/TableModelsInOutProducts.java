/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.InOutProductDetail;
import com.restaurant.classes.KindProduct;
import com.restaurant.classes.Product;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsInOutProducts {
    String[] title = {"Id Producto", "Descripcion", "Precio", "Cantidad"};
    String[] register = new String[6];
   
       
    public DefaultTableModel initTable(JTable table){
        DefaultTableModel Model;
        Model = new DefaultTableModel(null, title);
      /*  for (KindProduct KindProduct1 : KindProduct.getKindsProducts()) {
            
            register[0] = String.valueOf(KindProduct1.getIdKindOfProduct());
            register[1] = KindProduct1.getName();

            
            
            Model.addRow(register);
        }*/
        
        
        
        table.setModel(Model);
        return Model;
    }
    
    public DefaultTableModel getInOutActive(JTable table, ArrayList<InOutProductDetail> InOutProductDetails, int idIntOut){
        DefaultTableModel Model;
        Model = new DefaultTableModel(null, title);
        
        Product pro = new Product();
        pro.readFile();
      
        for (InOutProductDetail InOutProductDetail1 : InOutProductDetails) {
            
            if (InOutProductDetail1.getInOutProductDetail() == idIntOut) {
                
                register[0] = String.valueOf(InOutProductDetail1.getIdProduct());
            for (Product pro1 : pro.getProducts()) {
                if (pro1.getIdProduct() == InOutProductDetail1.getIdProduct()) {
                    
                    System.out.println(pro1.getDescription());
                    register[1] = pro1.getDescription();
                    break;
                    
                }
                
            }

            
            register[2] = String.valueOf(InOutProductDetail1.getPrice());
            register[3] = String.valueOf(InOutProductDetail1.getQuantity());
                
            }
          
            Model.addRow(register);
            
            
        }
        
         table.setModel(Model);
        return Model;
    }
    
    
    public DefaultTableModel getInOut(JTable table, ArrayList<InOutProductDetail> InOutProductDetails, int idIntOut){
        
        DefaultTableModel Model;
        Model = new DefaultTableModel(null, title);
        return null;
        
    }
    
}
