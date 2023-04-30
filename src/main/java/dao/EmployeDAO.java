package dao;


import metier.modele.Employe;
import metier.modele.Medium;
import java.util.List;
import javax.persistence.TypedQuery;
import metier.modele.Consultation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnguyen
 */
public class EmployeDAO {
    
    public EmployeDAO() {}
    
    public void creer(Employe employe) {
        JpaUtil.obtenirContextePersistance().persist(employe);
    }
    
    public Employe chercherParId(Long id) {
        return JpaUtil.obtenirContextePersistance().find(Employe.class, id);   
    }
    
    public List<Employe> chercherTous() {
        String s = "select e from Employe e order by e.nom asc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Employe.class);
        return query.getResultList();
    }
    
    
     public List<Employe> chercherParMail(String mail, String motDePasse) {
        String s = "select e from Employe e where e.mail = :unMail and e.motDePasse = :unMotDePasse";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Employe.class);
        query.setParameter("unMail", mail);
        query.setParameter("unMotDePasse", motDePasse);
        return query.getResultList();
    }
     
     public Employe chercherPourConsultation(Medium monMedium) {

        Employe monEmploye = null;
            
        if (monMedium == null) {
            System.out.println("Le medium est invalide");
        } else {
            String s = "select e from Employe e where e.genre = :unGenre and e.disponible = 1 order by ( select count(c) from Consultation c where c.employe.id = e.id)";
            TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s,Employe.class);
            query.setParameter("unGenre", monMedium.getGenre());
            List<Employe> resultList = query.getResultList();

            if (resultList.isEmpty()) {
                System.out.println("Aucun employé ne peut accepter de consultation actuellement");
            } else {
                monEmploye = resultList.get(0);
            }
            
        }
        
        return monEmploye;
    }
}
    
 
    
//    public void supprimer(Employe employe) {
//        JPAutil.obtenirEntityManager().remove(employe);
//    }
//    public Employe modifier(Employe employe) {
//        return JPAutil.obtenirEntityManager().merge(employe);
//    }
//    public Employe chercherParId(Long id) {
//        return JPAutil.obtenirEntityManager().find(Employe.class, id);
//    }
