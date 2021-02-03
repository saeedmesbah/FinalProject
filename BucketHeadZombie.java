
import java.awt.Image;
import java.security.SecureRandom;
import javax.swing.ImageIcon;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/


/**
* Class for Bucket Head Zombie that extends from zombie and has a bucket on his head

*/
public class BucketHeadZombie extends Zombie{
private Image imgIcon;
private SecureRandom generator = new SecureRandom();
private int locationX;
private int locationY;
private int speedMovement;
private int health=1300;

/**
* constructor for Bucket Head Zombie
*/
public BucketHeadZombie(int damage) {
super(damage);
locationX=8;
locationY=generator.nextInt(5);
imgIcon =new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Gifs/bucketheadzombie.gif")).getImage();
}

/**
* to get the damage that the zombie has taken
* @return damage as int
*/
@Override
public int getDamage() {
return super.getDamage();
}

/**
* to set damage that zombie has to take
* @param damage that we assign to zombie
*/

@Override
public void setDamage(int damage) {
super.setDamage(damage);
}

/**
* to set health
* @param health that we assign to zombie and it means how long he can live
*/
@Override
public void setHealth(int health){
this.health=health;
}

/**
* to get zombies health
* @return health as int
*/
@Override
public int getHealth(){
return health;
}

/**
* Overridden method for getting image icon
* @return image icon as image
*/

@Override
public Image getIcon(){
return imgIcon;
}

/**
* gets the zombies movement speed
* @return speedMovement as int
*/
@Override
public int getSpeedMovement() {
return speedMovement;
}

/**
* to half the speed of the zombie in case he gets shot by FreezeBullet
*/

@Override
public void halfSpeedMovement() {
speedMovement=1;
}

/**
* to check how much of the zombies health is left to change his image
*/
public void checkHealth(){
if(getHealth()<=200)
imgIcon =new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Gifs/zombie_normal.gif")).getImage();
}

}
