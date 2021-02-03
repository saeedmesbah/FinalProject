import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
* This class manages the state of the game and contains all the elements
* This class also get input from user
*/
public class Controller implements Runnable{

    private ArrayList<Sun> suns;
    private int score=100;
    private int getX;
    private int getY;
    private Plant[][] plants;
    private ArrayList<Zombie> zombies;
    private ArrayList<Chopper> choppers;
    private ArrayList<Bullet> bullets;
    private int level = 1;
    private int wave;
    private long time;
    private boolean result;
    private int plantType;
    private GUI gui;
    private long timeCardSun;
    private long timeCardPea;
    private long timeCardWall;
    private long timeCardFreeze;
    private long timeCardCherry;
    private int state;
    


    public Controller() {
        this.score = 0;
        this.getX = 0;
        this.getY = 0;
        plants = new Plant[5][9];
        zombies = new ArrayList<>();
        this.level = 0;
        this.wave = 0;
        gui=new GUI();
        time = System.currentTimeMillis();
        timeCardSun=System.currentTimeMillis();
        timeCardPea=System.currentTimeMillis();
        timeCardWall=System.currentTimeMillis();
        timeCardFreeze=System.currentTimeMillis();
        timeCardCherry=System.currentTimeMillis();
    }
    //// random creation zombie
    public void addZombie () {
    // Zombie zombie = new NormalZombie();
    // zombie.setLocationX(100);
    // zombies.add(zombie);
    }

    public boolean endGame(){
        for(Zombie z:zombies){
            if(z.getLocationX()==0){
            result=false;
            return true;
            }
        }
        if(time==480000&&zombies.isEmpty()){
            result=true;
            return true;
        }
        /////////////////
        else{
            return false;
        }
    }

    public void rainSun(){
        Sun sun=new Sun();
        suns.add(sun);
    }

    public void putPlant(int x,int y) throws InterruptedException{
        Thread.sleep(1000);

        if(y<50 && y>1){
            if(x>10 && x<60 && score>50 && System.currentTimeMillis() - timeCardSun >= 7500){} // plant sun
            if(x>60 && x<110 && score>100 && System.currentTimeMillis() - timeCardPea >= 7500){} // plant peashooter
            if(x>110 && x<160 && score>50 && System.currentTimeMillis() - timeCardWall >= 30000){} // plant wallnut
            if(x>160 && x<210 && score>150 && System.currentTimeMillis() - timeCardFreeze >= 30000){} // plant bomb
            if(x>210 && x<260 && score>175 && System.currentTimeMillis() - timeCardCherry >= 7500){} // plant freez
        }

        // get clicked x for x location
        // get clicked y for y location
        int newX=(x-44)/100;
        int newY=(y-109)/120;
        
        // SunFlower
        if(plantType==1){   
            Plant plant=new SunFlower(newX,newY,50);
            if(plants[newX][newY]==null){
                plants[newX][newY]=plant;
            }
            plantType=-1;
            timeCardSun=System.currentTimeMillis();
        }
        
        // PeaShooter
        if(plantType==2){ 
            Plant plant=new PeaShooter(newX,newY,70);
            if(plants[newX][newY]==null){
                plants[newX][newY]=plant;
            }
            plantType=-1;
            timeCardPea=System.currentTimeMillis();
        }
        
        // FreezePeaShooter
        if(plantType==3){
            Plant plant=new FreezePeaShooter(newX,newY,150);
            if(plants[newX][newY]==null){
                plants[newX][newY]=plant;
            }
            plantType=-1;
            timeCardFreeze=System.currentTimeMillis();
        }
        
        // WallNut
        if(plantType==4){
            Plant plant=new WallNut(newX,newY,100);
            if(plants[newX][newY]==null)
                plants[newX][newY]=plant;
            plantType=-1;
            timeCardWall=System.currentTimeMillis();
        }
        
        //CherryBomb
        if(plantType==5){
            Plant plant=new CherryBomb(newX,newY,70);
            if(plants[newX][newY]==null){
                plants[newX][newY]=plant;
            }
            plantType=-1;
            timeCardCherry=System.currentTimeMillis();
        }


}

@Override
    public void run(){
        score = 100;
        



        // have to produce sun according to time
        //
        if (System.currentTimeMillis() - time >= 50000) {
        // have to produce zombie according to time and level

        //
        // addZombie();
        }
        // have to check the game

        //

    }

    public void start() {

    }
    /**
    * plays music based on file name
    * @param fileName
    * @param wait
    * @throws IOException
    * @throws UnsupportedAudioFileException
    * @throws LineUnavailableException
    * @throws InterruptedException
    */



    public void playMusic(String fileName,int wait) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        File file = new File(fileName);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        Thread.sleep(wait);
    }

    /**
    * to kill zombies around cherry bomb
    */

    public void checkCherryBomb() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (plants[i][j] instanceof CherryBomb) {
                    for (Zombie z: zombies) {
                        if (z.getLocationX() - plants[i][j].getLocationX() == 1 || z.getLocationY() - plants[i][j].getLocationY() == 1) {
                            zombies.removeIf(zombie -> zombie.equals(z));
                        }

                    }
                }
            }
        }
    }

    /**
    * to produce sun from Sun Flower
    */

    public void sunFlowerSunRain() {
        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < 9; j++) {
                if (plants[i][j] instanceof SunFlower) {
                    suns.add(new Sun(plants[i][j].getLocationX(),plants[i][j].getLocationY()));
                }
            }
        }
    }

    /**
    * to shoot zombies with bullets shot from plants
    */
    public void shootZombies() {
        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < 9; j++) {
                if (plants[i][j] instanceof FreezePeaShooter || plants[i][j] instanceof PeaShooter) {
                    for (Zombie z: zombies) {
                        if (z.getLocationY() == plants[i][j].getLocationY()) {
                            if (plants[i][j] instanceof PeaShooter) {
                                //new freeze pea
                                bullets.add(new Pea(plants[i][j].getLocationX(),plants[i][j].getLocationY()));
                            }
                            else if (plants[i][j] instanceof FreezePeaShooter) {
                            //new pea shooter
                                bullets.add(new FreezePea(plants[i][j].getLocationX(),plants[i][j].getLocationY()));
                            }
                        }
                    }

                }
            }
        }
    }   

    /**
    * to reduce zombies remaining health after getting shot with bullets
    */
    public void zombieDamage(){
        for (Bullet b:bullets) {
            for (Zombie z:zombies) {
                if (b instanceof Pea && b.getLocationX() == z.getLocationX() && b.getLocationY() == z.getLocationY()) {
                    z.setHealth(z.getHealth() - 30);
                    bullets.removeIf(bullet -> bullet.equals(b));
                }
                else if (b instanceof FreezePea && b.getLocationX() == z.getLocationX() && b.getLocationY() == z.getLocationY()) {
                    z.setHealth(z.getHealth() - 35);
                    z.halfSpeedMovement();
                    bullets.removeIf(bullet -> bullet.equals(b));
                }
            }
        }
    }

    /**
    * to reduce plants remaining health after getting hurt from zombie
    */

    
    /**
    * to reduce plants remaining health after getting hurt from zombie
    */

    public void damagePlants() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                for (Zombie z:zombies) {
                    if (plants[i][j].getLocationY() == z.getLocationY() && plants[i][j].getLocationX() == z.getLocationX() && plants[i][j]!=null) {
                        plants[i][j].setLife(plants[i][j].getLife()-z.getDamage());
                        if (plants[i][j].getLife() <= 0) {
                            plants[i][j] = null;
                        }
                    }

                }
            }
        }
    }
    
    /**
    * kill zombies using chopper
    */
    public void chopperKillZombies() {
        for (Chopper c:choppers) {
            for (Zombie z:zombies) {
                if (c.getLocationX() == z.getLocationX() && c.getLocationY() == z.getLocationY()) {
                    c.moveChopper();
                    zombies.removeIf(zombie -> zombie.equals(z));
                }
            }
        }
    }

}