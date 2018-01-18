package projectjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import projectjava.models.Battle;
import projectjava.views.BattleView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Meneer Doos
 */
public class BattleController {

    private Battle model;
    private BattleView battleView;
    private TextGenerator texthelper;
    private Stage stage ;
    private BoardController mainController ;
        
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label monsterHealthLabel;

    @FXML
    private Pane monsterAfbeelding;

    @FXML
    private Pane playerPane;

    @FXML
    private Button attackButton;

    @FXML
    private Button hitButton;

    @FXML
    private TextArea textBox;

    @FXML
    private Label playerHealthLabel;

    @FXML
    private Pane cardBox;

    @FXML
    private Label playerAttackLabel;

    @FXML
    void initialize() {
        hitButton.setOnAction(event-> {hit();});
        attackButton.setOnAction(event->{attack();});
        assert monsterHealthLabel != null : "fx:id=\"monsterHealthLabel\" was not injected: check your FXML file 'Battle.fxml'.";
        assert monsterAfbeelding != null : "fx:id=\"monsterAfbeelding\" was not injected: check your FXML file 'Battle.fxml'.";
        assert playerPane != null : "fx:id=\"playerPane\" was not injected: check your FXML file 'Battle.fxml'.";
        assert attackButton != null : "fx:id=\"attackButton\" was not injected: check your FXML file 'Battle.fxml'.";
        assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'Battle.fxml'.";
        assert textBox != null : "fx:id=\"textBox\" was not injected: check your FXML file 'Battle.fxml'.";
        assert playerHealthLabel != null : "fx:id=\"playerHealthLabel\" was not injected: check your FXML file 'Battle.fxml'.";
        assert cardBox != null : "fx:id=\"cardBox\" was not injected: check your FXML file 'Battle.fxml'.";
        assert playerAttackLabel != null : "fx:id=\"playerAttackLabel\" was not injected: check your FXML file 'Battle.fxml'.";
    }
    
    /**
     * Stelt de mainController van de controller in
     * 
     * @param boardController de mainController
     */
    public void setMainController(BoardController boardController){
        this.mainController = boardController;
    }
    
    /**
     * Stelt de Battle(het model) in
     * @param battle de battle
     */
    public void setBattle(Battle battle){
        this.model = battle;
        battleView = new BattleView(monsterAfbeelding, cardBox, model);
        updateLabels();
    }
    
    /**
     * update de labels van de battle en de kaarten
     * 
     * Het health van het monster, health van de speler, de attack van de speler 
     * en de kaarten
     */
    public void updateLabels(){
        monsterHealthLabel.setText(model.getMonsterHealth());
        playerHealthLabel.setText(model.getSpelerHealth());
        battleView.updateKaarten();
        playerAttackLabel.setText(model.getSpelerAttack());
    }
    
    /**
     * Vraag om een nieuwe kaart
     * 
     * Er wordt een nieuwe kaart getrokken en gekeken als de speler niet meer als 21 heeft
     *
     * 
     */
    public void hit(){
        model.trekEenKaart();
        if( model.penalty() != "" ){
            if( model.isSpelerDood()){
                    updateLabels();
            showLooseScreen();
            return;
            }
        }
        updateLabels();
    }
    
    /**
     * De speler beslist om aan te vallen en er wordt gekeken als er een ander
     * scherm getoond moet worden
     * 
     * De speler valt aan en het monster zal dan dus ook aanvallen
     * Als het monster dood is, zal het board teruggetoond worden
     * Als de speler dood is, zal het verliesscherm getoond worden
     * Als de eindbaas verslagen is zal het winscherm getoond worden
     * 
     */
    public void attack(){
        String spelerAanval = model.aanvalSpeler();
        String monsterAanval = "0";
        monsterAanval = model.aanvalMonster();
        updateLabels();
        if( model.isMonsterDood() && model.isMonsterBaas()){
            showWinScreen();
            return;
        }
        if( model.isSpelerDood()){
            showLooseScreen();
            return;
        }
        if( model.isMonsterDood()  ){
            continueBoard();
        }
    }
    
    /**
     * Het board zal terug getoond worden
     */
    public void continueBoard(){
        mainController.continueBoard();
        
    }
    
    /**
     * Het verliesscherm zal getoond worden
     */
    public void showLooseScreen(){
        mainController.showLooseScreen();
    }
    
    /**
     * Het winscherm zal getoond worden
     */
    public void showWinScreen(){
        mainController.showWinScreen();
    }
   
  
    
}
