/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.Comment;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsComments {
    String[] title = {"Id","Email", "Asunto", "Descripcion", "Fecha"};
    String[] register = new String[5];
    
       
    public DefaultTableModel initTable(JTable table){
        Comment comment = new Comment();
       
        comment.readFile();
        DefaultTableModel Model;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
         
        Model = new DefaultTableModel(null, title);
        
        for (Comment comment1 : comment.getComments()) {
            System.out.println(comment1.getIdComment());
            register[0] = String.valueOf(comment1.getIdComment());
            register[1] = comment1.getEmail();
            register[2] = comment1.getSubject();
            register[3] = comment1.getDescription();
            register[4] = formatter.format(comment1.getCrationDate());
          
            
            
            Model.addRow(register);
        }
        
        
        
        table.setModel(Model);
        return Model;
    }
    
}
