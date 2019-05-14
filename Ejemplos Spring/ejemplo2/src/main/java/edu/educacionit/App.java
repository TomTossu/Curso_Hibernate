package edu.educacionit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository("RepoFacturacion")
class RepoFacturacion {

    public RepoFacturacion() {
        System.out.println("Constructor repo facturacion");
    }
    
    public void guardarFactura() {
        System.out.println("RepoFacturacion::guardarFactura");
    }
}

@Service("servicioDeFacturacion")
class ServicioDeFacturacion {
    
    @Autowired
    private  RepoFacturacion repoFacturacion;

    public ServicioDeFacturacion() {
        System.out.println("Constructor servicio facturacion");
    }
    
    public void facturar() {
        System.out.println("Invocando al metodo ServicioDeFacturacion::facturar");
        repoFacturacion.guardarFactura();
    }
    
}


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
        
        ServicioDeFacturacion sf =
                appContext.getBean("servicioDeFacturacion", ServicioDeFacturacion.class);
        
        sf.facturar();
    }
}
