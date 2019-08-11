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
public class Comment implements FileActions{
    private int IdComment;
    private String Email,
            Subject,
            Description,
            fileName="Files/Comment.txt";
    private Date CrationDate;
    
    private ArrayList<Comment> comments = new ArrayList<>();

    public Comment() {
    }

    public Comment(int IdComment, String Email, String Subject, String Description, Date CrationDate) {
        this.IdComment = IdComment;
        this.Email = Email;
        this.Subject = Subject;
        this.Description = Description;
        this.CrationDate = CrationDate;
    }
    
    

    public int getIdComment() {
        return IdComment;
    }

    public void setIdComment(int IdComment) {
        this.IdComment = IdComment;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCrationDate() {
        return CrationDate;
    }

    public void setCrationDate(Date CrationDate) {
        this.CrationDate = CrationDate;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public void createFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("'Comment.txt' has been created successfully"); 
            } catch (IOException e) {
                System.out.println("Error to create 'Comment.txt'");
            }
        }
    }

    @Override
    public void writeFile() {
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
   
        try {
            FileWriter writer = new FileWriter(this.fileName);
            int size = this.getComments().size();
            for (int i=0;i<size;i++) {
                Comment str = this.getComments().get(i);
                String strDate= formatter.format(str.getCrationDate()); 
                writer.write(str.getIdComment()+","+str.getEmail()+","+str.getSubject()+","+str.getDescription()+","+strDate);
                if(i < size-1)
                    writer.write("\n");
            }
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File 'Comment.txt' not found write method");
        }
    
    }

   
    @Override
    public void readFile() {
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
   
        try {
            x = new Scanner(new File(this.fileName));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                this.setIdComment(x.nextInt());
                this.setEmail(x.next());
                this.setSubject(x.next());
                this.setDescription(x.next());
               try {
                    this.setCrationDate(dateformat3.parse(x.next()));
                } catch (ParseException e) {
                    System.out.println("Error to parse date");
                }
                
                this.getComments().add(new Comment(this.getIdComment(), this.getEmail(), this.getSubject(), this.getDescription(), this.getCrationDate()));
           
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'Comment.txt' not found read method");
        }
    
    }

    @Override
    public void validateFile() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            Date date = new Date();
            this.createFile();
            this.getComments().add(new Comment(1, "Luis.Jorge.Martinez@gmail.com", "First test", "its working", date));
            this.writeFile();
            System.out.println("Default Comment has been created");
        }
    }
    
    public void add(int id, String email, String subject, String description){
        
        Date date = new Date();
        this.getComments().add(new Comment(id, email, subject, description, date));
        writeFile(); 
    }
    
    public void modify(int id, String email, String subject, String description){
        Date date = new Date();
        for (Comment comment : this.getComments()) {
            if (comment.getIdComment() == id) {
                comment.setEmail(email);
                comment.setSubject(subject);
                comment.setDescription(description);
                comment.setCrationDate(date);
                break;
                
            }
        }
        writeFile();  
    }
    
    
    public void delete(int index){
        this.getComments().remove(index);
        writeFile();
        
    }
}
