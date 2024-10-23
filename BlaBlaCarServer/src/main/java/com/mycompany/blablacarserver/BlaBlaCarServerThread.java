/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blablacarserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author raulr
 */
public class BlaBlaCarServerThread extends Thread {
    private Socket socket = null;
    private final InterfazServer interfaz;
    private PrintWriter out;
    private BufferedReader in;
    private String inputLine;
    private BlaBlaCarProtocol BBCP;
    private boolean terminar = false;
 
    public BlaBlaCarServerThread(Socket socket, InterfazServer interfaz) {
        super("BlaBlaMultiServerThread");
        this.socket = socket;
        this.interfaz = interfaz;
    }
    
    public void cerrarSesion() {
        terminar = true;
    }
    
    public void enviarMensaje(String theOutput) {
        out.println(theOutput);
    }
    
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            BBCP = new BlaBlaCarProtocol(interfaz, this);
            
            while (!terminar && (inputLine = in.readLine()) != null) {
                BBCP.processInput(inputLine);
                interfaz.mensajeConsola("Cliente con ip : " + this.socket.getInetAddress() + " me ha escrito " + inputLine);
            }
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
