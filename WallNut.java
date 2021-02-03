
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saeed & Maryam
 */
public class WallNut extends Plant {

    private Image imgIcon;

    public WallNut(int locationX, int locationY, int life) {
        super(locationX, locationY, life);
        imgIcon =new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Gifs/walnut_full_life.gif")).getImage();
    }
    
    @Override
    public Image getIcon(){
        return imgIcon;
    }
    
}
