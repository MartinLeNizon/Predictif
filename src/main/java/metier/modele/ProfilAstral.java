package metier.modele;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnguyen
 */
//@Entity
@Embeddable
public class ProfilAstral {
    
    /*@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    */
    private String signeZodiaque;
    private String signeAstrologiqueChinois;
    private String couleurPorteBonheur;
    private String animalTotem;
    
    protected ProfilAstral(){
        
    }
    
    public ProfilAstral(String signeZodiaque, String signeAstrologiqueChinois, String couleurPorteBonheur, String animalTotem){
        this.signeZodiaque=signeZodiaque;
        this.signeAstrologiqueChinois=signeAstrologiqueChinois;
        this.couleurPorteBonheur=couleurPorteBonheur;
        this.animalTotem=animalTotem;
    }
    
    /*public Long getId(){
        return this.id;
    }*/
    
    public String getSigneZodiaque() {
        return this.signeZodiaque;
    }
    
    public void setSigneZodiaque(String signeZodiaque){
        this.signeZodiaque=signeZodiaque;
    }
    
    public String getSigneAstrologiqueChinois() {
        return this.signeAstrologiqueChinois;
    }
    
    public void setSigneAstrologiqueChinois(String signeAstrologiqueChinois){
        this.signeAstrologiqueChinois=signeAstrologiqueChinois;
    }
    
    public String getCouleurPorteBonheur() {
        return this.couleurPorteBonheur;
    }
    
    public void setCouleurPorteBonheur(String couleurPorteBonheur){
        this.couleurPorteBonheur=couleurPorteBonheur;
    }
    
    public String getAnimalTotem() {
        return this.animalTotem;
    }
    
    public void setAnimalTotem(String animalTotem){
        this.animalTotem=animalTotem;
    }
   

    @Override
    public String toString() {
        return "Profil Astral : signeZodiaque=" + signeZodiaque + " ; signeAstrologiqueChinois=" + signeAstrologiqueChinois + " ; couleurPorteBonheur=" + couleurPorteBonheur + " ; animalTotem=" + animalTotem;
    }
    
    
}
