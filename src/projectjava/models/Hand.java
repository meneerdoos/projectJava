/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.models;

/**
 *
 * @author Meneer Doos
 */
public class Hand {
    private Card[] hand;
    private int aantalKaarten ; 
    private int attack ;
    private boolean heeftElf ;

    /**
     *Dit is de constructor voor objecten van Hand
     * 
     * Er wordt een nieuwe Hand aangemaakt
     * Er worden 7 plaatsen voor kaarten gereserveerd
     * Het aantal kaarten in de hand wordt op nul gezet
     * De attack wordt op 0 gezet
     * De waarde of een speler een aas heeft wordt op false gezet
     */
    public Hand(){
        hand = new Card [7];
        aantalKaarten = 0 ;
        attack = 0;
        heeftElf = false ;
    }
  
   
    /**
     * Er wordt een kaart aan de hand toegevoegd
     * 
     * @param kaart de kaart die aan de hand is toegevoegd
     */
    public void add(Card kaart){
       if( aantalKaarten < 7){
           hand[aantalKaarten] = kaart ;
           attackVerhogen(kaart.getValue());
           aantalKaarten++ ;
       } 
        
    }
    
    /**
     * Verhoogt de attack
     * 
     * Als het een aas is wordt de aanval verhoogd met 10 verhoogd 
     * zolang dit niet hoger als 21 is
     * anders worden de azen naar 1 omgevormd 
     * 
     * @param value de waarde waarmee de attack verhoogd wordt
     */
    public void attackVerhogen(int value){
        if (value == 1 && attack < 11 ){
            heeftElf = true ;
            attack += 11 ;
        }else {
           attack += value ; 
        }
        
        if (attack > 21 && heeftElf ){
            attack = 0;
            for (Card kaart: hand){
                if(kaart != null){
                    attack += kaart.getValue();
                }
            }
        }
    }
    
    /**
     * Geeft de huidige hand
     * 
     * @return de huidige hand
     */
    public Card[] getHand(){
        return hand;
    }
    
    /**
     * Geeft de huidige aanval van de hand
     * 
     * @return de huidige aanval
     */
    public String getAttack(){      
        return attack +"";
    }
    
    /**
     * Geeft het aantal kaarten in de hand
     *
     * @return het aantal kaarten in de hand
     */
    public int getAantalKaarten(){
        return aantalKaarten ;
    }
}
