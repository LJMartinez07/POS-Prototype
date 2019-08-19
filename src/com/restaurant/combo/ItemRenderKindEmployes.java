/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.combo;

import com.restaurant.classes.KindEmploye;
import com.restaurant.classes.KindProduct;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Luis
 */
public class ItemRenderKindEmployes extends BasicComboBoxRenderer {
        @Override
        public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
            if (value != null)
            {
                KindEmploye item = (KindEmploye)value;
                setText( item.getName() );
            }
            if (index == -1)
            {
                KindEmploye item = (KindEmploye)value;
                setText(item.getName());
            }
            return this;
        }
    
}