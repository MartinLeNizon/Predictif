package metier.modele;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance (strategy=InheritanceType.JOINED)
public abstract class Medium {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;
    protected String denomination;
    protected String genre;
    protected String presentation;
    @OneToMany(mappedBy="medium")
    private List<Consultation> historique;
    
    public Medium(){}
    
    public Medium(String denomination, String genre, String presentation){
        this.denomination=denomination;
        this.genre=genre;
        this.presentation=presentation;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public String getDenomination() {
        return this.denomination;
    }
    
    public void setDenomination(String denomination){
        this.denomination=denomination;
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre){
        this.genre=genre;
    }
    
    public String getPresentation() {
        return this.presentation;
    }
    
    public void setPresentation(String presentation){
        this.presentation=presentation;
    }
    
    public void ajouterConsultation(Consultation maConsultation) {
        this.historique.add(maConsultation);
    }
    
    public List<Consultation> getHistorique() {
        return this.historique;
    }

    @Override
    public String toString() {
        return "Medium: id = " + id ;
    }
    
    
    
    
    
}
