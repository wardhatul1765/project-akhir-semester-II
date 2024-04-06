/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package base;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author user
 */
public class menu_item extends javax.swing.JPanel {

    /**
     * Creates new form menu_item
     */
    
    public ArrayList<menu_item> getSubMenu() {
        return subMenu;
    }
    
    private final ArrayList<menu_item> subMenu = new  ArrayList<>();
    
    private ActionListener act;
    
    public menu_item(Icon icon, boolean sbm, Icon iconSub, String MenuName, ActionListener act, menu_item... subMenu) {
        initComponents();
        
        lb_icon.setIcon(icon);
        lb_MenuName.setText(MenuName);
        lb_iconSub.setIcon(iconSub);
        lb_iconSub.setVisible(sbm);
        
        
        if (act != null) {
            this.act = act;
        }
        
        this.setSize(new Dimension(Integer.MAX_VALUE,50));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        this.setMinimumSize(new Dimension(Integer.MIN_VALUE, 50));
        for (int i = 0; i < subMenu.length; i++) {
           this.subMenu.add(subMenu[i]);
           subMenu[i].setVisible(false);
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

        lb_MenuName = new javax.swing.JLabel();
        lb_iconSub = new javax.swing.JLabel();
        lb_icon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lb_MenuName.setText("menu_item");
        lb_MenuName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_MenuNameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_MenuNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_MenuNameMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_MenuNameMousePressed(evt);
            }
        });

        lb_iconSub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_iconSubMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_iconSubMouseExited(evt);
            }
        });

        lb_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_iconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_iconSub, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_MenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_MenuName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lb_iconSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    setBackground(new java.awt.Color(0,102,153));
    if (showing) {
        hidemenu();
    } else {
        showMenu();
    }
    if (act != null) {
        act.actionPerformed(null);
    }
    

        
    }//GEN-LAST:event_formMousePressed

    private void lb_MenuNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MenuNameMouseEntered
        // TODO add your handling code here: 
            setBackground(new java.awt.Color(0,102,153));
    // Ubah warna teks saat mouse masuk
    lb_MenuName.setForeground(new java.awt.Color(255, 255, 255));
    
    }//GEN-LAST:event_lb_MenuNameMouseEntered

    private void lb_MenuNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MenuNameMouseExited
        // TODO add your handling code here:
          // Kembalikan warna latar belakang saat mouse keluar
    setBackground(new java.awt.Color(255, 255, 255)); // Ganti dengan warna latar belakang asli
    // Kembalikan warna teks saat mouse keluar
    lb_MenuName.setForeground(new java.awt.Color(0, 0, 0)); // Ganti dengan warna teks asli
    }//GEN-LAST:event_lb_MenuNameMouseExited

    private void lb_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_iconMouseEntered
        // TODO add your handling code here:
            // Ubah warna ikon saat mouse masuk
    lb_icon.setForeground(new java.awt.Color(255, 255, 255)); // Ganti dengan warna
    }//GEN-LAST:event_lb_iconMouseEntered

    private void lb_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_iconMouseExited
        // TODO add your handling code here:
           lb_icon.setForeground(new java.awt.Color(0, 0, 0)); // Ganti dengan warna ikon asli
    }//GEN-LAST:event_lb_iconMouseExited

    private void lb_iconSubMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_iconSubMouseEntered
        // TODO add your handling code here:
            lb_iconSub.setForeground(new java.awt.Color(255, 255, 255)); // Ganti dengan warna ikon submenu ya
    }//GEN-LAST:event_lb_iconSubMouseEntered

    private void lb_iconSubMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_iconSubMouseExited
        // TODO add your handling code here:
           lb_iconSub.setForeground(new java.awt.Color(0, 0, 0)); // Ganti dengan warna ikon submenu asli
    }//GEN-LAST:event_lb_iconSubMouseExited

    private void lb_MenuNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MenuNameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_MenuNameMousePressed

    private void lb_MenuNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MenuNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_MenuNameMouseClicked

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        setBackground(new java.awt.Color(255, 255, 255)); 
        
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_MenuName;
    private javax.swing.JLabel lb_icon;
    private javax.swing.JLabel lb_iconSub;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the subMenu
     */

    private void hidemenu() {
        new Thread(new Runnable() {
            
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hidemenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
        
    }

    private void showMenu() {
    new Thread(new Runnable() {
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(true);
                    subMenu.get(i).hidemenu();
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
                
            }
        }).start();    
    }
    
    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            
        }
    }
}