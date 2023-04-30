/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.modele;

import javax.persistence.Entity;

/**
 *
 * @author mnguyen
 */
@Entity
public class Astrologue extends Medium {

    private String formation;
    private String promotion;

    public Astrologue(){}
    
    public Astrologue(String denomination, String genre, String presentation, String formation, String promotion){
        super(denomination, genre, presentation);
        this.formation=formation;
        this.promotion=promotion;
    }
    
    public String getFormation() {
        return this.formation;
    }
    
    public void setFormation(String formation){
        this.formation=formation;
    }
    
    public String getPromotion() {
        return this.promotion;
    }
    
    public void setPromotion(String promotion){
        this.promotion=promotion;
    }
    
    @Override
    public String toString() {
        return super.toString() + " ; Type  = " + this.getClass().getSimpleName() + " ; Denomination = " + denomination + " ; Genre = " + genre + " ; Presentation = " + presentation + " ; Formation = " + formation + " ; Promotion = " + promotion;
    }
    
    
}
