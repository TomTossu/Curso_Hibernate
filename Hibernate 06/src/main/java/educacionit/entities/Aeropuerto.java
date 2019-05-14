package educacionit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="aeropuertos")
public class Aeropuerto {
    @javax.persistence.EmbeddedId
    CodigoInternacional codigoInternacional;
    
    @Column(name="descripcion")
    public String descripcion;
    
    @Column(name="operaciones")
    public Integer operaciones;

    public Aeropuerto(CodigoInternacional codigoInternacional, String descripcion, Integer operaciones) {
        this.codigoInternacional = codigoInternacional;
        this.descripcion = descripcion;
        this.operaciones = operaciones;
    }
    public Aeropuerto() {
    }
}
