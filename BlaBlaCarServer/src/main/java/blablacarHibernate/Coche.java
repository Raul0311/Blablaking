package blablacarHibernate;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="coches")
public class Coche {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private long id;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    
    @Column(name="matricula")
    private String matricula;
    
    @Column(name="marca")
    private String marca;
    
    @Column(name="modelo")
    private String modelo;
    
    @Column(name="num_asientos")
    private int num_asientos;
    
    @Column(name="fotografia")
    private String fotografia;
    
    @OneToMany(mappedBy = "coche", cascade = CascadeType.DETACH)
    private List<Viaje> viajes;

    public Coche(){}

    public Coche(long id, Usuario usuario, String matricula, String marca, String modelo, int num_asientos, String fotografia, List<Viaje> viajes) {
        this.id = id;
        this.usuario = usuario;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.num_asientos = num_asientos;
        this.fotografia = fotografia;
        this.viajes = viajes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNum_asientos() {
        return num_asientos;
    }

    public void setNum_asientos(int num_asientos) {
        this.num_asientos = num_asientos;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }
}
