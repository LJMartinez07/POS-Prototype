/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;


import static com.restaurant.utilities.Hash.getMD5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;
import com.restaurant.utilities.FileActions;
/**
 *
 * @author Luis
 */
public class User extends Employe implements FileActions{
    private String userName, 
            password,
            fileName = "Files/User.txt",
            email;
    private int idUser, accessLevel, fkEmploye;
    
 
    public ArrayList<User> users = new ArrayList<>();
    public static Scanner x;

    /*public User(String userName, String password, int accesslevel, int IdEmploye, String KindOfEmploye, String Picture, double Balance, double PorcentBalance, String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula, Date DateReg) {
        super(IdEmploye, KindOfEmploye, Picture, Balance, PorcentBalance, Name, LastName1, LastName2, Gender, Adress, Telephone, Phone, Cedula, DateReg);
        this.userName = userName;
        this.password = password;
    }*/
    
    public User(int idUser, String userName, String password, String email, int accesslevel, int fkEmploye){
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.accessLevel = accesslevel;
        this.fkEmploye = fkEmploye;
    }
    
    public User(){
        super();      
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getFkEmploye() {
        return fkEmploye;
    }

    public void setFkEmploye(int fkEmploye) {
        this.fkEmploye = fkEmploye;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    
    
    public boolean Login(String Username, String Password) {
        
        boolean found = false;
        String tempUsername, tempPassword;
        
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !found){
                x.next();
                tempUsername = x.next();
                tempPassword = x.next();
                if (tempUsername.equals(Username) && tempPassword.equals(getMD5(Password))) {
                    found = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'User.txt' not found login method");
        }
        return found;   
    }
    
    @Override
    public void validateFile(){
        File file = new File(this.fileName);
        if (!file.exists()) {
            this.createFile();
            this.getUsers().add(new User(1, "Admin", getMD5("123456"), "Luis@gmail.com", 1, 1));
            this.writeFile();
            System.out.println("Default User has been created");  
        }
        
    }

   
    @Override
    public void writeFile() {
        
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getUsers().size();
            for (int i=0;i<size;i++) {
                User str = this.getUsers().get(i);
            
                writer.write(str.getIdUser()+","+str.getUserName()+","+str.getPassword()+","+str.getEmail()+","+str.getAccessLevel()+","+str.getFkEmploye());
 
                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("Error al insertar en archivo");
        }
    }

   
    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'User.txt' has been created successfully");
            } catch (IOException e) {
                System.out.println("Error to create 'User.txt'");
            }
        }
    }

    @Override
    public void readFile() {
        System.out.println("I'm Reading");
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.setIdUser(x.nextInt());
                this.setUserName(x.next());
                this.setPassword(x.next());
                this.setEmail(x.next());
                this.setAccessLevel(x.nextInt());
                this.setFkEmploye(x.nextInt());
                //String userName, String password, int accesslevel, int IdEmploye, String KindOfEmploye, String Picture, double Balance, double PorcentBalance, String Name, String LastName1, String LastName2, String Gender, String Adress, String Telephone, String Phone, String Cedula, Date DateReg
                this.getUsers().add(new User(this.getIdUser(), this.getUserName(), this.getPassword(), this.getEmail(), this.getAccessLevel(), this.getFkEmploye()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'User.txt' not found read method");
        }
        
        
      
    }

   
    public void add(int id,String username, String password, String email, int access, int fk ){
        
       
        this.getUsers().add(new User(id, username, getMD5(password), email, access, fk));
        writeFile();
        
    }
    
    public void modify(int id, String username, String password, String email, int accessLevel){
        
        for (User user : this.getUsers()) {
            if (user.getIdUser() == id) {
                user.setUserName(username);
                user.setPassword(password);
                user.setEmail(email);
                user.setAccessLevel(accessLevel);
                break;
                
                
            }
        }
        writeFile();
        
    }
    @Override
    public void delete(int index){
        this.getUsers().remove(index);
        writeFile();
    }

    
    
   

    
}
