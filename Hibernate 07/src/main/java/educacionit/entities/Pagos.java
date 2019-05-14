package educacionit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pagos {

	@Id
	@Column(name = "id")
	protected String id;
	@Column(name = "usuario")
	protected String usuario;
	@Column(name = "monto")
	protected int monto;
	
	public Pagos() {

	}

	public Pagos(String id, String usuario, int monto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.monto = monto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

    @Override
    public String toString() {
        return "Pagos{" + "id=" + id + ", usuario=" + usuario + ", monto=" + monto + '}';
    }

        
}
