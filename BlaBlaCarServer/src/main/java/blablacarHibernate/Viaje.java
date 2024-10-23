package blablacarHibernate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private long id;
        
    @ManyToOne
    @JoinColumn(name="id_coche")
    private Coche coche;
    
    @ManyToOne
    @JoinColumn(name="id_trayecto")
    private Trayecto trayecto;
    
    @Column(name="fecha_salida")
    private LocalDate fecha_salida;
    
    @Column(name="hora_salida")
    private LocalTime hora_salida;
    
    @Column(name="fecha_llegada")
    private LocalDate fecha_llegada;
    
    @Column(name="hora_llegada")
    private LocalTime hora_llegada;
    
    @Column(name="num_asientos_ofertados")
    private int num_asientos_ofertados;
    
    @Column(name="precio")
    private BigDecimal precio;
 
    @OneToMany(mappedBy = "viaje", cascade = CascadeType.DETACH)
    private List<Reserva> reservas;

    public Viaje() {
    }

    public Viaje(long id, Coche coche, Trayecto trayecto, LocalDate fecha_salida, LocalTime hora_salida, LocalDate fecha_llegada, LocalTime hora_llegada, int num_asientos_ofertados, BigDecimal precio, List<Reserva> reservas) {
        this.id = id;
        this.coche = coche;
        this.trayecto = trayecto;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.fecha_llegada = fecha_llegada;
        this.hora_llegada = hora_llegada;
        this.num_asientos_ofertados = num_asientos_ofertados;
        this.precio = precio;
        this.reservas = reservas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Trayecto getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public LocalDate getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(LocalDate fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public LocalTime getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(LocalTime hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public int getNum_asientos_ofertados() {
        return num_asientos_ofertados;
    }

    public void setNum_asientos_ofertados(int num_asientos_ofertados) {
        this.num_asientos_ofertados = num_asientos_ofertados;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
