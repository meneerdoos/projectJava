/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.Random;

/**
 *
 * @author Meneer Doos
 */
public class NaamGenerator {
    
    private String[] prefix1 = {"","the brave", "the unknown", "the cowardly", "the mighty", "the fallen"} ;
    private String[] prefix2 = {"","warrior","dragonslayer","trickster","joker","shield"};
    
    /**
     * Genereert een willekeurige naam op basis van de doorgevoerde naam
     *
     * @param naam de naam die gebruikt wordt om te genereren
     * @return
     */
    public String generateNaam(String naam){
        Random r1 = new Random();
        
        return naam +"," + prefix1[r1.nextInt(5)] +" "+ prefix2[r1.nextInt(5)];
    }
}
