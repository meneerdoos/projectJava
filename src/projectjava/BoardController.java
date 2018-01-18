/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import projectjava.models.Battle;
import projectjava.models.Board;
import projectjava.models.Speler;
import projectjava.views.BoardView;

/**
 * FXML Controller class
 *
 * @author Meneer Doos
 */
public class BoardController implements Initializable {
    private Stage stage ;
    private Scene scene ;
    private Board board;
    private BoardView boardView;
    private FXMLDocumentController mainController ;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ProgressBar healthBar;

    @FXML
    private Canvas boardCanvas;

    @FXML
    private Canvas spelerCanvas;
    
    @FXML
    private Label naamLabel;

    @FXML
    void initialize() {       
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert boardCanvas != null : "fx:id=\"boardCanvas\" was not injected: check your FXML file 'Board.fxml'.";
        assert spelerCanvas != null : "fx:id=\"spelerCanvas\" was not injected: check your FXML file 'Board.fxml'.";
        assert naamLabel != null : "fx:id=\"naamLabel\" was not injected: check your FXML file 'Board.fxml'.";
        assert healthBar != null : "fx:id=\"healthBar\" was not injected: check your FXML file 'Board.fxml'.";
    }
    
    /**
     * Stelt de scene
     * 
     * De scene wordt gebruikt om het scherm te wisselen
     *
     * @param scene de scene die ingesteld wordt
     */
    public void setScene(Scene scene){
        this.scene = scene ;
    }
    
    /**
     * Stelt het board in (model)
     * 
     * Stelt het model in en maakt een view aan en geeft deze de focus
     *
     * @param board het Board(model) dat ingesteld wordt 
     * @throws IOException
     */
    public void setBoard(Board board) throws IOException{
        this.board = board;
        naamLabel.setText(board.getSpelerNaam());
        boardView = new BoardView(board,boardCanvas, spelerCanvas);
        boardView.setFocusTraversable(true);
        boardCanvas.setFocusTraversable(true);
        boardCanvas.requestFocus();
        boardCanvas.setOnKeyPressed(this::beweeg);
        boardView.omhoog();
    }
    
    /**
     * Het Board wordt terug getoond
     * 
     * Het board wordt getoond
     * De health van de speler wordt upgedate 
     * 
     */
    public void continueBoard(){
        stage.setScene(scene);
        stage.show();
        healthBar.setProgress( ( (Double.parseDouble(board.getSpelerHealth()))/100 ) );
        boardView.naarRechts();
    }
    
    /**
     * Het verliesscherm wordt getoond
     * 
     */
    public void showLooseScreen(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("looseScreen.fxml"));
            Parent root = null ;
            try {
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene lossScene = new Scene(root);
            stage.setScene(lossScene);
            stage.show();
    }
    
    /**
     * Het verliesscherm wordt getoond
     */
    public void showWinScreen(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("victoryScreen.fxml"));
            Parent root = null ;
            try {
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene winScene = new Scene(root);
            stage.setScene(winScene);
            stage.show();
    }
    
    /**
     * Stelt de stage in
     *
     * @param stage de stage die ingesteld wordt
     */
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    /**
     * Stelt de mainController in
     *
     * @param controller de controller die als mainController wordt ingesteld
     */
    public void setMainController(FXMLDocumentController controller){
        this.mainController = controller;
        
    }
    
    /**
     *Beweegt de speler op het Board
     * 
     * Als het vakje betreedbaar is, zal de speler bewegen
     * Als er een monster op dit vakje staat, zal er een Battle starten.
     * Als er trappen op dit vakje staat, zal het level verhogen
     * 
     * 
     * @param e de toets die ingedrukt wordt
     */
    public void beweeg(KeyEvent e) {
        switch(e.getCode()){
            case RIGHT:            
                if(board.checkBetreedbaar(1,0)){
                    board.beweegRechts();
                    boardView.naarRechts();
                }
                if(board.checkMonster()){
                    startGevecht();
                }
                if(board.checkTrappen()){
                    board.levelOmhoog();
                    try {
                        boardView.startBoard();
                    } catch (IOException ex) {
                        Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    boardView.naarRechts();
                }                
                break;
            case LEFT:
                if(board.checkBetreedbaar(-1,0)){
                    board.beweegLinks();
                    boardView.naarLinks();
                }
                if(board.checkMonster()){
                    startGevecht();
                }
                if(board.checkTrappen()){
                    board.levelOmhoog();
                    try {
                        boardView.startBoard();
                    } catch (IOException ex) {
                        Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    boardView.naarLinks();
                }                
                break;
            case UP:
                if(board.checkBetreedbaar(0,-1)){
                    board.beweegOmhoog();
                    boardView.omhoog();
                }
                if(board.checkMonster()){
                    startGevecht();
                }
                if(board.checkTrappen()){
                    board.levelOmhoog();
                    try {
                        boardView.startBoard();
                    } catch (IOException ex) {
                        Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    boardView.omhoog();
                }                
                break;
            case DOWN:
                if(board.checkBetreedbaar(0,1)){
                    board.beweegOmlaag();
                    boardView.omlaag();
                }
                if(board.checkMonster()){
                    startGevecht();
                }
                if(board.checkTrappen()){
                    board.levelOmhoog();
                    try {
                        boardView.startBoard();
                    } catch (IOException ex) {
                        Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    boardView.omlaag();
                }                
                break;
        }
    }
    
    /**
     * Start een gevecht 
     * 
     * Er wordt een nieuwe Battle gemaakt en de battleView(View) zal getoond worden
     *
     */
    public void startGevecht(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Battle.fxml"));
        Parent root = null ;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        BattleController battleController = loader.getController();
        Battle battle = new Battle(board.getSpeler(),board.getMonster());
        battleController.setBattle(battle);
        battleController.setMainController(this);
        stage.setScene(scene);
        stage.show();
    }
}
