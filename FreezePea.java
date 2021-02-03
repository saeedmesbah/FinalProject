
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
public class FreezePea extends Bullet{

    private Image imgIcon;
    private int damage;
    
    public FreezePea( int locationX, int locationY) {
        super( locationX, locationY);
        this.damage=30;
        imgIcon =new ImageIcon(this.getClass().getResource("PVS Design Kit/images/freezepea.gif")).getImage();
    }
    
    @Override
    public int getDamage() {
        return damage;
    }

    public void setImgIcon(int damage) {
        this.damage = damage;
    }
    
    
    public Image getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(Image imgIcon) {
        this.imgIcon = imgIcon;
    }
    
}
