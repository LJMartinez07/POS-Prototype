/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.KindProduct;
import com.restaurant.classes.OrderDetail;
import com.restaurant.classes.Product;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsOrders {
    String[] title = {"Id Producto", "Descripcion", "Cantidad", "Precio", "ITBIS", "Total"};
    String[] register = new String[6];
    
       
    public DefaultTableModel initTable(JTable table){
      
        DefaultTableModel Model;
         
        Model = new DefaultTableModel(null, title);
        
        /*for (KindProduct KindProduct1 : KindProduct.getKindsProducts()) {
            
            register[0] = String.valueOf(KindProduct1.getIdKindOfProduct());
            register[1] = KindProduct1.getName();

            
            
            Model.addRow(register);
        }
        */
        
        
        table.setModel(Model);
        return Model;
    }
    
    
    
    
    public DefaultTableModel getActiveOrder(JTable table, ArrayList<OrderDetail> orderDetailes) {
         DefaultTableModel Model;
      
        Model = new DefaultTableModel(null, title);
        
        Product product = new Product();
        product.readFile();
      
        
        for (OrderDetail orderDetaile : orderDetailes){
            
            register[0] = String.valueOf(orderDetaile.getIdProduct());
            for (Product product1 : product.getProducts()) {
                if (product1.getIdProduct() == orderDetaile.getIdProduct()) {
                    register[1] = product1.getDescription();
                    break;
                     
                 }
             }

            register[2] = String.valueOf(orderDetaile.getQuantity());
            register[3] = String.valueOf(orderDetaile.getProductPrice());
            register[4] = String.valueOf(orderDetaile.getItbisAmount());
            register[5] = String.valueOf(orderDetaile.getAmount());
                
          
            Model.addRow(register);
        }
        table.setModel(Model);
        return Model;
        
    }

    public DefaultTableModel getFalseOrder(JTable table, int idOrder) {
         DefaultTableModel Model;
      
        Model = new DefaultTableModel(null, title);
        
        Product product = new Product();
        OrderDetail ord = new OrderDetail();
        product.readFile();
        ord.readFile();
      
        
        for (OrderDetail orderDetaile : ord.getOrderDetailes()){
            if (orderDetaile.getIdOrder() == idOrder) {
               
                register[0] = String.valueOf(orderDetaile.getIdProduct());
                for (Product product1 : product.getProducts()) {
                    if (product1.getIdProduct() == orderDetaile.getIdProduct()) {
                        register[1] = product1.getDescription();
                        break;
                    }
                }

                
            register[2] = String.valueOf(orderDetaile.getQuantity());
            register[3] = String.valueOf(orderDetaile.getProductPrice());
            register[4] = String.valueOf(orderDetaile.getItbisAmount());
            register[5] = String.valueOf(orderDetaile.getAmount());
                
          
            Model.addRow(register);
                
            }
            
            
        }
        table.setModel(Model);
        return Model;
   
    }
    
    
}
