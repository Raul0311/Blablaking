/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BlaBlaCarProtocol;

import com.mycompany.BlaBlaCarClient.UsuarioInterfaz.UserInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author raulr
 */
public class BlaBlaCarProtocol {
    String theOutput = null;
    UserInterface userInterface;
    
    DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
    String time = formatter.format(new Date());
    
    String inicioMensaje = "PROTOCOLBBKING1.0#" + LocalDate.now() + "#" + time + "#";
    
    public BlaBlaCarProtocol(UserInterface userInterface) {
        this.userInterface = userInterface;
    }
    
    public String inicioSesion(String hostName, String login, String contraseniaUsuario) {
        String inicioSesion = inicioMensaje + hostName + "#LOGIN#" + login + "#" + contraseniaUsuario;
        
        return inicioSesion;
    }
    
    public void loginCorrect(String[] mensajes) {
        if(mensajes[8].equals("P")) {
            String nombre = mensajes[6], apellido1 = mensajes[7];
            userInterface.iniciarSesionPasajero(nombre, apellido1);
        } else {
            userInterface.iniciarSesionConductor();
        }
    }
    
    public static void realizarBusquedaReservas(String origen, String destino, String numAsientos, String date, String login) {
        String theOutput = null;
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String time = formatter.format(new Date());
    
        String inicioMensaje = "PROTOCOLBBKING1.0#" + LocalDate.now() + "#" + time + "#";
        theOutput = inicioMensaje + "#" + login + "#" + "GET_TRAVELS";
    }
    
    public String processInput(String theInput) {
        String[] mensajes = theInput.split("#");
        
        if (mensajes[4].equals("LOGIN_CORRECT")) {
            loginCorrect(mensajes);
        }
        
        if (mensajes[4].equals("ERROR")) {
            userInterface.error();
        }
        return theOutput;
    }
}
