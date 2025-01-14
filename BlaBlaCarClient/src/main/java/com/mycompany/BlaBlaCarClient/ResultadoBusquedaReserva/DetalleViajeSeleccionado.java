/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.BlaBlaCarClient.ResultadoBusquedaReserva;

import com.mycompany.BlaBlaCarClient.BlaBlaCarProtocol.BlaBlaCarProtocol;
import com.mycompany.BlaBlaCarClient.InterfazUsuarioComun.InterfazUsuarioComun;
import com.mycompany.BlaBlaCarClient.InterfazUsuarioComun.Viaje;
import com.mycompany.blablacarclient.BlaBlaCarClient;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author maite
 */
public class DetalleViajeSeleccionado extends javax.swing.JFrame {
    private final String[] detalles;
    private final byte[] foto;
    private final BlaBlaCarClient cliente;
    private BlaBlaCarProtocol protocolo;
    private Viaje viaje;
    /**
     * Creates new form DetalleViajeSeleccionado
     * @param detalles
     * @param foto
     * @param cliente
     */
    public DetalleViajeSeleccionado(String[] detalles, byte[] foto, BlaBlaCarClient cliente, Viaje viaje) {
        initComponents();
        
        this.detalles = detalles;
        this.foto = foto;
        this.cliente = cliente;
        this.protocolo = new BlaBlaCarProtocol();
        this.viaje = viaje;
        
        mostrarDetalles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFechaLlegada = new javax.swing.JLabel();
        jLabelHoraLlegada = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelFechaSalida = new javax.swing.JLabel();
        jLabelHoraSalida = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAsientosReserva = new javax.swing.JLabel();
        jTextFieldAsientosReserva = new javax.swing.JTextField();
        jButtonReservar = new javax.swing.JButton();
        jLabelFecha_llegada = new javax.swing.JLabel();
        jLabelprecio = new javax.swing.JLabel();
        jLabelHora_llegada = new javax.swing.JLabel();
        jLabelFecha_salida = new javax.swing.JLabel();
        jLabelHora_salida = new javax.swing.JLabel();
        jLabelnombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelFechaLlegada.setText("Fecha de  Llegada:");

        jLabelHoraLlegada.setText("Hora de Llegada: ");

        jLabelPrecio.setText("Precio:");

        jLabelFechaSalida.setText("Fecha de Salida:");

        jLabelHoraSalida.setText("Hora de Salida: ");

        jLabelNombre.setText("Nombre: ");

        jLabelAsientosReserva.setText("Asientos reserva: ");

        jTextFieldAsientosReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAsientosReservaActionPerformed(evt);
            }
        });

        jButtonReservar.setText("Reservar");
        jButtonReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservarActionPerformed(evt);
            }
        });

        jLabelFecha_llegada.setText("jLabel1");

        jLabelprecio.setText("jLabel1");

        jLabelHora_llegada.setText("jLabel1");

        jLabelFecha_salida.setText("jLabel1");

        jLabelHora_salida.setText("jLabel1");

        jLabelnombre.setText("jLabel1");

        jLabel1.setText("jLabel1");

        jButton1.setText("Volver");
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
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addComponent(jLabelFecha_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHora_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelHoraLlegada)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHora_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jButtonReservar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAsientosReserva)
                        .addGap(27, 27, 27)
                        .addComponent(jTextFieldAsientosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaLlegada)
                    .addComponent(jLabelFechaSalida)
                    .addComponent(jLabelFecha_llegada)
                    .addComponent(jLabelFecha_salida))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoraLlegada)
                    .addComponent(jLabelHoraSalida)
                    .addComponent(jLabelHora_llegada)
                    .addComponent(jLabelHora_salida))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNombre)
                        .addComponent(jLabelnombre))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPrecio)
                        .addComponent(jLabelprecio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAsientosReserva)
                    .addComponent(jTextFieldAsientosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReservar))
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAsientosReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAsientosReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAsientosReservaActionPerformed

    private void jButtonReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservarActionPerformed
        int numReservas;
        numReservas = Integer.parseInt(this.jTextFieldAsientosReserva.getText());
        
        String[] mensajes = protocolo.realizarReserva(numReservas, viaje);
        
        if(mensajes[4].equals("ERROR")) {
            JOptionPane.showMessageDialog(null, "Ha habido un error con la realización de las reservas");
        } else if(mensajes[4].equals("WARNING")) {
            JOptionPane.showMessageDialog(null, "El vehículo no dispone de estas plazas, quedan " + mensajes[6] + " asientos disponibles");
        } else if(mensajes[4].equals("BOOK_COMPLETED")) {
            JOptionPane.showMessageDialog(null, "Se ha realizado la reserva correctamente");
        }
    }//GEN-LAST:event_jButtonReservarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(InterfazUsuarioComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazUsuarioComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazUsuarioComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazUsuarioComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazUsuarioComun(cliente).setVisible(true);
            }
        });
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public final void mostrarDetalles() {
        this.jLabelnombre.setText(detalles[5]);
        this.jLabelFecha_salida.setText(detalles[14]);
        this.jLabelHora_salida.setText(detalles[15]);
        this.jLabelFecha_llegada.setText(detalles[16]);
        this.jLabelHora_llegada.setText(detalles[17]);
        this.jLabelprecio.setText(detalles[19]);
        if(foto != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(foto));

                ImageIcon icono = new ImageIcon(bufferedImage.getScaledInstance(this.jLabel1.getWidth(), this.jLabel1.getHeight(), Image.SCALE_DEFAULT));
                this.jLabel1.setIcon(icono);
            } catch (IOException ex) {
                Logger.getLogger(DetalleViajeSeleccionado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonReservar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAsientosReserva;
    private javax.swing.JLabel jLabelFechaLlegada;
    private javax.swing.JLabel jLabelFechaSalida;
    private javax.swing.JLabel jLabelFecha_llegada;
    private javax.swing.JLabel jLabelFecha_salida;
    private javax.swing.JLabel jLabelHoraLlegada;
    private javax.swing.JLabel jLabelHoraSalida;
    private javax.swing.JLabel jLabelHora_llegada;
    private javax.swing.JLabel jLabelHora_salida;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelnombre;
    private javax.swing.JLabel jLabelprecio;
    private javax.swing.JTextField jTextFieldAsientosReserva;
    // End of variables declaration//GEN-END:variables
}
