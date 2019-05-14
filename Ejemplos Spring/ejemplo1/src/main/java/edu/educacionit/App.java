package edu.educacionit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class RepoFacturacion {

    public RepoFacturacion() {
        System.out.println("Constructor repo facturacion");
    }

    public void guardarFactura() {
        System.out.println("RepoFacturacion::guardarFactura");
    }
}

class ServicioDeFacturacion {

    private RepoFacturacion repoFacturacion;

    public ServicioDeFacturacion() {
        System.out.println("Constructor servicio facturacion");
    }

    public ServicioDeFacturacion(RepoFacturacion repoFacturacion) {
        this.repoFacturacion = repoFacturacion;
    }

    public RepoFacturacion getRepoFacturacion() {
        return repoFacturacion;
    }

    public void setRepoFacturacion(RepoFacturacion repoFacturacion) {
        this.repoFacturacion = repoFacturacion;
    }

    public void facturar() {
        System.out.println("Invocando al metodo ServicioDeFacturacion::facturar");
        repoFacturacion.guardarFactura();
    }

}

public class App {

    public static void main(String[] args) {
        
        ApplicationContext appContext
                = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        ServicioDeFacturacion sf
                = appContext.getBean("servicioDeFacturacion", ServicioDeFacturacion.class);

        sf.facturar();
    }
}
