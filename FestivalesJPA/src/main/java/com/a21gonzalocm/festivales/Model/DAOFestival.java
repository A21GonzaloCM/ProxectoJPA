package com.a21gonzalocm.festivales.Model;

import com.a21gonzalocm.festivales.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DAOFestival {

    private EntityManager em;
    public DAOFestival(EntityManager em) {
        this.em=em;
    }

    public void insertFestival(Festival festival){

        em.getTransaction().begin();
        em.persist(festival);
        em.getTransaction().commit();


    }

    public void updateFestival(Festival festival){

        em.getTransaction().begin();
        em.merge(festival);
        em.getTransaction().commit();

    }

    public void deleteFestival(Festival festival){

        em.getTransaction().begin();
        em.remove(em.contains(festival) ? festival : em.merge(festival));
        em.getTransaction().commit();

    }

    public Festival getFestival(int id){

        Festival festival = em.find(Festival.class, id);

        return festival;
    }

    public void addBanda(Festival festival, Banda banda){

        em.getTransaction().begin();
        festival.addBanda(banda);
        em.merge(festival);
        em.getTransaction().commit();

    }

    public void removeBanda(Festival festival, Banda banda){

        em.getTransaction().begin();
        festival.removeBanda(banda);
        em.merge(festival);
        em.getTransaction().commit();

    }

    public void addMusico(Festival festival, Musico musico){
        em.getTransaction().begin();
        festival.addMusico(musico);
        em.merge(festival);
        em.getTransaction().commit();
    }

    public void removeMusico(Festival festival, Musico musico){
        em.getTransaction().begin();
        festival.removeMusico(musico);
        em.merge(festival);
        em.getTransaction().commit();
    }

    public List<Festival> getAllFestivales(){
        List<Festival> festivales = em.createQuery("SELECT f FROM Festival f").getResultList();
        return festivales;
    }

    public List<Festival> getFestivalesByTipo(String tipo){
        List<Festival> festivales = em.createQuery("SELECT f FROM Festival f WHERE f.tipo = :tipo").setParameter("tipo", tipo).getResultList();
        return festivales;
    }

    public List<Festival> getFestivalesByOrganizador(String organizador){

        List<Festival> festivales = em.createQuery("SELECT f FROM Festival f WHERE f.organizador = :organizador").setParameter("organizador", organizador).getResultList();

        return festivales;
    }

    public List<Festival> getFestivalesByPatrocinador(String patrocinador){

        List<Festival> festivales = em.createQuery("SELECT f FROM Festival f WHERE f.patrocinador = :patrocinador").setParameter("patrocinador", patrocinador).getResultList();

        return festivales;
    }


}
