package educacionit;

import com.github.javafaker.Faker;
import educacionit.entities.Pagos;
import educacionit.entities.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class App 
{
    public static void crearUsuarios(EntityManager em) {
        Faker faker = new Faker();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
	for (int i = 0; i < 1000; i++) {
            Usuario u = new Usuario(
                    java.util.UUID.randomUUID().toString(),
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.address().country());
            
            em.persist(u);
        }
        tx.commit();
        
        Usuario u1 = new Usuario(
            "UNO",
            "Tomas",
            "Sanchez",
            "Argentina");
        
        u1.getList().add(new Pagos(java.util.UUID.randomUUID().toString(),u1.getId(),100));
        u1.getList().add(new Pagos(java.util.UUID.randomUUID().toString(),u1.getId(),200));
        
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        em.persist(u1);
        tx2.commit();
    }
    public static void consultarUsuarios(EntityManager em) {
        Query q = em.createQuery("from Usuario u where u.id = 'UNO'");
        Usuario u = (Usuario)q.getResultList().get(0);
        for (Pagos p : u.getList()) {
            System.out.println(p);
        }
    }
    public static void main( String[] args )
    {
        javax.persistence.EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory("pueclipse");

	EntityManager em = emf.createEntityManager();

        crearUsuarios(em);
        consultarUsuarios(em);
    }
}
