/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.views;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import projectjava.models.Battle;
import projectjava.models.Board;
import projectjava.models.Card;

/**
 *
 * @author Meneer Doos
 */
public class BattleView extends Region {
    private Pane monsterCanvas;
    private Pane cardCanvas;
    private Battle battle;
    
    private MonsterView monsterView;
    
    /**
     * De constructor voor een object van BattleView
     * 
     * Het monster- en kaartcanvas en Battle wordt ingesteld. 
     * De portraits worden afgebeeld.
     *
     * @param monsterCanvas het monsterCanvas voor de afbeelding van het monster op te plaatsen
     * @param cardCanvas het cardCanvas voor de kaarten op te plaatsen
     * @param battle het model met de bijhorend info
     */
    public BattleView (Pane monsterCanvas, Pane cardCanvas,Battle battle){
        this.monsterCanvas = monsterCanvas;
        this.cardCanvas = cardCanvas;
        this.battle = battle;
        setPortraits();
    }
    
    /**
     * Stelt de afbeeldingen in
     * 
     * De kaartcanvas en mosntercanvas worden gewist. Het monster wordt getoond.
     */
    public void setPortraits(){
        monsterCanvas.getChildren().clear();
        cardCanvas.getChildren().clear();
        
        monsterView = new MonsterView();
        
        Node monsterPortret = monsterView.getMonsterBattleView(battle.getMonsterAfbeelding());
        monsterCanvas.getChildren().add(monsterPortret);        
    }
    
    /**
     * Toont de kaarten
     * 
     * Zal voor elke kaart een KaartView omvormen naar Node en deze op de kaartencanvas tonen
     */
    public void updateKaarten(){
        int kaartnummer = 0;
        cardCanvas.getChildren().clear();
        for ( Card kaart: battle.getHand() ){
            if( kaart != null ){
                CardView kaartView = new CardView();
                Node nKaartView = kaartView.getKaartView(kaart);
                nKaartView.setTranslateX( kaartnummer * 85 );
                cardCanvas.getChildren().add(nKaartView);
                kaartnummer ++ ; 
            }
        }
    }
}
