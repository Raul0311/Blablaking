/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.blablacarclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raulr
 */
public class BlaBlaCarClient {
    private static final String HOSTNAME = "192.168.0.111";
    private static final int PORTNUMBER = 6666;
    
    private static Socket BBCSOCKET;
    private static PrintWriter OUT;
    private static BufferedReader IN;
    
    
    public byte[] obtenerBytes() {
        String fromServer = null;
        String[] mensajes = new String[5];
        for(int i = 0; i < mensajes.length; i++)
            mensajes[i] = "";
        byte[] bytesTotales = null, bytesRecibidos = null;
        int contadorBytes = 0;
        boolean fotoEntera = false;
        while(!mensajes[4].equals("ENDING_MULTIMEDIA_TRANSMISSION")) {
            try {
                fromServer = IN.readLine();
                System.out.println("Server: " + fromServer);

                mensajes = fromServer.split("#");
                if(!mensajes[4].equals("ENDING_MULTIMEDIA_TRANSMISSION")) {
                    if(bytesTotales == null)
                        bytesTotales = new byte[Integer.parseInt(mensajes[6])];

                    bytesRecibidos = Base64.getDecoder().decode(mensajes[8]);

                    for(int i = 0; i < bytesRecibidos.length && !fotoEntera; i++) {
                        bytesTotales[contadorBytes] = bytesRecibidos[i];
                        contadorBytes++;

                        if(contadorBytes == bytesTotales.length)
                            fotoEntera = true;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(BlaBlaCarClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return bytesTotales;
    }
    
    public String obtenerFotografia() {
        String fromServer = null;
        try {
            fromServer = IN.readLine();
            System.out.println("Server: " + fromServer);
        } catch (IOException ex) {
            Logger.getLogger(BlaBlaCarClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return fromServer;
    }
    
    public String obtenerDetallesViaje(String fromUser) {
        String fromServer = null, mensajeAdevolver = null;
        String[] mensajes;
        byte[] bytesTotales = null;
        
        try {
            OUT.println(fromUser);
            System.out.println("Client: " + fromUser);
            
            fromServer = IN.readLine();
            System.out.println("Server: " + fromServer);
        } catch (IOException ex) {
            Logger.getLogger(BlaBlaCarClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fromServer;
    }
    
    public void cerrarSesion(String fromUser) {
        OUT.println(fromUser);
        System.out.println("Client: " + fromUser);
        
        try {
            OUT.close();
            IN.close();
            BBCSOCKET.close();
        } catch (IOException ex) {
            Logger.getLogger(BlaBlaCarClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String enviarMensaje(String fromUser) {
        String fromServer = null;
        
        try {
            OUT.println(fromUser);
            System.out.println("Client: " + fromUser);
            fromServer = IN.readLine();
            System.out.println("Server: " + fromServer);
        } catch (IOException ex) {
            Logger.getLogger(BlaBlaCarClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fromServer;
    }
    
    public void iniciarCliente() {
        try {
            BBCSOCKET = new Socket(HOSTNAME, PORTNUMBER);
            OUT = new PrintWriter(BBCSOCKET.getOutputStream(), true);
            IN = new BufferedReader(
                new InputStreamReader(BBCSOCKET.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + HOSTNAME);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                HOSTNAME);
            System.exit(1);
        }
    }
}
