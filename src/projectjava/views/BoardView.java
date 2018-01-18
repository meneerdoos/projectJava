/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.views;

import java.io.IOException;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import projectjava.models.Board;
import projectjava.models.Monster;
import projectjava.models.Tile;

/**
 *
 * @author Meneer Doos
 */
public class BoardView extends Region{
    private Board board;
    private Canvas boardCanvas;
    private Canvas playerCanvas;
    
    /**
     * Dit is de constructor voor een object van BoardView
     *
     * @param board het Board (model)
     * @param boardCanvas de canvas van het Board om de vakjes te tekenen  
     * @param playerCanvas de canvas van de speler om de speler te tekenen
     * @throws IOException
     */
    public BoardView(Board board, Canvas boardCanvas, Canvas playerCanvas) throws IOException{
        this.board = board ;
        this.boardCanvas = boardCanvas ;
        this.playerCanvas = playerCanvas ;
        startBoard();
    }
    
    /**
     * Start het board en tekent alle vakjes van het Board
     * 
     * @throws IOException
     */
    public void startBoard() throws IOException{
        String [][] map = board.getMap();
        for(int i =0; i<board.getBoardHoogte(); i++){
            for (int j = 0; j<board.getBoardBreedte(); j++){
                Image image = new Tile().getTile(map[i][j]);
                GraphicsContext gc = boardCanvas.getGraphicsContext2D();
                gc.drawImage(image, j*16, i*16);
            }
        }
        
    }
    
    /**
     * Verplaatst de speler een vakje omhoog
     */
    public void omhoog() {
        Image sprite = new SpelerView().getImage("OMHOOG"); 
        GraphicsContext gc = playerCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 50*16, 50*16);
        gc.drawImage(sprite, board.getSpelerX()*16, board.getSpelerY()*16);
        updateMonsters();
        
    }
    
    /**
     * Verplaatst de speler een vakje omlaag
     */
    public void omlaag(){
        Image sprite = new SpelerView().getImage("OMLAAG"); 
        GraphicsContext gc = playerCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 50*16, 50*16);
        gc.drawImage(sprite, board.getSpelerX()*16, board.getSpelerY()*16);
        updateMonsters();

    }
    
    /**
     * Verplaatst de speler een vakje naar links
     */
    public void naarLinks(){
        Image sprite = new SpelerView().getImage("LINKS"); 
        GraphicsContext gc = playerCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 50*16, 50*16);
        gc.drawImage(sprite, board.getSpelerX()*16, board.getSpelerY()*16);
        updateMonsters();

    }
    
    /**
     * Verplaatst de speler een vakje naar rechts
     */
    public void naarRechts(){
        Image sprite = new SpelerView().getImage("RECHTS"); 
        GraphicsContext gc = playerCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 50*16, 50*16);
        gc.drawImage(sprite, board.getSpelerX()*16, board.getSpelerY()*16);
        updateMonsters();

    }

    /**
     * Tekent alle monsters op het 
     */
    public void updateMonsters(){
        for(Monster monster:board.getMonsters()){
            if( !monster.isDood()){
                Image sprite = new MonsterView().getImage(monster.getNaam());
                GraphicsContext gc = playerCanvas.getGraphicsContext2D();
                gc.drawImage(sprite, monster.getX()*16, monster.getY()*16);
            }
        }
    }
}
