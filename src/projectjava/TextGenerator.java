/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import projectjava.models.Monster;

/**
 *
 * @author Meneer Doos
 */
public class TextGenerator {

    /**
     * Genereert een boodschap voor het begin van het gevecht
     *
     * @param monster het monster waar
     * @return de gegenereerde tekst
     */
    public String startGevecht( String monsterNaam){
                return "Your presence hasn't gone unnoticed.\n A "+ monsterNaam+ " appears and start attacking you." ;
        
    }
    
    /**
     * Genereert een tekst voor als er aangevallen wordt
     *
     * @param aanvalSpeler de aanval van de speler
     * @param aanvalMonster de aanval van het monster
     * @return de gengenereerde tekst
     */
    public String aanval( String aanvalSpeler, String aanvalMonster){
                return "Your attack does " + aanvalSpeler + "\n"
                        +"The monster hits you for " + aanvalMonster  ;
    }
    
    /**
     * Genereert een tekst voor als de speler meer als 21 heeft
     *
     * @param aanvalMonster de aanval van het monster
     * @return de gegenereerde tekst
     */
    public String counter( String aanvalMonster){
            return "The monster attacks you for  "+ aanvalMonster ;
    }
}
