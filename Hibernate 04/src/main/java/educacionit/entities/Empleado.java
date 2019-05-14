package educacionit.entities;

import javax.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado {
    @Id
    @Column(name="id")
    public String id;
    
    @Column(name="salario")
    public Float salario;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="persona_id")
    public Persona persona;
    
    public Empleado() {
    }

    public Empleado(String id, Persona persona, Float salario) {
        this.id = id;
        this.persona = persona;
        this.salario = salario;
    }
}
