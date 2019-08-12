/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import com.restaurant.classes.Comment;
import com.restaurant.classes.Customer;
import com.restaurant.classes.Employe;
import com.restaurant.classes.KindProduct;
import com.restaurant.classes.Product;
import com.restaurant.classes.Table;
import com.restaurant.classes.User;



/**
 *
 * @author Luis
 */
public class Main {
    
    static User user = new User();
    static Employe emp = new Employe();
    static Comment comment = new Comment();
    static Table table = new Table();
    static Customer customer = new Customer();
    static Product product = new Product();
    static KindProduct kind = new KindProduct();
    public static void createFile(){
        /*user.createFile();
        emp.createFile();*/
    }
    
    public static void readFile(){
      /*  System.out.println("I'm Reading");
        user.readFile();
        emp.readFile();*/
    }
    
    public static void writeFile(){
        user.writeFile();
        emp.writeFile();
    }
    
    
    
    public void defaultComment(){
      
        
        
    }

    
    public void DefaultValidation(){
        emp.validateFile();
        user.validateFile();
        comment.validateFile();
        table.validateFile();
        customer.validateFile();
        product.validateFile();
        kind.validateFile();
    }
    public static void main(String[] args){
        
        Main m = new Main();
        //m.
        
    }

}
