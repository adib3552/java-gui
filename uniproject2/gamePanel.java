package uniproject2;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Image;
import javax.sound.sampled.*;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class gamePanel extends JPanel implements ActionListener {
    public final int shipSize=16;
    public final int ScreenWidth=shipSize*30;
    public final int ScreenHeight=shipSize*40;
    public int x=shipSize;
    public int y=ScreenHeight-(4*shipSize);
    public int bullet=y-shipSize;
    public int initialX;
    public boolean move=true;
    public boolean gameOver=false;
    public KeyHandler key=new KeyHandler();
    public Image image;
    public boolean ufoVisible=false;
    public int ufoSpawn=0;
    public int ufoX=0;
    public int ufoY=16;
    public Image background;
    public Image blast;
    public Image ufo;
    public Alien[] enemy=new Alien[60];
    public int randomIndex;
    public int randomIndex2;
    public int enemyBulletX;
    public int enemyBulletY;
    public int enemyBulletX2;
    public int enemyBulletY2;
    public int Score=0;
    public int tick=0;
    public File file1;
    public int health=200;
    public boolean moveEnemy=true;
    public Image alienImage1;
    public Image alienImage2;
    public boolean blastUfo=false;
    public int countVisibleEnemy;
    public boolean win=false;
    public boolean enemyFire=true;
    public int highScore;
    public FileWriter save;
    public BufferedReader read;
    public JProgressBar healthBar;
    public Timer timer;
    public int delay=60;
    public int ex=16;
    public int ey=16;
    //Create a panel
    // and instantiate
    gamePanel(){
        image=new ImageIcon("rocket.png").getImage();
        background=new ImageIcon("space.jpg").getImage();
        alienImage1=new ImageIcon("alien3Move1.png").getImage();
        alienImage2=new ImageIcon("alien3Move2.png").getImage();
        blast=new ImageIcon("blast1.png").getImage();
        ufo=new ImageIcon("ufo.png").getImage();

        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.black);
        this.addKeyListener(key);
        this.setFocusable(true);
        //delays the game loop
        timer=new Timer(delay,this);
        timer.start();
        spawnEnemy();
        //generate two random index for enemy or choose random enemy to shoot
        randomIndex=(int)(0+Math.random()*((enemy.length-1)+1));
        randomIndex2=(int)(0+Math.random()*((enemy.length-1)+1));
        enemyShoot();
        saveScore();

    }
    public void playerShoot(boolean b) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        file1=new File("player sound.wav");
        AudioInputStream audio=AudioSystem.getAudioInputStream(file1);
        Clip clip=AudioSystem.getClip();
        clip.open(audio);

        if(b){
            clip.start();
        }
        else{
            clip.stop();
        }
    }
    //Spawns enemy
    public void spawnEnemy(){
        for (int i=0; i<enemy.length; i++) {
            enemy[i] = new Alien(ex,ey);
            ex+=shipSize;
            if (i==19){
                ex=shipSize;
                ey+=shipSize;
            }
            else if (i==39){
                ex=shipSize;
                ey+=shipSize;
            }
        }
    }
    public void ufo(){
        if(ufoSpawn>200){
            //System.out.println("In");
            ufoVisible=true;
            ufoX+=shipSize-8;
            //System.out.println(ufoX);
        }
        if(ufoX>ScreenWidth){
            ufoVisible=false;
            ufoSpawn=0;
            ufoX=0;
        }
    }
    public void hitUfo(){
        if(ufoVisible) {
            if ((initialX == ufoX && bullet == ufoY) || (initialX - 8 == ufoX && bullet - 8 == ufoY)) {
                blastUfo = true;
                ufoVisible = false;
                health = 100;
                Score = Score + 500;
            }
        }
    }
    //Saves the score
    public void saveScore(){
        try {
            save=new FileWriter("score.txt",true);
            save.write(""+highScore+"\n");
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            read=new BufferedReader(new FileReader("score.txt"));
            String line;
            while((line=read.readLine()) !=null){
                int s=Integer.parseInt(line);
                if(s>highScore){
                    highScore=s;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Checks if player got hit by the enemy bullet
    public void checkHit(){
        if (((enemyBulletX==x && enemyBulletY==y)|| (enemyBulletX2==x && enemyBulletY2==y))||
                ((enemyBulletX==x-8 && enemyBulletY==y)|| (enemyBulletX2==x-8 && enemyBulletY2==y))){
            move=false;
            gameOver=true;
            key.shoot=false;
            moveEnemy=false;
            enemyFire=false;
        }
    }
    //Checks if player's bullet hit the enemy
    public void hitEnemy(){
        for(int i=0; i<enemy.length; i++){
            if (enemy[i].isVisible) {
                if ((enemy[i].enemyX == initialX && enemy[i].enemyY == bullet)||
                        (enemy[i].enemyX == initialX-8 && enemy[i].enemyY == bullet)){
                    enemy[i].showBlast=true;
                    enemy[i].isVisible = false;
                    initialX=x;
                    bullet=y;
                    key.shoot=false;
                    Score += 10;
                    countVisibleEnemy++;
                }
            }
        }
    }
    //2 enemies shoot
    public void enemyShoot(){
        if(enemyFire) {
            if(enemy[randomIndex].isVisible) {
                enemyBulletX = enemy[randomIndex].enemyX;
                enemyBulletY = enemy[randomIndex].enemyY;
                enemyBulletX2 = enemy[randomIndex2].enemyX;
                enemyBulletY2 = enemy[randomIndex2].enemyY;
            }

        }
    }
    //Controls the movement of the enemy
    public void moveEnemy(){
        if(moveEnemy) {
            for (int i = 0; i < enemy.length; i++) {
                if (enemy[i].moveRight) {
                    enemy[i].enemyX += shipSize-8;
                } else {
                    enemy[i].enemyX -= shipSize-8;
                }
                if (enemy[i].enemyY>=y){
                    gameOver=true;
                }
                if (enemy[i].enemyX >= ScreenWidth) {
                    enemy[i].moveRight = false;
                    enemy[i].moveLeft = true;
                    enemy[i].enemyY += shipSize;
                } else if (enemy[i].enemyX <= 0) {
                    enemy[i].moveLeft = false;
                    enemy[i].moveRight = true;
                }
            }
        }
    }
    //Controls player movement
    public void playerMovement(){
        if (move) {
            if (key.right) {
                x += shipSize;
            } else if (key.left) {
                x -= shipSize;
            } else if (!key.right && !key.shoot) {
                initialX = x;
            } else if (!key.left && !key.shoot) {
                initialX = x;
            }

            if (key.shoot) {
                bullet -= shipSize;
            }
            if (bullet < 0) {
                key.shoot = false;
                bullet = ScreenHeight - shipSize;
            }
            hitEnemy();
        }
    }
    //Sets border for player
    public void setBorder(){
        if (x>=ScreenWidth){
            x-=shipSize;
        }
        else if (x<0){
            x+=shipSize;
        }
    }
    //Paints everything
    public void paint(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d=(Graphics2D) g;

        g2d.drawImage(background,0,0,ScreenWidth,ScreenHeight,null);

        //System.out.println(ufoSpawn);
        System.out.println(initialX+","+bullet);
        ufo();
        hitUfo();
        if(ufoVisible) {
            g2d.setPaint(Color.red);
            g2d.drawImage(ufo, ufoX, ufoY, shipSize, shipSize, null);
        }
        if(blastUfo){
            g2d.drawImage(blast, ufoX, ufoY, shipSize, shipSize, null);
            ufoSpawn=0;
            blastUfo=false;
            ufoX=0;
            //System.out.println(blastUfo);
        }
        try {
            playerShoot(key.shootSound);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }


        g2d.setPaint(Color.GREEN);
        g2d.drawLine(0,y+shipSize,ScreenWidth,y+shipSize);

        g2d.drawString("Score: "+Score,0,y+2*shipSize);
        g2d.drawString("Highest Score: "+highScore,23*shipSize,shipSize);
        checkHit();

        setBorder();
        g2d.drawImage(image,x,y,shipSize,shipSize,null);


        if (gameOver){
            String s="Game Over";
            g2d.setPaint(Color.RED);
            g2d.setFont(new Font(null,Font.PLAIN,40));
            g2d.drawString(s,ScreenWidth/2-6*shipSize,ScreenHeight/2);
            g2d.drawImage(blast,x-shipSize,y-shipSize,shipSize*4,shipSize*4,null);
            ufoSpawn=0;
            enemyBulletY=-16;
            enemyBulletY2=-16;
            if(Score>highScore){
                highScore=Score;
                saveScore();
            }
        }

        if(countVisibleEnemy==enemy.length){
            String s="You Won";
            g2d.setPaint(Color.RED);
            g2d.setFont(new Font(null,Font.PLAIN,40));
            g2d.drawString(s,ScreenWidth/2-6*shipSize,ScreenHeight/2);
            enemyBulletY=-16;
            enemyBulletY2=-16;
            move=false;
            enemyFire=false;
            key.shoot=false;
            key.shootSound=false;
            ufoVisible=false;
            saveScore();
        }

        moveEnemy();
        for (int i=0; i<enemy.length; i++){
            g2d.setPaint(Color.red);
            if(enemy[i].showBlast){
                g2d.drawImage(blast,enemy[i].enemyX,enemy[i].enemyY,18,18,null);
                enemy[i].showBlast=false;
            }
            if (enemy[i].isVisible) {
                if(tick==2){
                    g2d.drawImage(alienImage1,enemy[i].enemyX,enemy[i].enemyY,20,18,null);
                }
                else{
                    g2d.drawImage(alienImage2,enemy[i].enemyX,enemy[i].enemyY,20,18,null);
                }

            }

        }
            if (tick == 2) {
                g2d.setPaint(Color.green);
                g2d.fillOval(enemyBulletX, enemyBulletY, shipSize - 8, shipSize - 8);
                g2d.setPaint(Color.green);
                g2d.fillOval(enemyBulletX2, enemyBulletY2, shipSize - 8, shipSize - 8);
                enemyBulletY += 16;
                enemyBulletY2 += 16;
            } else {
                g2d.setPaint(Color.red);
                g2d.fillOval(enemyBulletX, enemyBulletY, shipSize - 8, shipSize - 8);
                g2d.setPaint(Color.red);
                g2d.fillOval(enemyBulletX2, enemyBulletY2, shipSize - 8, shipSize - 8);
                enemyBulletY += 16;
                enemyBulletY2 += 16;
            }
        if (enemyBulletY>ScreenHeight-2*shipSize || enemyBulletY2>ScreenHeight-2*shipSize){
            health--;
            randomIndex=(int)(0+Math.random()*((enemy.length-1)+1));
            randomIndex2=(int)(0+Math.random()*((enemy.length-1)+1));
            enemyShoot();
        }
        if(health==0){
            gameOver=true;
            moveEnemy=false;
            enemyFire=false;
            key.shoot=false;
            move=false;
        }
        if(key.shoot) {
            g2d.setPaint(Color.YELLOW);

            g2d.fillOval(initialX,bullet-2*shipSize,shipSize-8,shipSize-8);

        }
        g2d.setPaint(Color.green);
        g2d.setFont(new Font(null,Font.PLAIN,10));
        g2d.drawString("Press r to restart",ScreenWidth-10*shipSize,y+2*shipSize);
        healthBar=new JProgressBar(0,200);
        this.add(healthBar);
        healthBar.setValue(health);
        healthBar.setBounds(ScreenWidth-20*shipSize,y+2*shipSize,100,10);
        healthBar.setBackground(Color.BLACK);
        healthBar.setForeground(Color.RED);
        //healthBar.setStringPainted(true);


    }
    public void restartGame(){
        if(key.restart){
            new gameFrame();
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playerMovement();
        repaint();
        restartGame();
        tick++;
        ufoSpawn++;
        if(tick==3){
            tick=0;
        }
    }
}
