package blablacarHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private long id;
    
    @ManyToOne
    @JoinColumn(name="id_viaje")
    private Viaje viaje;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Reserva() {
    }

    public Reserva(long id, Viaje viaje, Usuario usuario) {
        this.id = id;
        this.viaje = viaje;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}