package educacionit.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Personas")
public class Persona {
    @Id
    @Column(name="id")
    public String id;
    @Column(name="nombre")
    public String nombre;

    public Persona() {
    }

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="personas_cuentas",
            joinColumns={@JoinColumn(name="persona_id")},
            inverseJoinColumns={@JoinColumn(name="cuenta_id")}
    )
    public List<Cuenta> cuentas;
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
