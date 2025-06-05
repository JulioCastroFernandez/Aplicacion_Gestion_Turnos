package persistence;

import jakarta.persistence.*;
import entities.*;


import java.util.List;

public class ControladorPersistencia {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionturno");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
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

    public Turno buscarTurno(Long id){
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        }finally {
            em.close();
        }
    }

    public List<Turno> buscarTodosLosTurno(){
        EntityManager em = getEntityManager();
        try {
            String sql = "SELECT * FROM Turno";
            Query query = em.createNativeQuery(sql, Turno.class);
            return query.getResultList();
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

    // --- Metodos CRUD para la clase Ciudadano ---

    public void crearCiudadano (Ciudadano ciudadano){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ciudadano);
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

    public Ciudadano buscarCiudadanoPorID(Long id){
        EntityManager em = getEntityManager();
                try{
                    return em.find(Ciudadano.class, id);
                }finally {
                    em.close();
                }
    }

    public Ciudadano buscarCiudadanoPorDNI (String dni){
        EntityManager em = getEntityManager();
        try {
            String sql = "SELECT * FROM Ciudadano WHERE dni = :dniParam";
            Query query = em.createNativeQuery(sql, Ciudadano.class);
            query.setParameter("dniParam", dni);
            List<Ciudadano> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                return resultados.get(0);
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    } // Metodo para buscar un Ciudadano por DNI

    public List<Ciudadano> buscarTodosLosCiudadanos(){
        EntityManager em = getEntityManager();
        try {
            String sql = "SELECT * FROM Ciudadano";
            Query query = em.createNativeQuery(sql, Ciudadano.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }

    public void actualizarCiudadano(Ciudadano ciudadano){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ciudadano);
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

    public void borrarCiudadano(Long id){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Ciudadano ciudadano = em.find(Ciudadano.class, id);
            if (ciudadano != null){
                em.remove(ciudadano);
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