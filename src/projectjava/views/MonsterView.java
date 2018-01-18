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
import javax.imageio.ImageIO;
import projectjava.models.Monster;

/**
 *
 * @author Meneer Doos
 */
public class MonsterView {
    
    /**
     * Geeft de afbeelding van een monser op basis van zijn naam
     * 
     * @param naam de naam van het monser
     * @return een Image van het monster
     */
    public Image getImage(String naam){
        BufferedImage afbeelding = null ;
        String afbeeldingPath = "images/"+naam+".png" ;
        
        try{
            afbeelding = ImageIO.read(new File(afbeeldingPath));
        }
        catch(IOException ex){
            
        }
        
        Image image = SwingFXUtils.toFXImage( afbeelding, null );
        
        return image ;
    }
    
    /**
     *Geeft de monster zijn battleafbeelding 
     * 
     * @param monsterAfbeelding
     * @return een imageView van de monster zijn battle afbeelding
     */
    public ImageView getMonsterBattleView(String monsterAfbeelding){
        String afbeeldingPath = "images/"+ monsterAfbeelding +".png";
        BufferedImage t = null ;
        
        try {
            t = ImageIO.read(new File(afbeeldingPath));
        } catch (IOException ex) {
            Logger.getLogger(MonsterView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Image image = SwingFXUtils.toFXImage( t, null );
        
        return new ImageView(image);
    }
    
}
