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
public class Speler {
        private int health ;
        private int x ;
        private int y ;
        private String naam ;
        
    /**
     *Constructor voor een object van Speler
     * 
     * De health van de speler wordt ingesteld
     */
    public Speler(){
           health = 100 ;
        }
        
    /** 
     * Geeft de health van de speler
     * 
     * @return de health van de speler
     */
    public String getHealth(){
            return health +"";
        }
        
    /**
     * Stelt de naam van de speler in 
     *
     * @param naam de naam van de speler
     */
    public void setNaam(String naam){
            this.naam = naam ;
            
        }
        
    /**
     * Geeft de naam van de speler
     * 
     * @return de naam van de speler
     */
    public String getNaam(){
            return naam ;
        }
        
    /**
     * Geeft de x coördinaat van de speler 
     * 
     * @return de x coördinaat van de speler
     */
    public int getX(){
            return x ;
        }
        
    /**
     * Geeft de y coördinaat van de speler
     * 
     * @return de y coördinaat van de speler
     */
    public int getY(){
            return y ;
        }
        
    /**
     * Is de speler dood?
     *
     * @return true als de speler dood is
     */
    public boolean isDood(){
            return ( health <= 0 );
        }
        
    /**
     * Stelt de x coördinaat van de speler in
     *
     * @param x de x coördinaat van de speler
     */
    public void setX(int x){
            this.x = x;   
        }
        
    /**
     * Stelt de y coördinaat van de speler in 
     *
     * @param y de y coördinaat van de speler
     */
    public void setY(int y){
            this.y = y ;
        }
       
    /**
     * De speler wordt aangevallen
     * 
     * De schade wordt van de speler zijn health afgetrokken
     *
     * @param attack de schade die wordt toegebracht
     */
    public void isAangevallen(int attack){
            health -= attack ;
        }
        
    /**
     * De speler beweegt naar rechts
     * 
     * De x coördinaat van de speler wordt met één positie naar rechts gewijzigd
     *
     */
    public void naarRechts(){
            x ++ ;
        }

    /**
     * De speler beweegt naar links
     * 
     * De x coördinaat van de speler wordt met één positie naar links gewijzigd
     *
     */
    public void naarLinks(){
            x -- ;
            
        }
        
    /**
     * De speler beweegt omhoog
     * 
     * De y coördinaat van de speler wordt met één positie naar omhogg gewijzigd
     *
     */
    public void naarOmhoog(){
            y--;
        }
        
    /**
     * De speler beweegt omlaag
     * 
     * De y coördinaat van de speler wordt met één positie naar beneden gewijzigd
     *
     */
    public void naarOmlaag(){
            y++;
        }
}
