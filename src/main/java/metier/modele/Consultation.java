/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.modele;

import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mnguyen
 */
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    //@Temporal(TemporalType.DATE)
    //private Date dateFin;
    private String heureDebut;
    private String heureFin;
    private String commentaire;
    private String etat; //"Demandée" ; "Prête" ; "Terminée"
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Medium medium;
    @ManyToOne
    private Client client;
    
    
    public Consultation(){}
    
    public Consultation(Employe monEmploye, Medium monMedium, Client monClient, Date dateDebut, String heureDebut){
        this.employe=monEmploye;
        this.medium=monMedium;
        this.client=monClient;
        this.dateDebut=dateDebut;
        this.heureDebut=heureDebut;
        this.etat="Demandée";
    }
    
    public Long getId(){
        return this.id;
    }
    
    public Date getDateDebut() {
        return this.dateDebut;
    }
    
    public void setDateDebut(Date dateDebut){
        this.dateDebut=dateDebut;
    }
    
    /*public Date getDateFin() {
        return this.dateFin;
    }
    
    public void setDateFin(Date dateFin){
        this.dateFin=dateFin;
    }*/
    
    public String getHeureDebut() {
        return this.heureDebut;
    }
    
    public void setHeureDebut(String heureDebut){
        this.heureDebut=heureDebut;
    }
    
    public String getHeureFin() {
        return this.heureFin;
    }
    
    public void setHeureFin(String heureFin){
        this.heureFin=heureFin;
    }
    
    public String getCommentaire() {
        return this.commentaire;
    }
    
    public void setCommentaire(String commentaire){
        this.commentaire=commentaire;
    }
    
    public String getEtat() {
        return this.etat;
    }
    
    public void setEtat(String etat){
        this.etat=etat;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    @Override
    public String toString() {
        return "Consultation demandée par : " + client.getPrenom() + " ; Employe en charge  : " + employe.getPrenom() + " ; Medium à incarner : " + medium.getDenomination() + " ; Date Debut = " + dateDebut + " ; Etat = " + etat;
    }
    
    
    
}
