package educacionit.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@Column(name = "id")
	protected String id;
	@Column(name = "nombre")
	protected String nombre;
	@Column(name = "apellido")
	protected String apellido;
	@Column(name = "pais")
	protected String pais;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	protected List<Pagos> list;

	public Usuario() {
            list = new ArrayList<Pagos>();
	}

	public Usuario(String id, String nombre, String apellido, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
                list = new ArrayList<Pagos>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

        public List<Pagos> getList() {
            return list;
        }

        public void setList(List<Pagos> list) {
            this.list = list;
        }

        @Override
        public String toString() {
                return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
        }
}
