/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import projectjava.models.Card;

/**
 *
 * @author Meneer Doos
 */
public class Deck {
    
    private Card[] deck;
    private int currentCard;
    private int counter =0 ;    
    
    /**
     * Dit is de constructor voor een object van Deck
     */
    public Deck (){
        String[] soorten = {"harten","koeken", "klaveren","schoppen"};
        String[] namen = {"aas","2","3","4","5","6","7","8","9","10","boer","koningin","koning"};                
        deck = new Card[52];                   
        for (int soort= 0; soort < 4 ; soort++){
            for(int naam=0; naam < 13 ; naam++ )
            {
                deck[ ( soort*13+naam ) ] = new Card(soorten[soort],soort, namen[naam], naam );
            }
        }        
    }
    
    /**
     * De kaarten van het deck worden geschud
     */
    public void schudden(){
        Random rd = new Random();        
        for (int i = 0; i < deck.length; i++){
            int random = rd.nextInt(52);
            Card kaart = deck[i];
            deck[i]= deck[random];
            deck[random]= kaart;
        }
    }
    
    /**
     * Er wordt een kaart getrokken
     * de kaart die getrokken wordt zal worden teruggegeven
     * @return de kaart die getrokken wordt
     */
    public Card trekKaart(){
        if( counter == 52){
            schudden() ;
            counter = 0;
        }
        Card kaart = deck[counter];
        counter++;
        return kaart;
    }
}
