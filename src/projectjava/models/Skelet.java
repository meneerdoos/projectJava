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
public class Skelet extends Monster{

     /**
     * Dit is de constructor voor een object van Skelet
     * 
     * De coördinaten van de orc worden ingesteld
     * De naam wordt ingesteld
     * De health wordt ingesteld
     * Het monster is niet dood
     * 
     * @param x de x coördinaat van het monster
     * @param y de y coördinaat van het monster
     */
    public Skelet (int x, int y){
        
        this.x = x ;
        this.y = y ;
        this.naam = "skelet";
        this.health = 50 ;
        this.dood = false ;
    }

    @Override
    public int getAttack() {
        Random r = new Random();
        return r.nextInt(5);
    }
    
        
    
}
