/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.models;

import java.awt.image.BufferedImage;

/**
 *
 * @author Meneer Doos
 */
public class Card {
   private String soortNaam, naam ;
   private int waarde, soortWaarde ;
   private BufferedImage cardImage; 
   
    /**
     * Dit is de constructor voor een object van Card
     * 
     * @param soort de soort van de kaart
     * @param soortWaarde de waarde van de soort
     * @param naam de naam van de kaart
     * @param naamWaarde de waarde van de kaart
     */
    public Card(String soort, int soortWaarde, String naam, int naamWaarde ){
       this.soortNaam = soort ;
       this.soortWaarde = soortWaarde ;
       this.naam = naam ;
       this.waarde = naamWaarde ;
       
    }
//   
//    /**
//     *
//     * @param soort
//     * @param naam
//     * @param waarde
//     * @param card
//     */
//    public Card(String soort, String naam, int waarde, BufferedImage card){
//       this.soortNaam = soort ;
//       this.naam = naam;
//       this.waarde = waarde;
//       this.cardImage = card ;
//   }
   
//    /**
//     *
//     * @param soort
//     * @param naam
//     * @param waarde
//     */
//    public Card(String soort, String naam, int waarde){
//       this.soortNaam = soort ;
//       this.naam = naam;
//       this.waarde = waarde;
//   }

    /**
     * Geeft de waarde van de kaart
     *
     * @return de waarde van de kaart
     */
    public int getValue(){
       if (this.waarde > 9){
           return 10 ;
       }       
       return this.waarde+1  ;
    }
   
    /**
     * Geeft de naam van de kaart
     * 
     * @return de naam van de kaart
     */
    public String getName(){
       return this.naam ;
    }
   
//    /**
//     *Geeft de waarde van de soort
//     * 
//     * @return
//     */
//    public int getSoortValue(){
//       return this.soortWaarde ;
//    }
    
    /**
     * Geeft de naam van de afbeelding
     * 
     * @return de naam van de afbeelding
     */
    public String getAfbeeldingNaam(){
       return Integer.toString(this.soortWaarde)+Integer.toString(this.waarde+1);
    }    
}
