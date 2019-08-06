/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.utilities;

import com.restaurant.classes.User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public  class FileActions {
    
     String fileName;

    public FileActions(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
     
     
    public void createFile(){
        File file = new File(this.getFileName());
        if (!file.exists()) {
            try {
                 file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear archivo");
            }
        }
        System.out.println("File has been created");
    }
    
    
    public void writeFile(ArrayList<String> array){
        
        try {
            FileWriter writer = new FileWriter(this.getFileName());
            int size = array.size();
            for (int i=0;i<size;i++) {
                String str = array.get(i);
                writer.write(str);
                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("Error al insertar en archivo");
        }
        
        
    }

    
}
