/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.views.maintenances;

import com.restaurant.classes.Table;
import com.restaurant.tablemodels.TableModelsTables;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class MainTables extends javax.swing.JInternalFrame {

    /**
     * Creates new form MainTables
     */
    TableModelsTables tmt = new TableModelsTables();
    Table tb ;
    public MainTables() {
        initComponents();
        this.tb = new Table();
        this.tb.readFile();
        tmt.initTable(tb_tables);
    }

    
    public void clear(){
        this.txt_id.setText("");
        this.txt_cantComersales.setText("");
        this.txt_maxComersales.setText("");
        this.txt_numTable.setText("");
    }
    
    public void Search(){
        int id = 0;
        boolean found = false;
        
        try {
            if (!this.txt_id.getText().isEmpty()) {
                 id =Integer.parseInt( this.txt_id.getText());   
            }
             
          for (Table table : this.tb.getTables()) {
              if (table.getIdTable()== id) {
               this.jr_true.setEnabled(true);
               this.txt_cantComersales.setEnabled(true);
                this.btn_Add.setEnabled(false);
                this.btn_Modify.setEnabled(true);
                this.txt_cantComersales.setText(String.valueOf(table.getCantComersales()));
                this.txt_maxComersales.setText(String.valueOf(table.getMaxComersales()));
                this.txt_numTable.setText(String.valueOf(table.getNumTables()));
                this.jr_true.setSelected(table.isState());
                found = true;
                break;
              }
          }
            
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        if (!found) {
              this.btn_Add.setEnabled(true);
               this.txt_cantComersales.setEnabled(false);

              
                this.btn_Modify.setEnabled(false);
                this.txt_cantComersales.setText("");
                this.txt_maxComersales.setText("");
                this.txt_numTable.setText("");
                this.jr_true.setEnabled(false);
            
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jr_true = new javax.swing.JRadioButton();
        jr_false = new javax.swing.JRadioButton();
        btn_Add = new javax.swing.JButton();
        btn_Modify = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        txt_maxComersales = new javax.swing.JTextField();
        txt_cantComersales = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_numTable = new javax.swing.JTextField();
        Body = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_tables = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Id");

        jLabel2.setText("Max Comersales");

        jLabel3.setText("Cantidad Comersales");

        jLabel4.setText("Status");

        buttonGroup1.add(jr_true);
        jr_true.setText("True");
        jr_true.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_trueActionPerformed(evt);
            }
        });

        buttonGroup1.add(jr_false);
        jr_false.setSelected(true);
        jr_false.setText("False");

        btn_Add.setText("Agregar");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_Modify.setText("Modificar");
        btn_Modify.setEnabled(false);
        btn_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifyActionPerformed(evt);
            }
        });

        btn_Delete.setText("Eliminar");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idKeyReleased(evt);
            }
        });

        txt_cantComersales.setEnabled(false);

        jLabel5.setText("Num Mesa");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_id)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel4))
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cantComersales, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_maxComersales, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jr_true)
                                .addGap(6, 6, 6)
                                .addComponent(jr_false))
                            .addGroup(HeaderLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_numTable)))
                        .addGap(28, 28, 28))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(btn_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Modify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Delete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jr_true)
                    .addComponent(jr_false)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_maxComersales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_numTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_cantComersales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Add)
                    .addComponent(btn_Modify)
                    .addComponent(btn_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_tables.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_tables);

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
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

    private void jr_trueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_trueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jr_trueActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed

         if (this.txt_id.getText().isEmpty() || this.txt_maxComersales.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos en Blanco", "Mensaje", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        this.tb.add(Integer.parseInt(this.txt_id.getText()), Integer.parseInt(this.txt_maxComersales.getText()), 0, Integer.parseInt(this.txt_numTable.getText()));
        
        this.tmt.initTable(tb_tables);
         JOptionPane.showMessageDialog(new JFrame(), "Guardado.", "Nice",
        JOptionPane.INFORMATION_MESSAGE);

        clear();
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
       System.out.println(this.tb_tables.getSelectedRow());
        try {
            this.tb.delete(this.tb_tables.getSelectedRow());
            this.tmt.initTable(tb_tables);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(new JFrame(), "Select a row PLEASE.", "Upss..",
        JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifyActionPerformed
        if (this.txt_id.getText().isEmpty() || this.txt_maxComersales.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos en Blanco", "Mensaje", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        
        if (Integer.parseInt(this.txt_maxComersales.getText()) < Integer.parseInt(this.txt_cantComersales.getText())) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser menor o igual que la maxima", "Upps..", JOptionPane.ERROR_MESSAGE); 
            return;
            
        }
        this.tb.modify(Integer.parseInt(this.txt_id.getText()), Integer.parseInt(this.txt_maxComersales.getText()), Integer.parseInt(this.txt_cantComersales.getText()), Integer.parseInt(this.txt_numTable.getText()), this.jr_true.isSelected());
        this.tmt.initTable(tb_tables);
        JOptionPane.showMessageDialog(new JFrame(), "Modificando.", "Nice",
        JOptionPane.INFORMATION_MESSAGE);

        //clear();
    }//GEN-LAST:event_btn_ModifyActionPerformed

    private void txt_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyReleased
        Search();
    }//GEN-LAST:event_txt_idKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Header;
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Modify;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jr_false;
    private javax.swing.JRadioButton jr_true;
    private javax.swing.JTable tb_tables;
    private javax.swing.JTextField txt_cantComersales;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_maxComersales;
    private javax.swing.JTextField txt_numTable;
    // End of variables declaration//GEN-END:variables
}