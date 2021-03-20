
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 * @author Saeed & Maryam
 */
public class GUI extends JPanel implements ActionListener {
    Timer t =new Timer(10,this);
    Timer advancerTimer;
    Timer sunProducer;
    Timer zombieProducer;
    
    private SecureRandom generator = new SecureRandom();
      
    int locationY=1100;
    int stepY=2;
    
    private Plant[][] plant;
    private ArrayList<Zombie> zombie;
    private ArrayList<Sun> sun;
    
    private JFrame frame=new JFrame();
    
    private int sunScore=100;
    
    private Image backImage;
    private Image bgImage;
    private Image sunImage;
    private Image peaImage;
    private Image freezeImage;
    private Image wallImage;
    private Image cherryImage;
    private Image shovelImage;
    private Image chopperImage1;
    private Image chopperImage2;
    private Image chopperImage3;
    private Image chopperImage4;
    private Image chopperImage5;
    private Image Zombies;
    private Image Zombies1;
    private Image sunscorImage;
    private Image SunImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/sun.png")).getImage();
    private int counter=0;
    int locationX;
    private JButton b1=new JButton("1. New Game");
    private JButton b2=new JButton("2. Load Game");
    private JButton b3=new JButton("3. Ranking");
    private JButton b4=new JButton("4. Settings");
    private JButton b5=new JButton("5. Quit Game");
    private JMenuItem item=new JMenuItem("Home");
    private  static final Color VERY_Green = new Color(0 ,204, 0);
    private  static final Color Dark_Green = new Color(0 ,153, 0);
    private  static final Color Very_Dark_Green = new Color(0,102,0);
    
    public GUI() {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(1100, 798);
        frame.setLocation(300,200);
        frame.setVisible(true);
        frame.setResizable(false);
        backImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/backyard1.jpg")).getImage();
        bgImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/mainBG.png")).getImage();
        sunImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Cards/card_sunflower.png")).getImage();
        wallImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Cards/card_wallnut.png")).getImage();
        peaImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Cards/card_peashooter.png")).getImage();
        cherryImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Cards/card_cherrybomb.png")).getImage();
        freezeImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Cards/card_freezepeashooter.png")).getImage();
        shovelImage=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/shovel.png")).getImage();
        chopperImage1=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Lawn_Mower.png")).getImage();
        chopperImage2=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Lawn_Mower.png")).getImage();
        chopperImage3=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Lawn_Mower.png")).getImage();
        chopperImage4=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Lawn_Mower.png")).getImage();
        chopperImage5=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Lawn_Mower.png")).getImage();
        Zombies=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/Gifs/coneheadzombie.gif")).getImage();
        Zombies1=new ImageIcon(this.getClass().getResource("PVS Design Kit/images/zombie2.png")).getImage();
        sunscorImage= new ImageIcon(this.getClass().getResource("PVS Design Kit/images/sun.png")).getImage();
        
        sun=new ArrayList<Sun>();
        zombie=new ArrayList<Zombie>();
        
    }
    
    public void setPlantArray(Plant[][] plants){
        this.plant=plants;
    }
    
    public void setSunArray(ArrayList<Sun> sun){
        this.sun=sun;
    }
    
    public void setZombieArray(ArrayList<Zombie> zombies){
        this.zombie=zombies;
    }
    
    public void setSunScore(int sun){
        sunScore=sun;
    }
    public void start(){
        
    }
    
    
    @Override
    public void paintComponent(Graphics g2) {
        
        repaint();
        super.paintComponent(g2);
        Graphics2D g = (Graphics2D) g2;
        g.drawImage(backImage, 0, 0,1100,798, null);
        g.drawImage(sunImage, 270, 10, null);
        g.drawImage(wallImage, 340, 10, null);
        g.drawImage(peaImage, 410, 10, null);
        g.drawImage(cherryImage, 480, 10, null);
        g.drawImage(freezeImage, 550, 10, null);
        g.drawImage(shovelImage, 710, 10, null);
        
        g.drawImage(chopperImage1, 100,110, null);
        g.drawImage(chopperImage1, 100,110+130, null);
        g.drawImage(chopperImage1, 100,110+260, null);
        g.drawImage(chopperImage1, 100,110+390, null);
        g.drawImage(chopperImage1, 100,110+520, null);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString(""+sunScore, 215, 96);
         

        
        //g.drawImage(sunscorImage,220+(0*94), 130+(2*130), null);                // 220+(0*94)=x   130+(2*130)=y
        
        
//        g.drawImage(sunscorImage,y , locationY, null);
//        t.start();
//        if( locationY==y ){
//            t.stop();
//        }
        
        
//        g.drawImage(Zombies, locationY, 90,130,130, null);
//        t.start();
//        if( locationY==200){
//            g.drawImage(Zombies1, locationY, 90, null);
//            t.stop();
//        }
        
//        // darwing plants
//        for(int j=0;j<5;j++){
//            for(int i=0;i<9;i++){
//                if(p[i][j]!=null)
//                    g.drawImage(p[i][j].getIcon(), (p[i][j].getLocationX()*100)+44, (p[i][j].getLocationY()*120)+109, null);
//            }
//        }
//        // drawing zombies
//        if(!z.isEmpty()){
//            for(Zombie z:z){
//                g.drawImage(z.getIcon(), (z.getLocationX()*100)+44, (z.getLocationY()*120)+109, null);
//            }
//        }
        
        
        
//        t.start();
//        for(Sun s:sun){
//            
//            g.drawImage(s.getSunImage(),(s.getLocationX()*94)+220, locationY, null);
//            
//            if(locationY==700){
//                t.stop();
//            }
//        }
       
        
        g.drawImage(Zombies, locationY,(locationX*94)+220 ,null);
        t.start();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(locationY>1100){
            locationY=0;
            locationX=generator.nextInt(5);
        }
        
        locationY=locationY-stepY;
        
    }
    
    
    
    /**
    * to create sun and add them to array list
    */

//    public void createSun(){
//        for(int i=0;i<2;i++){
//            Sun s=new Sun();
//            sun.add(s);
//            counter++;
//        }
//    }
    
    
    
    
    /**
     * 
     */
    private class buttonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
                
            }
            if(e.getSource()==b2){
                
            }
            if(e.getSource()==b3){
                
            }
            if(e.getSource()==b4){
                
            }
            if(e.getSource()==b5){
                System.exit(0);
            }
            if(e.getSource()==item){
                
            }
        }
    }

    
}
