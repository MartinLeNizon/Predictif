package metier.modele;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnguyen
 */
@Entity
public class Employe {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String nom;
    private String prenom;
    private String telephonePro;
    private String mail;
    private String motDePasse;
    private String genre;
    private boolean disponible; // disponibilité - 0 : indisponible ; 1 : disponible
    @OneToMany(mappedBy="employe")
    private List<Consultation> historique;
    
    public Employe(){}
    
    public Employe(String nom, String prenom, String telephonePro, String mail, String genre){
        this.nom=nom;
        this.prenom=prenom;
        this.telephonePro=telephonePro;
        this.mail=mail;
        this.genre=genre;
        this.disponible=true;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    
    public String getTelephonePro() {
        return this.telephonePro;
    }
    
    public void setTelephonePro(String telephonePro){
        this.telephonePro=telephonePro;
    }
    
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail){
        this.mail=mail;
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre){
        this.genre=genre;
    }
    
    public String getMotDePasse() {
        return this.motDePasse;
    }
    
    public void setMotDePasse(String motDePasse){
        this.motDePasse=motDePasse;
    }
    
    public boolean getDisponible() {
        return this.disponible;
    }
    
    public void setDisponible(boolean disponible){
        this.disponible=disponible;
    }
    
    public void ajouterConsultation(Consultation maConsultation) {
        this.historique.add(maConsultation);
    }
    
    public List<Consultation> getHistorique() {
        return this.historique;
    }

    @Override
    public String toString() {
        return "Employe: id = " + id + " ; Nom = " + nom + " ; Prenom = " + prenom + " ; TelephonePro = " + telephonePro + " ; Mail = " + mail + " ; Genre = " + genre + " ; Disponible = " + disponible + " ; MotDePasse = " + motDePasse;
    }
    
    
    
    
    
}
