/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.views.movements;

import com.restaurant.classes.Employe;
import com.restaurant.classes.Order;
import com.restaurant.classes.OrderDetail;
import com.restaurant.classes.Product;
import com.restaurant.classes.Table;
import com.restaurant.combo.ItemRenderEmploye;
import com.restaurant.combo.ItemRenderTable;
import com.restaurant.tablemodels.TableModelsOrders;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class MainOrders extends javax.swing.JInternalFrame {

    /**
     * Creates new form MainOrders
     */
    
    OrderDetail ObjectOrderD;
    Order ObjectOrder;
    Product product;
    TableModelsOrders tmo = new TableModelsOrders();
    Table table;
    ArrayList<OrderDetail> orderDetailes = new ArrayList<>();
    public MainOrders() {
        initComponents();
        tmo.initTable(jt_Orders);
        ObjectOrderD = new OrderDetail();
        product = new Product();
        ObjectOrder = new Order();
        table = new Table();
        table.readFile();
        ObjectOrder.readFile();
        product.readFile();
        ObjectOrderD.readFile();
        setComboEmploye();
        setComboTable();
       
    }
    
    
    public void clear(){
        this.txt_idCustomer.setText("");
        this.txt_idProduct.setText("");
        this.txt_Quantity.setText("");
        this.txt_maxQuantity.setText("");
        this.txt_price.setText("");
        this.txt_totalCalculate.setText("");
    }
    
    
    /*public void setAutoIdPedido(){
        this.ObjectOrder.readFile();
        
        if (this.ObjectOrder.getOrders().isEmpty()) {
            this.txt_idOrder.setText("1");
            return;
            
        }
       
        System.out.println("entonces");
        Order orden = this.ObjectOrder.getOrders().get(this.ObjectOrder.getOrders().size() -1 );
       
   
        this.txt_idOrder.setText(String.valueOf(orden.getIdOrder()+1));
    }*/
    
    public  void setComboTable(){
        DefaultComboBoxModel value;   
        value =new DefaultComboBoxModel();
        
          Table table = new Table();
          table.readFile();
    
        this.jc_Table.setModel(value);
        for (Table table1 : table.getTables()) {
            if (!table1.isState()) 
                value.addElement(new Table(table1.getIdTable(), table1.getNumTable())); 
            
        } 
        if (value.getSize() == 0) {
            value.addElement( new Table(0,  0) );    
        }
        this.jc_Table.setRenderer(new ItemRenderTable());
    }
    
    
    private void setComboEmploye(){
        Employe ObjectEmploye = new Employe();
        ObjectEmploye.readFile();
        DefaultComboBoxModel value;
        value =new DefaultComboBoxModel();
        jc_employe.setModel(value);
        for (Employe employee : ObjectEmploye.getEmployees()) {
            if (employee.getKindOfEmploye() == 2) {
                value.addElement(new Employe(employee.getIdEmploye(), employee.getName()));
            } 
        }
      
        if (value.getSize() == 0) {
            value.addElement( new Employe(0,  "Empty") );    
        } 
        
        jc_employe.setRenderer(new ItemRenderEmploye());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_idOrder = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_idCustomer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jc_employe = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_idProduct = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_maxQuantity = new javax.swing.JTextField();
        txt_Quantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_totalCalculate = new javax.swing.JTextField();
        jr_ITBIS = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jc_Table = new javax.swing.JComboBox<>();
        Body = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Orders = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_totalItbis = new javax.swing.JTextField();
        txt_balance = new javax.swing.JTextField();
        txt_totalneto = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_modify = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Orders");

        jLabel1.setText("Id Pedido");

        txt_idOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idOrderActionPerformed(evt);
            }
        });
        txt_idOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idOrderKeyReleased(evt);
            }
        });

        jLabel2.setText("Cliente");

        txt_idCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idCustomerActionPerformed(evt);
            }
        });
        txt_idCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idCustomerKeyReleased(evt);
            }
        });

        jLabel3.setText("Camerero");

        jc_employe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Codigo Producto");

        txt_idProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idProductActionPerformed(evt);
            }
        });
        txt_idProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idProductKeyReleased(evt);
            }
        });

        jLabel5.setText("Cantidad");

        jLabel6.setText("Cantidad Disponible");

        txt_maxQuantity.setEditable(false);

        txt_Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_QuantityActionPerformed(evt);
            }
        });
        txt_Quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_QuantityKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_QuantityKeyReleased(evt);
            }
        });

        jLabel7.setText("Precio Producto");

        txt_price.setEditable(false);

        jLabel8.setText("Total Calculado");

        txt_totalCalculate.setEditable(false);

        jr_ITBIS.setText("ITBIS");

        jLabel9.setText("Mesa");

        jc_Table.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_idCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jc_employe, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addComponent(txt_idOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4))
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addComponent(jc_Table, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_idProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txt_Quantity))
                        .addGap(18, 18, 18)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_price, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txt_maxQuantity))
                        .addGap(18, 18, 18)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_totalCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jr_ITBIS))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_idOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_idProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_maxQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jr_ITBIS))
                .addGap(18, 18, 18)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_totalCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jc_Table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_idCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jc_employe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jt_Orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jt_Orders);

        jLabel10.setText("Sub Total");

        jLabel11.setText("Itbis");

        jLabel12.setText("Propina");

        jLabel13.setText("Total");

        txt_subtotal.setEditable(false);
        txt_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subtotalActionPerformed(evt);
            }
        });

        txt_totalItbis.setEditable(false);

        txt_balance.setEditable(false);

        txt_totalneto.setEditable(false);

        btn_add.setText("Nuevo Pedido");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_modify.setText("Modificar Pedido");
        btn_modify.setEnabled(false);
        btn_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyLayout.createSequentialGroup()
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_subtotal)
                            .addComponent(txt_totalItbis)
                            .addComponent(txt_balance)
                            .addComponent(txt_totalneto, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyLayout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_modify)))
                .addContainerGap())
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_totalItbis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_totalneto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_modify))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idOrderActionPerformed

    private void txt_idProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idProductActionPerformed

    private void txt_QuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_QuantityKeyPressed
        try {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                if (this.txt_idOrder.getText().isEmpty() 
                    || this.txt_idProduct.getText().isEmpty() 
                    || this.txt_Quantity.getText().isEmpty() 
                    || this.txt_idCustomer.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Campos en Blanco", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
   
           
            int idOrder = Integer.parseInt(this.txt_idOrder.getText());
            int idCustomer = Integer.parseInt(this.txt_idCustomer.getText());
            int idProduct = Integer.parseInt(this.txt_idProduct.getText());
            int Quantity = Integer.parseInt(this.txt_Quantity.getText());
            double productPrice = Double.parseDouble(this.txt_price.getText());
            double amount = Double.parseDouble(this.txt_totalCalculate.getText());
            double ItbisAmout = 0;
            
            if (this.jr_ITBIS.isSelected()) {
                ItbisAmout = amount*0.18;
                    
            }
            Date date = new Date();
            
            /*for (Order order : this.ObjectOrder.getOrders()) {
                if (order.getIdOrder() == idOrder) {
                    found = true;
                    break;
                    
                    
                }
                
            }
            
            if (!found) {
            this.ObjectOrder.add(idOrder, ((Employe)this.jc_employe.getSelectedItem()).getIdEmploye(), ((Table)this.jc_Table.getSelectedItem()).getIdTable(), idCustomer, date, productPrice, amount, productPrice, title, found);
                    
            }*/
            
           
            if (Quantity > Double.parseDouble(this.txt_maxQuantity.getText()) || Quantity == 0) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad valida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
                    
            }
            
             boolean found = false;
            
            for (OrderDetail orderDetaile : this.orderDetailes) {
                if (orderDetaile.getIdProduct() == idProduct) {
                    
                    orderDetaile.setQuantity(Quantity);
                    orderDetaile.setAmount(amount);
                    orderDetaile.setItbisAmount(ItbisAmout);
                    found = true;
                    break;
                    
                }
            }
            
            if (!found) {
                this.orderDetailes.add(new OrderDetail(idOrder, 0, idProduct, Quantity, productPrice, amount, ItbisAmout, this.jr_ITBIS.isSelected()));
                System.out.println("Agregado");
             }
            double Total = 0;
            double itebisTotal = 0;
            for (OrderDetail orderDetaile : this.orderDetailes) {
                    Total = Total + orderDetaile.getAmount();
                    if (orderDetaile.isITBIS()) 
                        itebisTotal = itebisTotal + (orderDetaile.getAmount() * 0.18);

            }
            
            double balance = Total*0.15;
            this.txt_subtotal.setText(String.valueOf(Total));
            this.txt_totalItbis.setText(String.valueOf(itebisTotal));
            this.txt_balance.setText(String.valueOf(Total*0.15 ));
            this.txt_totalneto.setText(String.valueOf(Total+itebisTotal+balance));
            this.tmo.getActiveOrder(jt_Orders, this.orderDetailes);
           
        }
            
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), e, "Upss..",
            JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_txt_QuantityKeyPressed

    private void txt_QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_QuantityActionPerformed
       
    }//GEN-LAST:event_txt_QuantityActionPerformed

    private void txt_idProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idProductKeyReleased

        if(this.txt_idProduct.getText().isEmpty()){
            this.txt_price.setText("");
            this.txt_maxQuantity.setText("");
            return;
        }
            
            
        try {
            int idProduct = Integer.parseInt(this.txt_idProduct.getText());
            boolean found = false;
            
            for (Product product1 : this.product.getProducts()) {
                if (product1.getIdProduct() == idProduct) {
                    this.txt_price.setText(String.valueOf(product1.getPrice()));
                    this.txt_maxQuantity.setText(String.valueOf(product1.getStock()));
                    this.jr_ITBIS.setSelected(product1.isITBIS());
                    found = true;
                    break;
                    
                }
            }
            
            if (!found) {
                JOptionPane.showMessageDialog(new JFrame(), "Producto no existe.", "Upss..",
            JOptionPane.INFORMATION_MESSAGE);
                this.txt_price.setText("");
                this.txt_maxQuantity.setText(""); 
                this.jr_ITBIS.setSelected(false);
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), e, "Upss..",
            JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_txt_idProductKeyReleased

    private void txt_QuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_QuantityKeyReleased

        if (this.txt_Quantity.getText().isEmpty()){
            this.txt_totalCalculate.setText("");
            return;
        }
        
        try {
           double Quantity = Double.parseDouble(this.txt_Quantity.getText());
           double price = Double.parseDouble(this.txt_price.getText());
           double total = Quantity*price;
           this.txt_totalCalculate.setText(String.valueOf(total));
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), e, "Upss..",
            JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_txt_QuantityKeyReleased

    private void txt_idCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idCustomerKeyReleased
        try {
           /* //int idCustomer = Integer.parseInt(this.txt_idCustomer.getText());
            int idOrder = Integer.parseInt(this.txt_idOrder.getText());
            this.tmo.getActiveOrder(jt_Orders, idOrder); 
            
            
            */
            
            
            
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_txt_idCustomerKeyReleased

    private void txt_idOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idOrderKeyReleased
        
       try {
           this.tmo.initTable(jt_Orders);
            int idOrder = Integer.parseInt(this.txt_idOrder.getText());
            
            boolean found = false;
            
            this.btn_add.setEnabled(true);
            this.btn_modify.setEnabled(false);
            
           for (Order order : this.ObjectOrder.getOrders()) {
               if (order.getIdOrder() == idOrder && !order.isState()){
                   this.txt_idCustomer.setText(String.valueOf(order.getIdCustomer()));
                   found = true;
                   
                   break;
                   
               }
               
           }
           
           if (found) {
               this.orderDetailes.clear();
                 this.btn_add.setEnabled(false);
            this.btn_modify.setEnabled(true);
            
                for (OrderDetail orderDetaile : this.ObjectOrderD.getOrderDetailes()) {
                    if (orderDetaile.getIdOrder() == idOrder) {
                          this.orderDetailes.add(new OrderDetail(orderDetaile.getIdOrder(), 0, orderDetaile.getIdProduct(), orderDetaile.getQuantity(), orderDetaile.getProductPrice(), orderDetaile.getAmount(), orderDetaile.getItbisAmount(), orderDetaile.isITBIS())); 
                    }
                       
                            }
               this.tmo.getActiveOrder(jt_Orders, this.orderDetailes);
               double Total = 0;
               double itebisTotal = 0;
            for (OrderDetail orderDetaile : this.ObjectOrderD.getOrderDetailes()) {
                    Total = Total + orderDetaile.getAmount();
                    if (orderDetaile.isITBIS()) 
                        itebisTotal = itebisTotal + (orderDetaile.getAmount() * 0.18);

            }
            this.txt_subtotal.setText(String.valueOf(Total));
                   this.txt_totalItbis.setText(String.valueOf(itebisTotal));
                   this.txt_balance.setText(String.valueOf(Total*0.15));
                   this.txt_totalneto.setText(String.valueOf(Total+itebisTotal+(Total*0.15)));
               
           }
            
            
            
            
        } catch (NumberFormatException e) {
            
        }
    }//GEN-LAST:event_txt_idOrderKeyReleased

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        try {
            int idOrder = Integer.parseInt(this.txt_idOrder.getText());
            int idCustomer = Integer.parseInt(this.txt_idCustomer.getText());
            int idTable = ((Table) this.jc_Table.getSelectedItem()).getIdTable();
            int idEmploye = ((Employe)this.jc_employe.getSelectedItem()).getIdEmploye();
            Date date = new Date();
            double Total = 0;
            double itebisTotal = 0;
            for (OrderDetail orderDetaile : this.orderDetailes) {
                    Total = Total + orderDetaile.getAmount();
                    if (orderDetaile.isITBIS()) 
                        itebisTotal = itebisTotal + (orderDetaile.getAmount() * 0.18);

            }
            
            
            this.ObjectOrder.add(idOrder, idEmploye, idTable, idCustomer, date, Total, itebisTotal, Total*0.15, "Pedido", false);
            
            
            for (OrderDetail orderDetaile : this.orderDetailes) {
                this.ObjectOrderD.add(orderDetaile.getIdOrder(), 0, orderDetaile.getIdProduct(), orderDetaile.getQuantity(), orderDetaile.getProductPrice(), orderDetaile.getAmount(), orderDetaile.getItbisAmount(), orderDetaile.isITBIS());
            }
             JOptionPane.showMessageDialog(new JFrame(), "Agregando", "Nice",
            JOptionPane.INFORMATION_MESSAGE);
            clear();
            
           // setAutoIdPedido();
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(new JFrame(), e, "Upss..",
            JOptionPane.ERROR_MESSAGE);
        }
        
       
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_subtotalActionPerformed

    private void btn_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyActionPerformed
       
        
        
        try {
            int idOrder = Integer.parseInt(this.txt_idOrder.getText());
            int idCustomer = Integer.parseInt(this.txt_idCustomer.getText());
            int idTable = ((Table) this.jc_Table.getSelectedItem()).getIdTable();
            int idEmploye = ((Employe)this.jc_employe.getSelectedItem()).getIdEmploye();
            
            Date date = new Date();
            
            double subtotal = Double.parseDouble(this.txt_subtotal.getText());
            double itbistotal = Double.parseDouble(this.txt_totalItbis.getText());
            double balance = Double.parseDouble(this.txt_balance.getText());
            double neto = Double.parseDouble(this.txt_totalneto.getText());
            
            this.ObjectOrder.modify(idOrder, idEmploye, idTable, idCustomer, date, neto, itbistotal, balance);
            for (OrderDetail orderDetaile : orderDetailes) {
                this.ObjectOrderD.modify(orderDetaile.getIdOrder(), 0, orderDetaile.getIdProduct(), orderDetaile.getQuantity(), orderDetaile.getProductPrice(), orderDetaile.getAmount(), orderDetaile.getItbisAmount(), orderDetaile.isITBIS());
                
            }
           
              JOptionPane.showMessageDialog(new JFrame(), "Correctamente modificado", "Modificado",
            JOptionPane.INFORMATION_MESSAGE);
              this.tmo.initTable(jt_Orders);
                 clear();
        } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(new JFrame(), e, "Upss..",
            JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_btn_modifyActionPerformed

    private void txt_idCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Header;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_modify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jc_Table;
    private javax.swing.JComboBox<String> jc_employe;
    private javax.swing.JRadioButton jr_ITBIS;
    private javax.swing.JTable jt_Orders;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JTextField txt_balance;
    private javax.swing.JTextField txt_idCustomer;
    private javax.swing.JTextField txt_idOrder;
    private javax.swing.JTextField txt_idProduct;
    private javax.swing.JTextField txt_maxQuantity;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_totalCalculate;
    private javax.swing.JTextField txt_totalItbis;
    private javax.swing.JTextField txt_totalneto;
    // End of variables declaration//GEN-END:variables
}
