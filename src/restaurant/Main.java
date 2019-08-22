/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import com.restaurant.classes.Comment;
import com.restaurant.classes.Customer;
import com.restaurant.classes.Employe;
import com.restaurant.classes.InOutProduct;
import com.restaurant.classes.InOutProductDetail;
import com.restaurant.classes.KindEmploye;
import com.restaurant.classes.KindProduct;
import com.restaurant.classes.Order;
import com.restaurant.classes.Product;
import com.restaurant.classes.Reservation;
import com.restaurant.classes.Table;
import com.restaurant.classes.User;



/**
 *
 * @author Luis
 */
public class Main {
    
    User user = new User();
    KindEmploye kindEmploye = new KindEmploye();
    Employe emp = new Employe();
    Comment comment = new Comment();
    Table table = new Table();
    Customer customer = new Customer();
    Product product = new Product();
    KindProduct kind = new KindProduct();
    Reservation reser = new Reservation();
    Order order = new Order();
    InOutProduct inOutProduct = new InOutProduct();
    InOutProductDetail inOutProductDetail= new InOutProductDetail();
    
    public static void createFile(){
        /*user.createFile();
        emp.createFile();*/
    }
    
    public static void readFile(){
      /*  System.out.println("I'm Reading");
        user.readFile();
        emp.readFile();*/
    }
    
    /*public static void writeFile(){
        user.writeFile();
        emp.writeFile();
    }*/
    
    
    
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
        reser.validateFile();
        order.validateFile();
        kindEmploye.validateFile();
        inOutProduct.validateFile();
        inOutProductDetail.validateFile();
    }
    

}
