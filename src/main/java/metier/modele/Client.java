package metier.modele;


import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Client {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String adressePostale;
    private String noTelephone;
    @Column(unique=true)
    private String mail;
    private String motDePasse;
    @Embedded
    private ProfilAstral monProfilAstral;
    @OneToMany(mappedBy="client")
    private List<Consultation> historique;
    
    public Client(){
        
    }
    
    public Client(String nom, String prenom, Date dateNaissance, String adressePostale, String noTelephone, String mail){
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
        this.adressePostale=adressePostale;
        this.noTelephone=noTelephone;
        this.mail=mail;
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
    public Date getDateNaissance() {
        return this.dateNaissance;
    }
    
    public void setDateNaissance(Date dateNaissance){
        this.dateNaissance=dateNaissance;
    }
    
    public String getAdressePostale() {
        return this.adressePostale;
    }
    
    public void setAdressePostale(String adressePostale){
        this.adressePostale=adressePostale;
    }
    
    public String getNoTelephone() {
        return this.noTelephone;
    }
    
    public void setNoTelephone(String noTelephone){
        this.noTelephone=noTelephone;
    }
    
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail){
        this.mail=mail;
    }
    
    public String getMotDePasse() {
        return this.motDePasse;
    }
    
    public void setMotDePasse(String motDePasse){
        this.motDePasse=motDePasse;
    }
    
    public ProfilAstral getMonProfilAstral() {
        return this.monProfilAstral;
    }
    
    public void setMonProfilAstral(ProfilAstral monProfilAstral){
        this.monProfilAstral=monProfilAstral;
    }
    
    public void ajouterConsultation(Consultation maConsultation) {
        this.historique.add(maConsultation);
    }
    
    public List<Consultation> getHistorique() {
        return this.historique;
    }

    @Override
    public String toString() {
        return "Client: id=" + id + " ; nom=" + nom + " ; prenom=" + prenom + " ; dateNaissance=" + dateNaissance + " ; adressePostale=" + adressePostale + " ; noTelephone=" + noTelephone + " ; mail=" + mail + " ; motDePasse=" + motDePasse;
    }
    
    
}
