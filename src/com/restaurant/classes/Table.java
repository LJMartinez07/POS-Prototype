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

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Table implements FileActions{
    private int IdTable,
            MaxComersales,
            CantComersales,
            NumTable;
    private String  fileName="Files/Table.txt";
    private boolean state;
    
    private ArrayList<Table> Tables = new ArrayList<>();

    
    public Table(int IdTable, int MaxComersales, int CantComersales, int NumTable, boolean state) {
        this.IdTable = IdTable;
        this.MaxComersales = MaxComersales;
        this.CantComersales = CantComersales;
        this.NumTable = NumTable;
        this.state = state;
    }

    public Table(int IdTable, int NumTable) {
        this.IdTable = IdTable;
        this.NumTable = NumTable;
    }

    
    public Table() {
    }

   

    public int getIdTable() {
        return IdTable;
    }

    public void setIdTable(int IdTable) {
        this.IdTable = IdTable;
    }

    public int getMaxComersales() {
        return MaxComersales;
    }

    public void setMaxComersales(int MaxComersales) {
        this.MaxComersales = MaxComersales;
    }

    public int getCantComersales() {
        return CantComersales;
    }

    public void setCantComersales(int CantComersales) {
        this.CantComersales = CantComersales;
    }

    public int getNumTable() {
        return NumTable;
    }

    public void setNumTable(int NumTable) {
        this.NumTable = NumTable;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ArrayList<Table> getTables() {
        return Tables;
    }

    public void setTables(ArrayList<Table> Tables) {
        this.Tables = Tables;
    }

   

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'Table.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'Table.txt'");
            }
        }
       
    }

    @Override
    public void writeFile() {
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getTables().size();
            for (int i=0;i<size;i++) {
                Table str = this.getTables().get(i);
                 
                writer.write(str.getIdTable()+","+str.getMaxComersales()+","+str.getCantComersales()+","+str.isState()+","+str.getNumTable());
                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'Tables.txt' not found write method");
        }
        
    }

    @Override
    public void readFile() {
        
         try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.setIdTable(x.nextInt());
                this.setMaxComersales(x.nextInt());
                this.setCantComersales(x.nextInt());
                this.setState(x.nextBoolean());
                this.setNumTable(x.nextInt());

                this.getTables().add(new Table(this.getIdTable(), this.getMaxComersales(), this.getCantComersales(), this.getNumTable(), this.isState()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'Table.txt' not found read method");
        }
       
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
          
            this.createFile();
            this.getTables().add(new Table(1, 5, 0, 1, true));
            this.writeFile();
            System.out.println("Default Employe has been created");
          
        }
       
    }
    
 
    public void add(int IdTable, int MaxComersales, int CantComersales, int NumTables){
        this.getTables().add(new Table(IdTable, MaxComersales, CantComersales, NumTables, false));
        writeFile();
    }
    
    
    public void modify(int IdTable, int MaxComersales, int CantComersales, int NumTable, boolean state){
        
        for (Table table : this.getTables()) {
            if (table.getIdTable() == IdTable) {
                table.setCantComersales(CantComersales);
                table.setMaxComersales(MaxComersales);
                table.setNumTable(NumTable);
                table.setState(state);
                break;
                
            }
        }
        
        writeFile();
        
    }
    
    
    public void delete(int index){
        this.getTables().remove(index);
        writeFile();
        
    }

    
    
    
    
}
