/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.classes;

import static com.restaurant.classes.User.x;
import com.restaurant.utilities.FileActions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class KindEmploye implements FileActions{
    int IdKindEmploye;
    String Name,  fileName="Files/KindEmploye.txt";;
    
     private ArrayList<KindEmploye> kindEmployes = new ArrayList<>();

    public KindEmploye(int IdKindEmploye, String Name) {
        this.IdKindEmploye = IdKindEmploye;
        this.Name = Name;
    }

    public KindEmploye() {
    
    }

    public int getIdKindEmploye() {
        return IdKindEmploye;
    }

    public void setIdKindEmploye(int IdKindEmploye) {
        this.IdKindEmploye = IdKindEmploye;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<KindEmploye> getKindEmployes() {
        return kindEmployes;
    }

    public void setKindEmployes(ArrayList<KindEmploye> kindEmployes) {
        this.kindEmployes = kindEmployes;
    }

   

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'KindEmploye.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'KindEmploye.txt'");
            }
        }
    
    }

    @Override
    public void writeFile() {
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getKindEmployes().size();
            for (int i=0;i<size;i++) {
                KindEmploye str = this.getKindEmployes().get(i);
                
                writer.write(str.getIdKindEmploye()+","+str.getName());

                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'KindEmploye.txt' not found write method");
        }
    }

    @Override
    public void readFile() {
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.getKindEmployes().add(new KindEmploye(x.nextInt(), x.next()));
          
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'KindEmploye.txt' not found read method");
        }
    
    }

    @Override
    public void validateFile() {
     File file = new File(this.fileName);
        if (!file.exists()) {
            Date date = new Date();
            this.createFile();
            this.getKindEmployes().add(new KindEmploye(1, "Administrador"));
            this.getKindEmployes().add(new KindEmploye(2, "Camarero"));
            this.writeFile();
            System.out.println("Default KindEmploye has been created");
        }
    
    }
    
    
    
    
    
}
