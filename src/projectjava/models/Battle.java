/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.models;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Meneer Doos
 */
public class Battle {
    private Deck deck ;
    private Hand hand ;
    private Monster monster ;
    private Speler speler;
    private MediaPlayer fightingTheme ;
    
    /**
     *
     * Creëert een nieuw gevecht
     * 
     * @param speler de speler die de battle aangaat
     * @param monster het mosnter die de battle aangaat
     */
    public Battle(Speler speler,Monster monster){
        this.speler = speler ;
        this.monster = monster;
        deck = new Deck();
        deck.schudden();
        hand = new Hand();
        delen();
    }
    
    /**
     * Deelt de kaarten
     * 
     * Er worden twee kaarten getrokken en aan de hand toegevoegd
     * 
     */
    public void delen(){
        for ( int i = 0; i<2; i++ ){
             Card kaart = deck.trekKaart();
             hand.add(kaart);
        }
    }

    /**
     * Geeft de afbeelding van het monster voor de 
     *
     * 
     * @return de naam van de battle afbeelding van het monster
     */
    public String getMonsterAfbeelding(){
        return monster.getBattleAfbeelding() ;
    }
    
    /**
     * Is het monster dood?
     * 
     * @return true als het monster dood is
     */
    public boolean isMonsterDood(){
        return monster.isDood();
    }
    
    /**
     * Is het monster de eindbaas?
     * 
     * @return true als het monster de eindbaas is
     */
    public boolean isMonsterBaas(){
        return (Double.parseDouble(monster.getHealth())>230);
    }
    
    /**
     *
     * Is de speler dood?
     * 
     * @return true als de speler dood is
     */
    public boolean isSpelerDood(){
        return speler.isDood();
    }      
   
    /**
     * Er wordt een kaart getrokken
     * 
     * Een kaart wordt uit het deck getrokken en aan de hand toegevoegd
     * 
     */
    public void trekEenKaart(){
        hand.add(deck.trekKaart());
    }
    
    /**
     *Geeft de hand van de speler
     * 
     * @return de hand van de speler
     */
    public Card[] getHand(){
        return hand.getHand();
    }
    
    /**
     * Geeft de aanvalpunten van de speler
     * 
     * @return de aanvalpunten van de speler
     */
    public String getSpelerAttack(){
        return hand.getAttack();
    }
    
    /**
     * Geeft de health van het monster
     * 
     * @return de health van het monster
     */
    public String getMonsterHealth(){
        return monster.getHealth();
    }
    
    /**
     * Geeft de health van de speler
     * 
     * @return de health van de speler
     */
    public String getSpelerHealth(){
        return speler.getHealth();
    }
    
    /**
     * Berekent de penalty
     * 
     * Wanneer de speler meer als 21 in zijn hand heeft
     * zal het monster aanvallen
     * Het monster zal aanvallen, er wordt een nieuwe hand aangemaakt 
     * en de kaarten worden uitgedeeld
     * De waarde van de aanval van het monster wordt teruggegeven
     *
     * @return de waarde van de aanval van het monster
     */
    public String penalty(){
         
        if (Integer.parseInt(getSpelerAttack())>21){
            String attack = aanvalMonster();
            hand = new Hand();
            delen();
            return attack ;
        }
        else return "";
    }
    
    /**
     * De speler valt aan
     * 
     * De aanval wordt van de speler wordt berekend
     * Die aanval  zal van de monster zijn health worden afgetrokken
     * Als het monster nog niet dood is
     * zal er een nieuwe hand gemaakt worden en de kaarten gedeeld worden
     * 
     * @return de waarde van de aanval van de speler
     */
    public String aanvalSpeler(){
        String attack = getSpelerAttack();
        //Media hit = new Media(new File("attack.mp3").toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(hit);
        //mediaPlayer.play();
        monster.isAangevallen(Integer.parseInt(attack));               
        
        if(speler.isDood()){
            //fightingTheme.stop();
            
        }
        if (!monster.isDood()){
            hand = new Hand();
            delen();
        }
        
        return attack ;
    }
    
    /**
     * Het monster valt aan
     * 
     * De aanval van het monster wordt opgehaald en teruggegeven
     * de health van de speler wordt ook afgetrokken
     * 
     * @return de attack van het monster
     */
    public String aanvalMonster(){
        int attack = monster.getAttack();
        speler.isAangevallen(attack);
        //Media hit = new Media(new File("attack.mp3").toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(hit);
        //mediaPlayer.play();
        return attack +"";
    }
}
