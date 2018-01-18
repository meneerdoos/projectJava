/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava.views;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Meneer Doos
 */
public class SpelerView {

    /**
     * Geeft een Image terug waarin de speler wordt afgebeeld in zijn bewegingsrichting
     *
     * @param i de richting waarin de speler beweegt
     * @return
     */
    public Image getImage(String i) {
        BufferedImage afbeelding = null ;
        String afbeeldingPath = null ;
        
        switch(i){
            case "LINKS":
                afbeeldingPath = "images/links.png";
                break;
            case "RECHTS":
                afbeeldingPath = "images/rechts.png";
                break;
            case "OMHOOG":
                afbeeldingPath = "images/omhoog.png";
                break;
            case "OMLAAG":
                afbeeldingPath = "images/omlaag.png";
                break;
        }
        
            try {
                            afbeelding = ImageIO.read(new File(afbeeldingPath));

            }
            catch(IOException ex){
                            Logger.getLogger(SpelerView.class.getName()).log(Level.SEVERE, null, ex);

            }
            
            Image image = SwingFXUtils.toFXImage( afbeelding, null );
            
            return image ;
    }
}
