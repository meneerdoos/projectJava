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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javax.imageio.ImageIO;
import projectjava.models.Card;

/**
 *
 * @author Meneer Doos
 */
public class CardView extends Region{
    private Card kaart;   
    private BufferedImage afbeelding = null ;
    private ImageView kaartView = null; 

    /**
     * Geeft de afbeelding van een kaart
     * 
     * @param kaart de kaart waarvan de afbeelding gevraagd is
     * @return een imageView van de kaart
     */
    public ImageView getKaartView(Card kaart){
        try {
            String afbeeldingPath = "kaarten/"+kaart.getAfbeeldingNaam()+".jpg";
            afbeelding = ImageIO.read(new File(afbeeldingPath));
        } catch (IOException ex) {
            Logger.getLogger(CardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image image = SwingFXUtils.toFXImage( afbeelding, null );

        kaartView = new ImageView(image); 
        return this.kaartView ;
    }
}
