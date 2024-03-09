package com.a21gonzalocm.festivales.Model;

import com.a21gonzalocm.festivales.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DAOMusico {

    private EntityManager em;

    public DAOMusico(EntityManager em) {
        this.em = em;
    }

    public void insertMusico(Musico musico) {
        em.getTransaction().begin();
        em.persist(musico);
        em.getTransaction().commit();
    }

    public void updateMusico(Musico musico) {

        em.getTransaction().begin();
        em.merge(musico);
        em.getTransaction().commit();

    }

    public void deleteMusico(Musico musico) {

        em.getTransaction().begin();
        em.remove(em.contains(musico) ? musico : em.merge(musico));
        em.getTransaction().commit();

    }

    public Musico getMusico(int id) {

        Musico musico = em.find(Musico.class, id);

        return musico;
    }

    public void addBanda(Musico musico, Banda banda) {
        em.getTransaction().begin();
        musico.addBanda(banda);
        em.merge(musico);
        em.getTransaction().commit();
    }

    public void removeBanda(Musico musico, Banda banda) {

        em.getTransaction().begin();
        musico.removeBanda(banda);
        em.merge(musico);
        em.getTransaction().commit();

    }

    public List<Musico> getAllMusicos() {
        List<Musico> musicos = em.createQuery("SELECT m FROM Musico m").getResultList();
        return musicos;
    }

    public List<Musico> getMusicosByBanda(Banda banda) {
        List<Musico> musicos = em.createQuery("SELECT m FROM Musico m WHERE m.banda = :banda").setParameter("banda", banda).getResultList();
        return musicos;
    }

    public List<Musico> getMusicosByTipoMusica(TipoMusica tipoMusica) {
        List<Musico> musicos = em.createQuery("SELECT m FROM Musico m WHERE m.tipoMusica = :tipoMusica").setParameter("tipoMusica", tipoMusica).getResultList();
        return musicos;
    }

    public List<Musico> getMusicosByEdad(int edad) {

        List<Musico> musicos = em.createQuery("SELECT m FROM Musico m WHERE m.edad = :edad").setParameter("edad", edad).getResultList();

        return musicos;
    }

    public List<Musico> getMusicosByNacionalidad(String nacionalidad) {

        List<Musico> musicos = em.createQuery("SELECT m FROM Musico m WHERE m.nacionalidad = :nacionalidad").setParameter("nacionalidad", nacionalidad).getResultList();

        return musicos;
    }

    public List<MusicoDTO> getMusicosByInstrumento(String instrumento) {

        List<MusicoDTO> musicos = em.createQuery("SELECT  new com.a21gonzalocm.festivales.Model.MusicoDTO(m.nombre, m.instrumento, m.nacionalidad, m.sexo) FROM Musico m WHERE m.instrumento = :instrumento").setParameter("instrumento", instrumento).getResultList();

        return musicos;
    }
}
