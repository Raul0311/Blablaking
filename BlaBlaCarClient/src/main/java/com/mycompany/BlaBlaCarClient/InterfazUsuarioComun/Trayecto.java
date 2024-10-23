package com.mycompany.BlaBlaCarClient.InterfazUsuarioComun;

import java.util.List;

public class Trayecto {
    private int id;
    
    private String origen;
    
    private String destino;

    private List<Viaje> viajes;

    public Trayecto(){}
    
    public Trayecto(int id, String origen, String destino, List<Viaje> viajes) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.viajes = viajes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }
}
