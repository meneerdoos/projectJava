/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

/**
 *
 * @author Meneer Doos
 */
public class Tile {
    
    /**
     * Geeft de afbeelding van de een vakje op de map
     * 
     * @param i de waarde van het vakje
     * @return
     * @throws IOException
     */
    public Image getTile(String i) throws IOException{
        BufferedImage afbeelding = null  ;
        String afbeeldingPath=null;
        switch(i){
            case "1": afbeeldingPath = "images/1.png";
                    break;
            case "0": afbeeldingPath = "images/0.png";
                    break;
            case "2": afbeeldingPath = "images/trap.png";
                    break ;
            }
            afbeelding = ImageIO.read(new File(afbeeldingPath));
        Image image = SwingFXUtils.toFXImage( afbeelding, null );
        return image ;
    }
}

