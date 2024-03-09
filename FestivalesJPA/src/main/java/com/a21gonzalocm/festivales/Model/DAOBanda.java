package com.a21gonzalocm.festivales.Model;

import com.a21gonzalocm.festivales.JPAUtil;

import jakarta.persistence.*;

import java.util.List;

public class DAOBanda {

    private EntityManager em;

    public DAOBanda(EntityManager em) {
        this.em=em;
    }

    public void insertBanda(Banda banda){

        em.getTransaction().begin();
        em.persist(banda);
        em.getTransaction().commit();

    }

    public void updateBanda(Banda banda){

        em.getTransaction().begin();
        em.merge(banda);
        em.getTransaction().commit();

    }

    public void deleteBanda(Banda banda){

        em.getTransaction().begin();
        em.remove(em.contains(banda) ? banda : em.merge(banda));
        em.getTransaction().commit();

    }

    public Banda getBanda(int id){

        Banda banda = em.find(Banda.class, id);

        return banda;
    }

    public void addMusico(Banda banda, Musico musico){

        em.getTransaction().begin();
        banda.addMusico(musico);
        em.merge(banda);
        em.getTransaction().commit();

    }

    public void removeMusico(Banda banda, Musico musico){

        em.getTransaction().begin();
        banda.removeMusico(musico);
        em.merge(banda);
        em.getTransaction().commit();

    }

public List<Banda> getAllBandas(){

        Query query = em.createQuery("SELECT b FROM Banda b");
        List<Banda> bandas = query.getResultList();

        return bandas;
    }

    public List<Banda> getBandasByTipoMusica(TipoMusica tipoMusica){

        Query query = em.createQuery("SELECT b FROM Banda b WHERE b.tipoMusica = :tipoMusica");
        query.setParameter("tipoMusica", tipoMusica);
        List<Banda> bandas = query.getResultList();

        return bandas;
    }

    public List<Banda> getBandasByMusico(Musico musico){

        Query query = em.createQuery("SELECT b FROM Banda b WHERE :musico MEMBER OF b.musicos");
        query.setParameter("musico", musico);
        List<Banda> bandas = query.getResultList();

        return bandas;
    }

    public List<Banda> getBandasByFestival(Festival festival){

        Query query = em.createQuery("SELECT b FROM Banda b WHERE :festival MEMBER OF b.festivales");
        query.setParameter("festival", festival);
        List<Banda> bandas = query.getResultList();

        return bandas;
    }

    public List<Banda> getBandasByFechaCreacion(int year){

        Query query = em.createQuery("SELECT b FROM Banda b WHERE YEAR(b.fechaCreacion) = :year");
        query.setParameter("year", year);
        List<Banda> bandas = query.getResultList();

        return bandas;
    }



}
