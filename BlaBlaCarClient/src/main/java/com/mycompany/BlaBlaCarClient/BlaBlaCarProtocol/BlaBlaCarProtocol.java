/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BlaBlaCarClient.BlaBlaCarProtocol;

import com.mycompany.BlaBlaCarClient.InterfazUsuarioComun.Viaje;
import com.mycompany.blablacarclient.BlaBlaCarClient;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raulr
 */
public class BlaBlaCarProtocol {
    private static BlaBlaCarClient cliente;
    private String[] mensajes;
    
    private final DateFormat formatter;
    private final String time;
    private static String hostName, login;
   
    private final String cabecera;
    
    public BlaBlaCarProtocol() {
        this.formatter = new SimpleDateFormat("hh:mm:ss");
        this.time = formatter.format(new Date());
        this.cabecera = "PROTOCOLBBKING1.0#" + LocalDate.now() + "#" + time + "#";
        cliente = new BlaBlaCarClient();
    }
    
    public String[] inicioSesion(String login, String contraseniaUsuario) {
        this.login = login;
        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BlaBlaCarProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String inicioSesion = cabecera + hostName + "#LOGIN#" + this.login + "#" + contraseniaUsuario;
        
        String[] mensajes = this.cliente.enviarMensaje(inicioSesion).split("#");
        
        return mensajes;
    }
    
    public String[] realizarBusquedaViajesOfertados(String[] filtros, BlaBlaCarClient cliente) {
        String theOutput;
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String time = formatter.format(new Date());

        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BlaBlaCarProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }

        theOutput = cabecera + hostName + "#" + login + "#GET_TRAVELS#" + filtros[0] + "#" + filtros[1] + "#" + 
                filtros[2] + "#" + filtros[3] + "#" + filtros[4] + "#" + filtros[5] + "#" + filtros[6];
        
        mensajes = cliente.enviarMensaje(theOutput).split("#");
        
        return mensajes;
    }
    
    public String[] obtenerDetallesViaje(String[] infoViaje) {
        String theOutput;
        
        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BlaBlaCarProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        theOutput = cabecera + hostName + "#" + login + "#GET_DETAIL_TRAVEL#" + infoViaje[0] + "#" + infoViaje[1] + "#" + infoViaje[2] + "#" + infoViaje[3];
        
        mensajes = cliente.obtenerDetallesViaje(theOutput).split("#");
        
        return mensajes;
    }
    
    public byte[] obtenerFoto() {
        byte[] bytes = null;
        if(mensajes[4].equals("GET_DETAIL_TRAVEL_CORRECT")) {
            mensajes = cliente.obtenerFotografia().split("#");
            if(mensajes[4].equals("STARTING_MULTIMEDIA_TRANSMISSION_TO")) {
                bytes = cliente.obtenerBytes();
            }
        }
        
        return bytes;
    }
    
    public void cerrarSesion() {
        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BlaBlaCarProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cliente.cerrarSesion(cabecera + hostName + "#" + login + "#CLOSE_SESSION");
    }
    
    public String[] realizarReserva(int numReservas, Viaje viaje) {
        String theOutput;
        
        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BlaBlaCarProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        theOutput = cabecera + hostName + "#" + login + "#BOOK_PLACE#" + viaje.getId_coche() + "#" + viaje.getTrayecto().getId() + "#" 
                + viaje.getFecha_salida() + "#" + viaje.getHora_salida() + "#" + numReservas;
        
        mensajes = cliente.enviarMensaje(theOutput).split("#");
        
        return mensajes;
    }
}
