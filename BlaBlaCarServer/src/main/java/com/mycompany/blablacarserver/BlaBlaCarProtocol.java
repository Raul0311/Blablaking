/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blablacarserver;

import Controlador.Controlador;
import blablacarHibernate.Coche;
import blablacarHibernate.Reserva;
import blablacarHibernate.Usuario;
import blablacarHibernate.Viaje;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raulr
 */
public class BlaBlaCarProtocol {
    private static String HOSTNAME, LOGIN, IP;
    private final Controlador controlador;
    private final InterfazServer interfaz;
    
    private String[] mensajes;
    private String theOutput = null;
    
    private final DateFormat formatter;
    private final String time;
    
    private final String cabecera;
    
    private List<Viaje> viajesOfertados;
    
    private byte[] bytesImage, bytesPorEnvio;
    private final BlaBlaCarServerThread hebraCliente;
    
    Usuario usuario;
 
    public BlaBlaCarProtocol(InterfazServer interfaz, BlaBlaCarServerThread hebraCliente) {
        this.formatter = new SimpleDateFormat("hh:mm:ss");
        this.time = formatter.format(new Date());
        this.cabecera = "PROTOCOLBBKING1.0#" + LocalDate.now() + "#" + time + "#";
        this.interfaz = interfaz;
        this.controlador = new Controlador();
        this.hebraCliente = hebraCliente;
        
        obtenerIP();
    }
    
    public final void obtenerIP() {
        try {
            HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(BlaBlaCarProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void login() {
        controlador.conectar();
        usuario = controlador.comprobarInicioSesion(mensajes[5]);
        List<Coche> coche = new ArrayList();
        List<Viaje> viajes = new ArrayList();
        if(usuario != null)
            coche = usuario.getCoches();
        
        if(!coche.isEmpty())
            viajes = coche.get(0).getViajes();
        
        theOutput = cabecera + HOSTNAME + "#";
        if(usuario != null) {
            if(usuario.getPassword().equals(mensajes[6])) {
                    LOGIN = usuario.getLogin();
                    IP = mensajes[3];

                    if(usuario.getTipo().equals("P")) {
                        theOutput += "LOGIN_CORRECT#" + usuario.getId() + "#" + usuario.getNombre() + "#" + 
                                usuario.getApellido1() + "#" + usuario.getTipo();
                    } else {
                        theOutput += "LOGIN_CORRECT#" + usuario.getId() + "#" + coche.get(0).getId() + "#" + 
                                coche.get(0).getMatricula() + "#" + coche.get(0).getMarca() + "#" + coche.get(0).getModelo() + "#" + 
                                coche.get(0).getNum_asientos() + "#" + viajes.size();
                        if(!viajes.isEmpty()) {
                            for(int i = 0; i < viajes.size(); i++) {
                                theOutput += "#" + viajes.get(i).getId() + "#" + viajes.get(i).getTrayecto().getOrigen() + "#" + 
                                        viajes.get(i).getTrayecto().getDestino() + "#" + viajes.get(i).getFecha_salida() + "#" + 
                                        viajes.get(i).getHora_salida() + "#" + viajes.get(i).getFecha_llegada() + "#" + viajes.get(i).getHora_llegada() 
                                        + "#" + viajes.get(i).getNum_asientos_ofertados() + "#" + viajes.get(i).getPrecio() + "#" + viajes.get(i).getReservas().size();
                            }
                        } else 
                            theOutput += "# ";
                    }

                interfaz.aniadirUsuario(usuario.getLogin(), usuario.getNombre(), usuario.getApellido1());
            } else {
                theOutput += "ERROR#BAD_CREDENTIALS";
            }
        } else {
            theOutput += "ERROR#BAD_CREDENTIALS";
        }
        
        controlador.desconectar();
        hebraCliente.enviarMensaje(theOutput);
    }
    
    public List<Viaje> comprobarViajesOfertados() {
        List<Viaje> viajesFiltrados = new ArrayList();
        boolean viajeValido;
        for(Viaje viaje : viajesOfertados) {
            viajeValido = true;
            if(!mensajes[6].equals(" ")) {
                if(!viaje.getTrayecto().getOrigen().equals(mensajes[6]) && viajeValido)
                    viajeValido = false;
            }
            if(!mensajes[7].equals(" ")) {
                if(!viaje.getTrayecto().getDestino().equals(mensajes[7]) && viajeValido)
                    viajeValido = false;
            }

            if(!mensajes[8].equals(" ")) {    
                if(!viaje.getFecha_salida().toString().equals(mensajes[8]) && viajeValido)
                    viajeValido = false;
            }
            
            if(!mensajes[9].equals(" ")) {    
                if(!viaje.getHora_salida().toString().equals(mensajes[9]) && viajeValido)
                    viajeValido = false;
            }
            if(!mensajes[10].equals(" ")) {    
                if(!viaje.getFecha_llegada().toString().equals(mensajes[10]) && viajeValido)
                    viajeValido = false;
            }
            
            if(!mensajes[11].equals(" ")) {    
                if(!viaje.getHora_llegada().toString().equals(mensajes[11]) && viajeValido)
                    viajeValido = false;
            }

            if(!mensajes[12].equals(" ")) {  
                float preciof = Float.parseFloat(mensajes[12]);
                BigDecimal precio = new BigDecimal(preciof);

                if(viaje.getPrecio().doubleValue() > precio.doubleValue() && viajeValido)
                    viajeValido = false;
            }

            if(viajeValido)
                viajesFiltrados.add(viaje);
        }
        
        return viajesFiltrados;
    }
    
    public void viajesOfertados() {
        theOutput = cabecera + HOSTNAME + "#";
        if(mensajes[4].equals(LOGIN) && mensajes[3].equals(IP)) {
            controlador.conectar();
            
            viajesOfertados = controlador.getViajes();
            List<Reserva> reservas = controlador.getReservas();
            List<Viaje> viajesFiltrados = this.comprobarViajesOfertados(), viajesDisponibles = new ArrayList();
            boolean maxReservas = false;
            int numReservasResalizadas = 0;
            for(int i = 0; i < viajesFiltrados.size(); i++) {
                numReservasResalizadas = 0;
                maxReservas = false;
                for(int j = 0; j < reservas.size() && !maxReservas; j++) {
                    if(viajesFiltrados.get(i).getId() == reservas.get(j).getViaje().getId()) {
                        numReservasResalizadas++;
                        if(numReservasResalizadas >= viajesFiltrados.get(i).getNum_asientos_ofertados())
                            maxReservas = true;
                    }
                }
                if(!maxReservas)
                    viajesDisponibles.add(viajesFiltrados.get(i));
            }
            
            theOutput += "GET_TRAVELS_CORRECT#";
            if(!viajesDisponibles.isEmpty()) {
                for(Viaje viaje : viajesDisponibles) {
                    theOutput += viaje.getCoche().getId() + "#" + viaje.getTrayecto().getId() + "#" + viaje.getTrayecto().getOrigen() + "#" +
                            viaje.getTrayecto().getDestino() + "#" + viaje.getFecha_salida().toString() + "#" + viaje.getHora_salida().toString()
                            + "#" + viaje.getPrecio().toString() + "#";
                }
            }
            
            controlador.desconectar();
        } else {
            theOutput += "ERROR#BAD_PETITION";
        }
        
        hebraCliente.enviarMensaje(theOutput);
    }
    
    public void detallesViaje() {
        theOutput = cabecera + HOSTNAME + "#";
        if(mensajes[4].equals(LOGIN) && mensajes[3].equals(IP)) {
            controlador.conectar();
            boolean boolViajeEncontrado = false;
            Viaje viajeEncontrado = null;
            for(int i = 0; i < viajesOfertados.size() && !boolViajeEncontrado; i++) {
                if(String.valueOf(viajesOfertados.get(i).getCoche().getId()).equals(mensajes[6]) && 
                        String.valueOf(viajesOfertados.get(i).getTrayecto().getId()).equals(mensajes[7]) && 
                        viajesOfertados.get(i).getFecha_salida().toString().equals(mensajes[8]) && 
                        viajesOfertados.get(i).getHora_salida().toString().equals(mensajes[9]) && !boolViajeEncontrado) {
                    boolViajeEncontrado = true;
                    
                    viajeEncontrado = viajesOfertados.get(i);
                }
            }
            Coche coche = viajeEncontrado.getCoche();
            
            Usuario usuario = coche.getUsuario();
            Period edad = Period.between(usuario.getFecha_nacimiento(), LocalDate.now());
            List<Reserva> reservas = controlador.getReservas();
            int contador = 0;
            for(int i = 0; i < reservas.size(); i++) {
                if(viajeEncontrado.getId() == reservas.get(i).getViaje().getId() && usuario.getId() == reservas.get(i).getUsuario().getId()) 
                    contador++;
            }
            
            int plazasLibres;
            if(contador > 0)
                plazasLibres = coche.getNum_asientos() - contador;
            else 
                plazasLibres = coche.getNum_asientos();
            
            theOutput += "GET_DETAIL_TRAVEL_CORRECT#" + usuario.getNombre() + "#" + edad.getYears() + "#" + usuario.getMovil() + "#" + coche.getMatricula() + "#" + 
                    coche.getMarca() + "#" + coche.getModelo() + "#" + coche.getNum_asientos() + "#" + viajeEncontrado.getTrayecto().getOrigen() + 
                    "#" + viajeEncontrado.getTrayecto().getDestino() + "#" + viajeEncontrado.getFecha_salida() + "#" + viajeEncontrado.getHora_salida() + 
                    "#" + viajeEncontrado.getFecha_llegada() + "#" + viajeEncontrado.getHora_llegada() + "#" + plazasLibres + "#" + viajeEncontrado.getPrecio();
            
            hebraCliente.enviarMensaje(theOutput);
            
            theOutput = cabecera + HOSTNAME + "#STARTING_MULTIMEDIA_TRANSMISSION_TO#" + usuario.getId();
            
            hebraCliente.enviarMensaje(theOutput);
            
            enviarImagen(coche, usuario);
            
            theOutput = cabecera + HOSTNAME + "#ENDING_MULTIMEDIA_TRANSMISSION#" + usuario.getId();
            
            controlador.desconectar();
        } else {
            theOutput += "ERROR#BAD_PETITION";
        }
        
        hebraCliente.enviarMensaje(theOutput);
    }
    
    public void enviarImagen(Coche coche, Usuario usuario) {
        String inicioRuta = "C:/Users/raulr/Documents/NetBeansProjects/BlaBlaCarServer";

        String rutaCompleta = inicioRuta + coche.getFotografia();

        File image = new File(rutaCompleta);

        try {
            bytesImage = Files.readAllBytes(image.toPath()); 
            bytesPorEnvio = new byte[512];
            
            String inicioMensaje = cabecera + HOSTNAME + "#MULTIMEDIA_DATA_TRANSMITION_TO#" + usuario.getId()  + "#" + 
                    bytesImage.length + "#";
            int contadorBytesEnviados = 0;
            int j = 0;
            for(int i = 0; i < bytesImage.length; i++) {
                if(j == 512) {
                    contadorBytesEnviados += 512;
                    pasarBytesAlMensaje(512, inicioMensaje);
                    j = 0;
                }

                if(i == bytesImage.length - 1 && bytesPorEnvio.length <= 512) {
                    int bytesAenviar = bytesImage.length - contadorBytesEnviados;
                    pasarBytesAlMensaje(bytesAenviar, inicioMensaje);
                }
                bytesPorEnvio[j] = bytesImage[i];
                j++;
            }
        } catch (IOException ex) {
            Logger.getLogger(BlaBlaCarProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pasarBytesAlMensaje(int tamanio, String inicioMensaje) {
        String bytesCodificados = Base64.getEncoder().encodeToString(bytesPorEnvio);
        theOutput = inicioMensaje + bytesPorEnvio.length + "#" + bytesCodificados;
        
        hebraCliente.enviarMensaje(theOutput);
        bytesPorEnvio = new byte[512];
    }
    
    public void cerrarSesion() {
        if(mensajes[4].equals(LOGIN) && mensajes[3].equals(IP)) {
            theOutput = cabecera + HOSTNAME + "#BYE#" + LOGIN;
            hebraCliente.enviarMensaje(theOutput);
            
            hebraCliente.cerrarSesion();
        } else {
            theOutput += "ERROR#BAD_PETITION";
        }
    }
    
    public void realizarReserva() {
        theOutput = cabecera + HOSTNAME + "#";
        if(mensajes[4].equals(LOGIN) && mensajes[3].equals(IP)) {
            controlador.conectar();
            List<Viaje> viajes = controlador.getViajes();
            Viaje viaje = null;
            List<Reserva> reservas = controlador.getReservas();
            boolean encontrado = false;
            
            for(int i = 0; i < viajes.size() && !encontrado; i++) {
                String fechaSalida = viajes.get(i).getFecha_salida().toString(), 
                        horaSalida = viajes.get(i).getHora_salida().toString();
                
                if(viajes.get(i).getCoche().getId() == Integer.parseInt(mensajes[6]) && viajes.get(i).getTrayecto().getId() == Integer.parseInt(mensajes[7]) && 
                        fechaSalida.equals(mensajes[8]) && horaSalida.equals(mensajes[9])) { 
                    
                    viaje = viajes.get(i);
                    encontrado = true;
                }
            }
            int numReservasRealizadas = 0;
            for(int i = 0; i < reservas.size(); i++) {
                if(reservas.get(i).getViaje().getId() == viaje.getId()) {
                    numReservasRealizadas++;
                }
            }
            
            if(numReservasRealizadas + Integer.parseInt(mensajes[10]) > viaje.getNum_asientos_ofertados()) {
                numReservasRealizadas = viaje.getNum_asientos_ofertados() - numReservasRealizadas;
                theOutput += "WARNING#ONLY_AVAILABLE_PLACES#" + numReservasRealizadas;
            } else if(numReservasRealizadas + Integer.parseInt(mensajes[10]) <= viaje.getNum_asientos_ofertados()) {
                for(int i = 0; i < Integer.parseInt(mensajes[10]); i++) {
                    Reserva reserva = new Reserva();
                    reserva.setViaje(viaje);
                    reserva.setUsuario(usuario);
                    controlador.realizarReserva(reserva);
                }
                
                theOutput += "BOOK_COMPLETED";
            }
            controlador.desconectar();
        } else {
            theOutput += "ERROR#BAD_PETITION";
        }
        
        hebraCliente.enviarMensaje(theOutput);
    }
    
    public void processInput(String theInput) {
        mensajes = theInput.split("#");
 
        if(!mensajes[0].equals("null")) {
            if (mensajes[4].equals("LOGIN")) 
                login();

            if (mensajes[5].equals("GET_TRAVELS")) 
                viajesOfertados();

            if(mensajes[5].equals("GET_DETAIL_TRAVEL")) 
                detallesViaje();
            
            if(mensajes[5].equals("CLOSE_SESSION"))
                cerrarSesion();
            
            if(mensajes[5].equals("BOOK_PLACE"))
                realizarReserva();
        }
    }
}
