/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.models;

import java.util.Random;

/**
 *
 * @author Meneer Doos
 */
public class Geest extends Monster{

    /**
     * De constructor voor een object van Geest
     * 
     * De coördinaten van het monster worden ingesteld en 
     * De naam van het monster wordt ingesteld
     * De health van het monster wordt ingesteld
     * De waarde isDood wordt op false gezet
     * 
     * @param x de x coördinaat van het monster
     * @param y de y coördinaat van het monster
     * 
     */
    public Geest (int x, int y){
        this.x = x ;
        this.y = y ;
        this.naam = "geest";
        this.health = 150 ;
        this.dood = false ;
    }
    
    /**
     * Geeft de attack van het monster
     * 
     * dit is een random waarde tussen 1 en 15 voor een geest
     * @return de attack van het monster
     */
    @Override
    public int getAttack() {
        Random r = new Random();
        return r.nextInt(15);
    }        
}