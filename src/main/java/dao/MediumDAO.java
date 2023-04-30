package dao;


import metier.modele.Medium;
import java.util.List;
import javax.persistence.TypedQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnguyen
 */
public class MediumDAO {
    
    public MediumDAO() {}
    
    public void creer(Medium medium) {
        JpaUtil.obtenirContextePersistance().persist(medium);
    }

    public Medium chercherParId(Long id) {
        return JpaUtil.obtenirContextePersistance().find(Medium.class, id);   
    }

    public List<Medium> chercherTous() {
        String s = "select m from Medium m order by m.denomination asc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Medium.class);
        return query.getResultList();
    }
    
    public List<Medium> chercherCartomanciens() {
        String s = "select m from Cartomancien m order by m.denomination asc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Medium.class);
        return query.getResultList();
    }
    
    public List<Medium> chercherSpirites() {
        String s = "select m from Spirite m order by m.denomination asc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Medium.class);
        return query.getResultList();
    }
    
    public List<Medium> chercherAstrologues() {
        String s = "select m from Astrologue m order by m.denomination asc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Medium.class);
        return query.getResultList();
    }
}

