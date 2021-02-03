
import java.awt.Image;
import java.security.SecureRandom;
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
public class NormalZombie extends Zombie{
    private Image imgIcon;
    private SecureRandom generator = new SecureRandom();
    private int locationX;
    private int locationY;
    private int health=200;
    

    public NormalZombie(int damage) {
        super(damage);
        locationX=8;
        locationY=generator.nextInt(5);
        imgIcon =new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Gifs/zombie_normal.gif")).getImage();
    }
    
    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public void setDamage(int damage) {
        super.setDamage(damage);
    }
    
    // set method for health
    @Override
    public void setHealth(int health){
        this.health=health;
    }
    // get method for health
    @Override
    public int getHealth(){
        return health;
    }
    
    @Override
    public Image getIcon(){
        return imgIcon;
    }
}
