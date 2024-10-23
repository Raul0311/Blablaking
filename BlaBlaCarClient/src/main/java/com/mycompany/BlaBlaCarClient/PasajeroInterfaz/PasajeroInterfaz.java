package com.mycompany.BlaBlaCarClient.PasajeroInterfaz;

import BlaBlaCarProtocol.BlaBlaCarProtocol;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author maite
 */
public class PasajeroInterfaz extends javax.swing.JFrame {
    String login;
    /**
     * Creates new form PasajeroInterfaz
     */
    public PasajeroInterfaz(String login) {
        initComponents();
        this.login = login;
        
        this.jLabelLogo.setIcon(new ImageIcon(".\\img\\logo.jpeg")); 
        this.jLabelLogo.setBounds(100, 100, 30, 30);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBlablaKing = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jComboBoxOrigen = new javax.swing.JComboBox<>();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabelOrigen = new javax.swing.JLabel();
        jLabelDestino = new javax.swing.JLabel();
        jTextFieldNumAsientos = new javax.swing.JTextField();
        jLabelNumAsientos = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jLabelCalendar = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelBlablaKing.setText("Blabla King");

        jLabelLogo.setText("jLabel2");

        jComboBoxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Granada", "Sevilla", "Alicante" }));
        jComboBoxOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrigenActionPerformed(evt);
            }
        });

        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sevilla", "Granada", "Madrid" }));

        jLabelOrigen.setText("Origen:");

        jLabelDestino.setText("Destino:");

        jTextFieldNumAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumAsientosActionPerformed(evt);
            }
        });

        jLabelNumAsientos.setText("Nº Asientos: ");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabelBlablaKing, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jButtonBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabelNumAsientos)
                                .addGap(9, 9, 9)
                                .addComponent(jTextFieldNumAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jLabelCalendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBlablaKing, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOrigen)
                    .addComponent(jLabelDestino)
                    .addComponent(jTextFieldNumAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumAsientos))
                .addGap(56, 56, 56)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jButtonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooserCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserCalendarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserCalendarioMouseClicked

    private void jDateChooserCalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserCalendarioPropertyChange
      
        //PARA PODER SACAR LA FECHA EN FORMATO STRING :
        /*if ("date".equals(evt.getPropertyName())) { 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(this.jDateChooser1.getDate());
            //System.out.println("date:"+ date);
        }else{
            JOptionPane.showMessageDialog(null, "Inserte una fecha por favor");
        }*/
    }//GEN-LAST:event_jDateChooserCalendarioPropertyChange

    private void jComboBoxOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOrigenActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String origen = this.jComboBoxOrigen.getSelectedItem().toString();
        String destino = this.jComboBoxDestino.getSelectedItem().toString();
        String numAsientos = this.jTextFieldNumAsientos.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(this.jDateChooser1.getDate());
        
        BlaBlaCarProtocol.realizarBusquedaReservas(origen, destino, numAsientos, date, login);
        
        //System.out.println(origen + " " + destino + " " + numAsientos + " " + date);
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldNumAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumAsientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumAsientosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JComboBox<String> jComboBoxOrigen;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabelBlablaKing;
    private javax.swing.JLabel jLabelCalendar;
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNumAsientos;
    private javax.swing.JLabel jLabelOrigen;
    private javax.swing.JTextField jTextFieldNumAsientos;
    // End of variables declaration//GEN-END:variables
}
