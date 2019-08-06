/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class User{
    private String userName, password, filaName = "User.txt";

    private static Scanner x;
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public User() {
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
     
    public boolean Login(String Username, String Password) {
        
        boolean found = false;
        String tempUsername, tempPassword;
        
        try {
             x = new Scanner(new File(this.filaName));
        x.useDelimiter("[,\n]");
        while(x.hasNext() && !found){
            tempUsername = x.next();
            tempPassword = x.next();
            
            if (tempUsername.equals(Username) && tempPassword.equals(Password)) {
                found = true;
            }
        }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        
       
       
        return found;
    
    }

   
    public void writeFile(ArrayList<User> Usuarios) {
         try {
            FileWriter writer = new FileWriter(this.filaName);
            int size = Usuarios.size();
            for (int i=0;i<size;i++) {
                User str = Usuarios.get(i);
               
                writer.write(str.userName);
                   writer.write(",");
                writer.write(str.password);
                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("Error al insertar en archivo");
        }
     
    }
}
