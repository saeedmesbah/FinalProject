/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;
/**
 *
 * @author Saeed & Maryam
 */
public class PeaShooter extends Plant{
    public Timer t;

    private Image imgIcon;

    public PeaShooter(int locationX, int locationY, int life) {
        super(locationX, locationY, life);
        imgIcon =new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Gifs/peashooter.gif")).getImage();
    }
    
    @Override
    public Image getIcon(){
        return imgIcon;
    }
}
