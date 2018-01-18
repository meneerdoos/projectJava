/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import projectjava.models.Board;
import projectjava.models.Speler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Meneer Doos
 */
public class FXMLDocumentController implements Initializable {
    private Stage stage ;
    private Speler speler ;
    private Board board;
    
    
     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea naamBox;
    
    @FXML
    private Label label;

    @FXML
    private Button startButton;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        genereerNaam();
        startGame();
    } 
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert naamBox != null : "fx:id=\"naamBox\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        board = new Board();
    }

    /**
     * Stelt de stage in
     *
     * @param stage de stage die ingesteld wordt
     */
    public void setStage(Stage stage){
        this.stage = stage ;
    }
    
    /**
     * Start het spel.
     * 
     * Start het spel en stelt de stage, het board en de scene in
     *
     * @throws IOException
     */
    public void startGame() throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Board.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        BoardController boardController = loader.getController();
        boardController.setStage(stage);
        boardController.setBoard(board);
        boardController.setScene(scene);
        
        stage.setScene(scene);
        stage.show();
        
        
    }
      
    /**
     * Genereert een nieuwe naam met de naamGenerator
     * 
     */
    public void genereerNaam(){
        String naam ="";
        NaamGenerator ng = new NaamGenerator();
        if( naamBox.getText().trim().isEmpty()){
            naam = ng.generateNaam("He without a name ");
        }
        else {
            naam = ng.generateNaam(naamBox.getText());
        }        
        board.setSpelerNaam(naam);
    }
}
