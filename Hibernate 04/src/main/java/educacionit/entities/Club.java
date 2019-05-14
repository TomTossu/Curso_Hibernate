package educacionit.entities;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clubes")
public class Club {
	@Id
	@Column(name = "id")
	public String id;
	@Column(name = "nombre")
	public String nombre;
	
        @OneToMany(cascade=CascadeType.ALL)
        @JoinColumn(name="club_id")
	public List<Campeonato> campeonatos;
	
	public Club() {
		
	}
	
	public Club(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
}
