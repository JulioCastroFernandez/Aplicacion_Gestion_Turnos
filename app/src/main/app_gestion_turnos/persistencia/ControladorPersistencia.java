package main.app_gestion_turnos.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import main.app_gestion_turnos.logica.Turno;

import java.util.List;

public class ControladorPersistencia {
    private EntityManagerFactory emf = null; //Se encarga de crear instancias de EntityManager.

    public ControladorPersistencia(){
        emf = Persistence.createEntityManagerFactory("gestionturno")
    }

    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    // --- Metodos CRUD para la clase Turno ---

    public void crearTurno(Turno turno){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        }catch (Exception e){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public Turno traerTurno(Long id){
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        }finally {
            em.close();
        }
    }

    public List<Turno> traerTodosLosTurno(){
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Turno> cq = em.getCriteriaBuilder().createQuery(Turno.class);
            Root<Turno>rootEntry = cq.from(Turno.class);
            CriteriaQuery<Turno> all = cq.select(rootEntry);
            TypedQuery<Turno> allQuery = em.createQuery(all);
            return allQuery.getResultList();
        }finally {
            em.close();
        }
    }

    public void actualizarTurno(Turno turno){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(turno);
            em.getTransaction().commit();
        }catch (Exception e){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public void borrarTurno(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Turno turno = em.find(Turno.class, id);
            if (turno != null){
                em.remove(turno);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
