package educacionit;

import educacionit.entities.*;
import educacionit.configuration.HibernateConfiguration;
import educacionit.repository.BaseRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static SessionFactory sessFac;
    public static java.util.function.Supplier<String> getId 
            = () -> java.util.UUID.randomUUID().toString();
   
    public static void cargaMany2Many() {
            BaseRepository<Persona> repoPersona= new BaseRepository<Persona>(sessFac, Persona.class);
            
            Persona pricila = new Persona("5000","Pricila");
            Persona agustina = new Persona("5001","Agustina");
            Persona tomas = new Persona("5002","Tomas");
            Persona juan = new Persona("5003","Juan");
            
            Cuenta cuenta1001 = new Cuenta("1001","u$d 7000");
            Cuenta cuenta1002 = new Cuenta("1002","$ 20");
            Cuenta cuenta1003 = new Cuenta("1003","u$d 3");
            Cuenta cuenta1005 = new Cuenta("1005","$ 10000");
            
            pricila.cuentas = Arrays.asList(cuenta1001);
            agustina.cuentas = Arrays.asList(cuenta1001);
            tomas.cuentas = Arrays.asList(cuenta1002, cuenta1003);
            juan.cuentas = Arrays.asList(cuenta1005);
            
            cuenta1001.personas = Arrays.asList(pricila, agustina);
            cuenta1002.personas = Arrays.asList(tomas);
            cuenta1003.personas = Arrays.asList(tomas);
            cuenta1005.personas = Arrays.asList(juan);
            
            repoPersona.save(pricila);
            repoPersona.save(agustina);
            repoPersona.save(tomas);
            repoPersona.save(juan);
    }
    public static void seleccionarPersonas() {
        Session session = sessFac.openSession();
    
        Query q = session.createQuery("from Persona p join fetch p.cuentas c ");
        
        for (Object item : q.list()) {
            Persona p = (Persona)item;
            mostrarPersona(p);
        }
        
        session.close();
    }
    public static void mostrarPersona(Persona p) {
        System.out.println("P E R S O N A");
        System.out.println(p.id);
        System.out.println(p.nombre);
        if (p.cuentas != null) {
            for (Cuenta c : p.cuentas) {
                System.out.println("   C U E N T A");
                System.out.println("   " + c.id );
                System.out.println("   " + c.descripcion );
            }
        }
    }
    public static void crearAeropuertos() {
        BaseRepository<Aeropuerto> aeropuertos =
                new BaseRepository<Aeropuerto>(sessFac, Aeropuerto.class);
        
        Aeropuerto a1 = new Aeropuerto(new CodigoInternacional("EEUU","LSL"), "Aeropuerto JFK", 3000);
        Aeropuerto a2 = new Aeropuerto(new CodigoInternacional("ARG","CBA"), "Aeropuerto Internacional Cordoba", 2000);
    
        aeropuertos.save(a1);
        aeropuertos.save(a2);
    }
    public static void obtenerAeropuertos() {
         Session session = sessFac.openSession();
    
        Query q = session.createQuery("from Aeropuerto a");
        
        for (Object item : q.list()) {
            Aeropuerto a = (Aeropuerto)item;
            System.out.println(a);
        }
        
        session.close();
    }
    public static void main( String[] args )
    {
        HibernateConfiguration hibernateConfiguration = new 
            HibernateConfiguration();
        
        sessFac = hibernateConfiguration.configure();
        
        // cargaMany2Many();
        // seleccionarPersonas();
        crearAeropuertos();
    }
}
