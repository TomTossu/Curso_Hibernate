package educacionit.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CodigoInternacional implements Serializable {
    public String pais;
    public String localidad;

    public CodigoInternacional(String pais, String localidad) {
        this.pais = pais;
        this.localidad = localidad;
    }

    public CodigoInternacional() {
    }
}
