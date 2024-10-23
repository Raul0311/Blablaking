package com.mycompany.BlaBlaCarClient.InterfazUsuarioComun;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Viaje {
    
    private long id;
        
    private int id_coche;
    
    private Trayecto trayecto;
    
    private String fecha_salida;
    
    private String hora_salida;
    
    private BigDecimal precio;

    public Viaje() {
    }

    public Viaje(long id, int id_coche, Trayecto trayecto, String fecha_salida, String hora_salida, BigDecimal precio) {
        this.id = id;
        this.id_coche = id_coche;
        this.trayecto = trayecto;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_coche() {
        return id_coche;
    }

    public void setId_coche(int id_coche) {
        this.id_coche = id_coche;
    }

    public Trayecto getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
