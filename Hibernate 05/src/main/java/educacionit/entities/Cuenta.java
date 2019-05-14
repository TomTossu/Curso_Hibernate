package educacionit.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Cuentas")
public class Cuenta {
	@Id
	@Column(name="id")
	public String id;
	
	@Column(name="descripcion")
	public String descripcion;

        @ManyToMany(cascade={CascadeType.ALL})
        @JoinTable(name="personas_cuentas",
                joinColumns={@JoinColumn(name="cuenta_id")},
                inverseJoinColumns={@JoinColumn(name="persona_id")}
        )
        public List<Persona> personas;
        
	public Cuenta() {
	}

	public Cuenta(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
}
