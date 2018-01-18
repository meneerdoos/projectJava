/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.models;

import java.util.ArrayList;
import projectjava.LevelGenerator;

/**
 *
 * @author Meneer Doos
 */
public class Board {
    
    private Speler speler;    
    private String[][] map ;
    private ArrayList<Monster> monsters ;
    private int boardBreedte;
    private int boardHoogte;
    private int level ;
    private int startX;
    private int startY;
    
    //Board
    /**
     *Constructor for objects of class Board
     */
    public Board(){
        speler = new Speler();
        monsters = new ArrayList<Monster>();
        level = 1;
        genereerMap();
        boardBreedte = 50 ;
        boardHoogte = 40 ;     
    }
      
    /**Genereert een nieuwe map voor het board zijn huidig level
     *
     * Door gebruik te maken van de LevelGenerator wordt een nieuw level aangemaakt. 
     * De map van het board wordt ingesteld
     * De monsters worden aangemaakt
     * De beginpositie van de speler wordt ingesteld
     */
    public void genereerMap(){
        LevelGenerator lg = new LevelGenerator();
        map = lg.genereerLevel(level);
        monsters = lg.genereerMonsters(level);
        speler.setX(lg.getBeginX());
        speler.setY(lg.getBeginY());        
    }
    
    /**
     *Geeft de naam van de speler
     *
     * @return naam van de speler 
     */
    public String getSpelerNaam(){
        return speler.getNaam();
    }
    
    /**
     *Stelt de naam van de speler in
     *
     * @param naam naam van de speler
     */
    public void setSpelerNaam(String naam){
        speler.setNaam(naam);
    }
    
    /**
     *Geeft de health van de speler
     *
     * @return de health van de speler
     */
    public String getSpelerHealth(){
        return speler.getHealth();
    }
    
    /**
     *Is de speler dood? 
     *
     * @return true indien de speler dood is
     */
    public boolean spelerIsDood(){
        return speler.isDood();
    }
        
    /**
     *Geeft een lijstvan monsters die op het board staan
     * 
     * @return een lijst met de monsters die op het board staan
     */
    public ArrayList<Monster> getMonsters(){
        return monsters ;
    }
    
    /**
     *Geeft de map van het board en huidig level
     * 
     * @return de map van het board en huidig level
     */
    public String[][] getMap(){
        return map ;
    }
    
    /**
     *Geeft de x coördinaat van de speler
     * 
     * @return de x coördinaat van de speler
     */
    public int getSpelerX(){
        return speler.getX();
    }
    
    /**
     *Geeft de y coördinaat van de speler
     * 
     * @return de y coördinaat van de speler
     */
    public int getSpelerY(){
        return speler.getY();
    }
    
    /**
     *Geeft de hoogte van het board
     * 
     * @return de hoogte van het board
     */
    public int getBoardHoogte(){
        return boardHoogte;
    }
    
    /**
     *Geeft de breedte van het board 
     *
     * @return de breedte van het baord
     */
    public int getBoardBreedte(){
        return boardBreedte;
    }
    
    /**
     *Beweeg naar links op het Board
     * 
     * verandert de coördinaten van de speler met één positie naar links
     */
    public void beweegLinks(){
        speler.naarLinks();
    }
    
    /**
     *Beweeg naar rechts op het board
     * 
     * verandert de coördinaten van de speler met één positie naar rechts     * 
     */
    public void beweegRechts(){
        speler.naarRechts();
    }
    
    /**
     *Beweeg omlaag op het board
     * 
     * verandert de coördinaten van de speler met één positie naar omlaag
     */
    public void beweegOmlaag(){
        speler.naarOmlaag();
    }
    
    /**
     *Beweeg omhoog op het board
     * 
     * verandert de coördinaten van de speler met één positie naar omhoog
     */
    public void beweegOmhoog(){
        speler.naarOmhoog();
    }
    
    /**
     *Kijkt of het vakje betreedbaar is
     * 
     * 
     *
     * @param x de x coördinaat van het vakje
     * @param y de y coördinaat van het vakje
     * @return true als het vakje betreedbaar is
     */
    public boolean checkBetreedbaar(int x, int y){
        int spelerX = getSpelerX();
        int spelerY = getSpelerY();
        if ( getSpelerX()+x<0 || getSpelerX()+x>49 || getSpelerY()+y<0 || getSpelerY()+y>39 ){
            return false;
        }
        
        return map[getSpelerY()+y][getSpelerX()+x] != "0" ;
    }
    
    /**
     *Kijkt of het vakje trappen zijn
     * @return true als het vakje trappen zijn
     */
    public boolean checkTrappen(){
        return map[getSpelerY()][getSpelerX()]=="2";
    }
    
    /**
     *Kijkt of er een monster op het vakje staat
     * 
     * Kijkt in de lijst van monsters als er een positie overeen komt met de positie van de speler
     * 
     * @return true als er een monster op het vakje staat
     */
    public boolean checkMonster(){
        for( Monster monster:monsters ){
            if( monster.getX() == speler.getX() && monster.getY()==speler.getY()){
                if( !monster.isDood() ){
                    return true;
                }
            }
        }
       return false;
    }
    
    /**
     *Verhoogt het level van het board
     * 
     * Het level wordt verhoogt en er wordt een nieuwe map voor het board gegenereert
     */
    public void levelOmhoog(){
       this.level++;
        genereerMap();
    }
    
    /**
     *Geeft de speler die op het board staat 
     * 
     * @return de speler die op het board staat
     */
    public Speler getSpeler(){
        return speler;
    }
    
    /**
     *Geeft het monster wat op het vakje van de speler staat
     * 
     * @return het monster dat op het vakje van de speler staat
     */
    public Monster getMonster(){
        Monster monsterN = null ;
        for( Monster monster:monsters ){
            if(monster.getX() == speler.getX() && monster.getY()==speler.getY()){
                return monster;
            }
        }
        return monsterN;
    } 
}
