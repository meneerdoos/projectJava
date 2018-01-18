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
abstract public class Monster {

    protected int health ;
    protected String naam ;
    protected int x ;
    protected int y ;
    protected boolean dood ;
        
//    public Monster(int x, int y,String naam){
//        this.x = x ;
//        this.y = y ;
//        this.naam = naam;
//        health = 50 ;
//        dood = false ;
//    }
//    

    /**
     * Geeft de naam van het monster
     * 
     * @return de naam van het monster
     */
    
    public String getNaam(){
        return naam ;
    }
    
    /**
     * Geeft de health van het monster
     *
     * @return de health van het monster
     */
    public String getHealth(){
        return health + "" ;
    }
    
    /**
     * Geeft de naam van de afbeelding van het monster
     *
     * @return de naam van de afbeelding
     */
    public String getBattleAfbeelding(){
        return "b"+naam;
    }
    
    /**
     * Geeft de attack van het monster
     * 
     * @return de attack van het monster
     */
    public abstract int getAttack();
    
    /**
     * Geeft de x coördinaat van het monster
     *
     * @return de x coördinaat van het monster
     */
    public int getX(){
        return x ;
        
    }
    
    /**
     *
     * Geeft de y coördinaat van het mosnter
     * 
     * @return de y coördinaat vna het monster
     */
    public int getY(){
        return y ;
    }
    
    /**
     * Is de speler dood?
     * 
     * @return true als het monster dood is
     */
    public boolean isDood(){
        return dood ;
    }
    
    /**
     * Doet schade aan het monster
     * De health van het monster wordt met de schade vermindert 
     * Als het monster zijn hp donder 0 is, is hij dood
     * 
     * @param attack de schade die wordt toegebracht
     */
    public void isAangevallen(int attack){
        health = health - attack ; 
        if( health <= 0 ){
            dood = true ; 
        }
    }
}
