/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.views.maintenances;

import com.restaurant.classes.Customer;
import com.restaurant.classes.Reservation;
import com.restaurant.classes.Table;
import com.restaurant.combo.ItemRenderCustomer;
import com.restaurant.combo.ItemRenderTable;
import com.restaurant.tablemodels.TableModelsReservations;
import com.restaurant.views.MainApp;
import java.awt.HeadlessException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public final class MainReservation extends javax.swing.JInternalFrame {

    /**
     * Creates new form MainReservation
     */
    
  
    Reservation reservation;
    TableModelsReservations tmr = new TableModelsReservations();
    public MainReservation() {
        this.reservation = new Reservation();
        reservation.readFile();
        initComponents();
       
        setComboTable();
        setComboCustomer();
        this.tmr.initTable(jt_Reservations);
        JD_date.setDateFormatString("dd/MM/yyyy");
    }
    
    public void clear(){
        this.txt_Co.setText("");
        this.txt_id.setText("");
        this.JD_date.setDate(null);
    }

   
    private void search(){
        int id = 0;
        boolean found = false;
        
        try {
            if (!this.txt_id.getText().isEmpty()) {
                 id =Integer.parseInt( this.txt_id.getText());   
            }
             
            
          Table table = new Table();
          table.readFile();
          for (Reservation reservation1 : this.reservation.getReservations()) {
              if (reservation1.getIdReservation()== id ) {
                this.jr_true.setEnabled(true);
                this.btn_Add.setEnabled(false);
                this.btn_Modify.setEnabled(true);
                  for (Table table1 : table.getTables()) {
                      if (table1.getIdTable() == reservation1.getIdTable()) {
                           this.txt_Co.setText(String.valueOf(table1.getCantComersales()));
                      }
                  }
               
               // MainReservation.jc_table.setSelectedIndex(1);
                this.JD_date.setDate(reservation1.getDateReservation());
                
                found = true;
                break;
              }
          }
            
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        if (!found) {
              this.btn_Add.setEnabled(true);
               

              
                this.btn_Modify.setEnabled(false);
                this.txt_Co.setText("");
                this.JD_date.setDate(null);
                this.jr_true.setEnabled(false);
            
        }
        
    }
    
    public static void setComboTable(){
        DefaultComboBoxModel value;   
        value =new DefaultComboBoxModel();
        
          Table table = new Table();
          table.readFile();
    
        jc_table.setModel(value);
        for (Table table1 : table.getTables()) {
            if (!table1.isState()) 
                value.addElement(new Table(table1.getIdTable(), table1.getNumTable())); 
            
        } 
        if (value.getSize() == 0) {
            value.addElement( new Table(0,  0) );    
        }
        jc_table.setRenderer(new ItemRenderTable());
    }
    
    public static void setComboCustomer(){
        DefaultComboBoxModel value;   
        value =new DefaultComboBoxModel();
        Customer customer = new Customer();
        customer.readFile();
        jc_customer.setModel(value);
        for (Customer customer1 : customer.getCustomers()) {
            value.addElement(new Customer(customer1.getIdCustomer(), customer1.getName()));  
        } 
        if (value.getSize() == 0) {
            value.addElement( new Customer(0,  "Empty") );    
        }
        jc_customer.setRenderer(new ItemRenderCustomer());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Head = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jr_true = new javax.swing.JRadioButton();
        jr_false = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jc_table = new javax.swing.JComboBox<>();
        jc_customer = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_Co = new javax.swing.JTextField();
        add_Table = new javax.swing.JLabel();
        add_customer = new javax.swing.JLabel();
        JD_date = new com.toedter.calendar.JDateChooser();
        Middle = new javax.swing.JPanel();
        btn_Add = new javax.swing.JButton();
        btn_Modify = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        Body = new javax.swing.JPanel();
        JScrollPane = new javax.swing.JScrollPane();
        jt_Reservations = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Id");

        jLabel2.setText("Mesa");

        jLabel3.setText("Cliente");

        jLabel4.setText("Estado");

        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idKeyReleased(evt);
            }
        });

        buttonGroup1.add(jr_true);
        jr_true.setText("True");

        buttonGroup1.add(jr_false);
        jr_false.setSelected(true);
        jr_false.setText("False");

        jLabel5.setText("Fecha");

        jc_table.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jc_customer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Cantidad Comersales");

        add_Table.setText("+");
        add_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_TableMouseClicked(evt);
            }
        });

        add_customer.setText("+");
        add_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_customerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HeadLayout = new javax.swing.GroupLayout(Head);
        Head.setLayout(HeadLayout);
        HeadLayout.setHorizontalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeadLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jr_true)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jr_false)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(HeadLayout.createSequentialGroup()
                        .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(HeadLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jc_customer, 0, 90, Short.MAX_VALUE))
                            .addGroup(HeadLayout.createSequentialGroup()
                                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(25, 25, 25)
                                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id)
                                    .addComponent(jc_table, 0, 91, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HeadLayout.createSequentialGroup()
                                .addComponent(add_Table)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(HeadLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Co, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(HeadLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JD_date, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(add_customer))))
                .addContainerGap())
        );
        HeadLayout.setVerticalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(JD_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jc_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_Co, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_Table))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jc_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_customer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jr_true)
                    .addComponent(jr_false))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Middle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Middle.setLayout(new java.awt.GridLayout(1, 0));

        btn_Add.setText("Registrar");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        Middle.add(btn_Add);

        btn_Modify.setText("Modificar");
        btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifyActionPerformed(evt);
            }
        });
        Middle.add(btn_Modify);

        btn_Delete.setText("Eliminar");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        Middle.add(btn_Delete);

        jt_Reservations.setModel(new javax.swing.table.DefaultTableModel(
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
        JScrollPane.setViewportView(jt_Reservations);

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Middle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Middle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed

        try {
            if (this.txt_id.getText().isEmpty() || this.txt_Co.getText().isEmpty() || this.JD_date.getDate().toString().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Campos en blanco.", "OPss..",
                JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if (((Customer)MainReservation.jc_customer.getSelectedItem()).getIdCustomer() == 0 || ((Table)MainReservation.jc_table.getSelectedItem()).getIdTable() == 0) {
                JOptionPane.showMessageDialog(new JFrame(), "En caso de no existir clientes o mesas disponible ingrese nuevos o libere una mesa.", "OPss..",
                JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
             int idTable = ((Table)MainReservation.jc_table.getSelectedItem()).getIdTable();
             
             boolean isMax = false;
             Table t = new Table();
             t.readFile();
            for (Table table : t.getTables()) {
                if (table.getIdTable() == idTable) {
                    if (table.getMaxComersales() < Integer.parseInt(this.txt_Co.getText())) {
                        isMax = true;
                        break;
                    }else{
                        table.setCantComersales(Integer.parseInt(this.txt_Co.getText()));
                        break;
                    }
                    
                }
            }
            t.writeFile();
           
            if (!isMax) {
                this.reservation.add(Integer.parseInt(this.txt_id.getText()), ((Customer)MainReservation.jc_customer.getSelectedItem()).getIdCustomer() ,idTable, this.JD_date.getDate(), this.JD_date.getDate(), this.jr_true.isSelected());
                this.tmr.initTable(jt_Reservations);
                 JOptionPane.showMessageDialog(new JFrame(), "Registrando", "Nice..",
            JOptionPane.INFORMATION_MESSAGE);
                clear();
                return;
                
            }
            
            JOptionPane.showMessageDialog(new JFrame(), "Lo siento pero estas superando la cantidad maxima de comersales", "OPss..",
            JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), e, "OPss..",
            JOptionPane.ERROR_MESSAGE);
            
        }
  
    }//GEN-LAST:event_btn_AddActionPerformed

    private void add_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_TableMouseClicked
      
        MainTables  table = new MainTables();
        MainApp.DesktopPane.add(table);
        table.toFront();
        table.setVisible(true);
        System.out.println("add table...");
    }//GEN-LAST:event_add_TableMouseClicked

    private void add_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_customerMouseClicked
        MainCustomers customer = new MainCustomers();
        MainApp.DesktopPane.add(customer);
        customer.toFront();
        customer.setVisible(true);
        System.out.println("add customer...");
    }//GEN-LAST:event_add_customerMouseClicked

    private void txt_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyReleased
        search();
    }//GEN-LAST:event_txt_idKeyReleased

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
       try {
            this.reservation.delete(this.jt_Reservations.getSelectedRow());
            this.tmr.initTable(jt_Reservations);
           // MainProducts.setComboKind();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Select a row PLEASE.", "Upss..",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifyActionPerformed
        try {
            this.reservation.modify(Integer.parseInt(this.txt_id.getText()), ((Customer)MainReservation.jc_customer.getSelectedItem()).getIdCustomer() ,((Table)MainReservation.jc_table.getSelectedItem()).getIdTable(), this.JD_date.getDate(), this.JD_date.getDate(), this.jr_true.isSelected());
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), e, "Upss..",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ModifyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Head;
    private com.toedter.calendar.JDateChooser JD_date;
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JPanel Middle;
    private javax.swing.JLabel add_Table;
    private javax.swing.JLabel add_customer;
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Modify;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private static javax.swing.JComboBox<String> jc_customer;
    private static javax.swing.JComboBox<String> jc_table;
    private javax.swing.JRadioButton jr_false;
    private javax.swing.JRadioButton jr_true;
    private javax.swing.JTable jt_Reservations;
    private javax.swing.JTextField txt_Co;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
