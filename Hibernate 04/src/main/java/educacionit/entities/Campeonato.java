package educacionit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campeonatos")
public class Campeonato {

	@Id
	@Column(name = "id")
	public String id;
	@Column(name = "nombre")
	public String nombre;
	@Column(name = "año")
	public String año;
	
        @ManyToOne()        
	Club club;
        
	public Campeonato() {
		
	}
	
	public Campeonato(String id, String nombre, String año) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.año = año;
	}
	
	
}
