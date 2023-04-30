/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.TypedQuery;
import metier.modele.Client;
import metier.modele.Employe;
import metier.modele.Medium;
import metier.modele.Consultation;

/**
 *
 * @author mnguyen
 */
public class ConsultationDAO {
    public ConsultationDAO() {}
    
    public void creer(Consultation consultation) {
        JpaUtil.obtenirContextePersistance().persist(consultation);
    }
    public Consultation chercherParId(Long id) {
        return JpaUtil.obtenirContextePersistance().find(Consultation.class, id);   
    }
    
    public List<Consultation> chercherTous() {
        String s = "select c from Consultation c order by c.dateDebut desc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        return query.getResultList();
    }
    
     public List<Consultation> chercherParClient(Client client) {
        String s = "select c from Consultation c where c.client = :unClient";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        query.setParameter("unClient", client);
        return query.getResultList();
    }
    
    public Consultation chercherParEmploye(Employe monEmploye) {
        String s = "select c from Consultation c where c.employe = :unEmploye and c.etat = :etat";
        TypedQuery <Consultation> query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        query.setParameter("unEmploye", monEmploye);
        query.setParameter("etat", "Demandée");
        return query.getResultList().get(0);
    }
    
    public Consultation chercherParEmployeTerminee(Employe monEmploye) {
        String s = "select c from Consultation c where c.employe = :unEmploye and c.etat = :etat order by c.dateDebut desc and c.heureFin desc";
        TypedQuery <Consultation> query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        query.setParameter("unEmploye", monEmploye);
        query.setParameter("etat", "Terminée");
        return query.getResultList().get(0);
    }
    
     public List<Consultation> chercherParMedium(Medium medium) {
        String s = "select c from Consultation c where c.medium = :unMedium";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        query.setParameter("unMedium", medium);
        return query.getResultList();
    }
     
     public long chercherNbConsultationsParMedium(Medium medium) {
        String s = "select count(c) from Consultation c where c.medium = :unMedium";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        query.setParameter("unMedium", medium);
        return (long) query.getSingleResult();
    }
     
    public long chercherNbClientsParEmploye(Employe employe) {
        String s = "select count(distinct c.client) from Consultation c where c.employe = :unEmploye";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        query.setParameter("unEmploye", employe);
        return (long) query.getSingleResult();
    }
    
    public List<Medium> chercherTopMedium() {
        String s = "select c.medium from Consultation c group by c.medium order by count (distinct c.client) desc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Consultation.class);
        query.setMaxResults(5);
        return query.getResultList();
    }
}
