package educacionit.entities;

import javax.persistence.*;

@Entity
@Table(name="personas")
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
    
    @OneToOne(mappedBy="persona")
    public Empleado empleado;

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
