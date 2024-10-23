package blablacarHibernate;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trayectos")
public class Trayecto {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="origen")
    private String origen;
    
    @Column(name="destino")
    private String destino;

    @OneToMany(mappedBy = "trayecto", cascade = CascadeType.DETACH)
    private List<Viaje> viajes;

    public Trayecto(){}
    
    public Trayecto(long id, String origen, String destino, List<Viaje> viajes) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.viajes = viajes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
