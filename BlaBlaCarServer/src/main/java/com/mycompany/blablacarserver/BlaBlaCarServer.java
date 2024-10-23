/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.blablacarserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raulr
 */
public class BlaBlaCarServer extends Thread {
    private static ArrayList<BlaBlaCarServerThread> hebrasClientes;
    private final int portNumber;
    private final boolean listening;
    private final InterfazServer interfaz;
    private ServerSocket serverSocket;
    
    public void cerrarServidor() {
        if(!hebrasClientes.isEmpty()) {
            for(BlaBlaCarServerThread hebraCliente : hebrasClientes) {
                hebraCliente.cerrarSesion();
                
                /*try {
                    hebraCliente.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BlaBlaCarServer.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(BlaBlaCarServer.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(BlaBlaCarServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public BlaBlaCarServer(int portNumber, InterfazServer interfaz) {
        hebrasClientes = new ArrayList();
        this.portNumber = portNumber;
        listening = true;
        this.interfaz = interfaz;
    }
    
    public void run() {
        try {
            serverSocket = new ServerSocket(portNumber);
            interfaz.mensajeConsola("Servidor iniciado");
            while (listening) {
                Socket cliente = serverSocket.accept();
                BlaBlaCarServerThread hebraCliente = new BlaBlaCarServerThread(cliente, interfaz); 
                hebrasClientes.add(hebraCliente); 
                hebraCliente.start(); 
                interfaz.mensajeConsola("Se ha conectado un nuevo cliente, ip : " + cliente.getInetAddress().toString());
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
