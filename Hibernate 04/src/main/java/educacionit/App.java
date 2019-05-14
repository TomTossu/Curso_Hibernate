package educacionit;

import educacionit.entities.*;
import educacionit.configuration.HibernateConfiguration;
import educacionit.repository.BaseRepository;
import java.util.ArrayList;
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
    
    public static void pruebaOne2One() {
        
        Persona p = new Persona(getId.get(), "Mario");
        Empleado e = new Empleado(getId.get(), p, 300f);
        
        BaseRepository<Empleado> repoCli = new BaseRepository<Empleado>(sessFac, Empleado.class);
        
        repoCli.save(e);
    }
    public static void pruebaOne2Many() {
            BaseRepository<Club> repoClub = new BaseRepository<Club>(sessFac, Club.class);
//          BaseRepository<Campeonato> repoCamp= new BaseRepository<Campeonato>(sessFac, Campeonato.class);
            Club club = new Club(java.util.UUID.randomUUID().toString(), "Club 1");
            List<Campeonato> campeonatos = new ArrayList<Campeonato>();
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato A", "1"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato A", "2"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato A", "3"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato B", "1"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato B", "2"));
            club.campeonatos= campeonatos;
            Club club2 = new Club(java.util.UUID.randomUUID().toString(), "Club 2");
            campeonatos = new ArrayList<Campeonato>();
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato C", "1"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato C", "2"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato C", "3"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato D", "1"));
            campeonatos.add(new Campeonato(java.util.UUID.randomUUID().toString(), "Campeonato D", "2"));
            club2.campeonatos= campeonatos;
    
            repoClub.save(club);
            repoClub.save(club2);
    }
    public static void getClubesYCampeonatos() {
        Session sess = sessFac.openSession();
        Query q = sess.createQuery("from Club cl JOIN FETCH cl.campeonatos ca");
        
        for (Object obj : q.list()) {
            Club club = (Club)obj;
            System.out.println(club.nombre);
            for (Campeonato c : club.campeonatos) {
                System.out.println(c.año);
                System.out.println(c.nombre);
            }
        }
        
        sess.close();
    }
    public static void main( String[] args )
    {
        HibernateConfiguration hibernateConfiguration = new 
            HibernateConfiguration();
        
        sessFac = hibernateConfiguration.configure();
        
        getClubesYCampeonatos();
    }
}
