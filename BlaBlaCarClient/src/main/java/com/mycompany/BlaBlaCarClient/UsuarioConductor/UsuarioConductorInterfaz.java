/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.BlaBlaCarClient.UsuarioConductor;

import com.mycompany.BlaBlaCarClient.BlaBlaCarProtocol.BlaBlaCarProtocol;
import com.mycompany.BlaBlaCarClient.UsuarioInterfaz.UserInterface;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maite
 */
public class UsuarioConductorInterfaz extends javax.swing.JFrame {
    private final String[] mensajes;
    
    private final DefaultTableModel tabla;
    
    private final BlaBlaCarProtocol protocolo;
    /**
     * Creates new form UsuarioConductorInterfaz
     * @param mensajes
     */
    public UsuarioConductorInterfaz(String[] mensajes) {
        initComponents();
        
        this.mensajes = mensajes;
        tabla = (DefaultTableModel) this.jTableViajesOfertados.getModel();
        tabla.setRowCount(0);
        
        this.protocolo = new BlaBlaCarProtocol();
        
        mostrarViajes();
    }
    
    public final void mostrarViajes() {
        String[] viajes = new String[mensajes.length - 12], fila = new String[4];
        int k = 0;
        for(int i = 12; i < mensajes.length; i++) {
            viajes[k] = mensajes[i];
            k++;
        }
        
        if(viajes[0].equals(" ")) {
            this.noHayViajes();
        } else {
            int j = 0;
            for(int i = 0; i < Integer.parseInt(mensajes[11]); i++) {
                fila[0] = mensajes[8];

                fila[1] = viajes[j + 1];

                fila[2] = viajes[j + 2];
                
                fila[3] = viajes[j + 8];
                j += 10;
                tabla.addRow(fila);
            }
        }
    }
    
    public void noHayViajes() {
        JOptionPane.showMessageDialog(null, "No dispones de viajes ofertados");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelViajesOfertados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableViajesOfertados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelViajesOfertados.setText("Viajes ofertados");

        jTableViajesOfertados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Coche", "Origen", "Destino", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTableViajesOfertados);

        jButton1.setText("Cerrar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabelViajesOfertados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabelViajesOfertados))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        protocolo.cerrarSesion();
        dispose();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelViajesOfertados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableViajesOfertados;
    // End of variables declaration//GEN-END:variables
}
