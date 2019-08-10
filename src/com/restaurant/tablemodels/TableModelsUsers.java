/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.tablemodels;

import com.restaurant.classes.Employe;
import com.restaurant.classes.User;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class TableModelsUsers {
    
    String[] title = {"Usuario", "Email", "Nombre", "Apellido P", "Apellido M", "Acceso"};
    String[] register = new String[6];
    
       
      public DefaultTableModel initTable(JTable table){
          User user = new User();
          Employe employe = new Employe();
          user.readFile();
          employe.readFile();
        DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, title);
        
          for (int i = 0; i < user.getUsers().size(); i++) {
            register[0] = user.getUsers().get(i).getUserName();
            register[1] = user.getUsers().get(i).getEmail();
            register[5] = String.valueOf(user.getUsers().get(i).getAccessLevel()); 
            
              for (Employe employee : employe.getEmployees()) {
                  
                  if (employee.getIdEmploye() == user.getUsers().get(i).getFkEmploye() && employee.getAvailable() == 1) {
                      System.out.println("Lo enconte");
                      
                      register[2] = employee.getName();
                      register[3] = employee.getLastName1();
                      register[4] = employee.getLastName2();
                  }
              }
               modelo.addRow(register);
          }
        
        table.setModel(modelo);
        return modelo;
    }
   // public DefaultTableModel ReaUsa(JTable table){
          
      /*  DefaultTableModel modelo;
         
        modelo = new DefaultTableModel(null, titulos);
        try {
            String q = "SELECT * FROM usuarios WHERE Activo = 'Desactivo'";//Seleccionamos todo de las tablas personas y clientes
            ResultSet rs = Conexion.getRegistros(q);
            while (rs.next()) {
                
                registros[0] = rs.getString("Usuario");
                registros[1] = rs.getString("Password");          
                registros[2] = rs.getString("acceso");
                
                modelo.addRow(registros);
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        table.setModel(modelo);
        return modelo;*/
    //}
    
}
