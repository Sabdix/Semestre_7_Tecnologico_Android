
package jpaexample;

import com.entities.Usuarios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sabdi
 */
public class JPAExample {

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExamplePU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public static void main(String[] args) {
        try {
            //Recupera el entity manager
            EntityManager em = getEntityManager();
            //Crear un nuevo usuario
            Usuarios usuario = new Usuarios();
            usuario.setNombre("Sixtos");
            usuario.setUsuario("six");
            usuario.setPass("1234");
            usuario.setCorreo("six@palomar.com");
            //Lo persiste en la base de datos
            EntityTransaction etx = em.getTransaction();
            etx.begin();
            em.persist(usuario);
            etx.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
