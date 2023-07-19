package UniProject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int originalSnakeSize=8;
    final int scale =2;
    final int snakeSize=originalSnakeSize*scale;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    final int ScreenHeight=576;//768
    final int ScreenWidth=576;//576
    int foodx;
    int foody;
    int x=snakeSize;
    int y=snakeSize;
    String direction="up";
    int speed=snakeSize;
    double timer;
    double FpsCounter=0;
    final int FPS=10;
    int counter=0;
    int snakeBodyParts=3;
    int[] snakeBodyX =new int[ScreenWidth];
    int[] snakeBodyY =new int[ScreenHeight];
    boolean hit=false;
    ControlMechanics CM;
    int FoodCount=0;
    //int[] snakeBody[appleCount];
    Thread gameThread;
    GamePanel(){
        CM=new ControlMechanics();

        food();

        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(CM);
        this.setFocusable(true);
        startGameThread();

    }
    void food(){
        foodx=(int)(snakeSize+Math.random()*((ScreenWidth-72)+1));
        foody=(int)(snakeSize+Math.random()*((ScreenHeight-72)+1));

        while (foodx%snakeSize != 0){
            foodx=(int)(snakeSize+Math.random()*((ScreenWidth-72)+1));
            //foody=(int)(48+Math.random()*(ScreenHeight-48+1));
        }
        while (foody%snakeSize != 0){
            //foodx=(int)(48+Math.random()*(ScreenWidth-48+1));
            foody=(int)(48+Math.random()*((ScreenHeight-72)+1));
        }
        System.out.println(foodx+","+foody);
    }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double lastTine=System.nanoTime();
        double maxFramePerSec=1000000000.0/FPS;
        double delta=0;
        while(true){
            double CurrentTime=System.nanoTime();
            delta+=(CurrentTime-lastTine)/maxFramePerSec;
            timer=(CurrentTime-lastTine);
            lastTine=CurrentTime;
            while(delta>=1){
                update();
                repaint();
                delta--;
                FpsCounter++;
            }
            if (timer >=1000000000){
                timer=0;
                FpsCounter=0;
            }
        }
    }
    public void checkCollusion(){
        if (snakeBodyX[0]<0 || snakeBodyX[0] > ScreenWidth-20 || snakeBodyY[0] < 0
                || snakeBodyY[0] > ScreenHeight - 20){
            hit=true;
        }
    }
    public void eatFood(){
        if (snakeBodyX[0]==foodx && snakeBodyY[0]==foody){
            food();
            snakeBodyParts++;
        }
    }
    public void movement(){
        for (int i=snakeBodyParts; i>0; i--){
            snakeBodyX[i]=snakeBodyX[i-1];
            snakeBodyY[i]=snakeBodyY[i-1];
        }
        switch (direction){
            case"up":
                snakeBodyY[0]-=snakeSize;
                break;
            case"down":
                snakeBodyY[0]+=snakeSize;
                break;
            case"right":
                snakeBodyX[0]+=snakeSize;
                break;
            case"left":
                snakeBodyX[0]-=snakeSize;
                break;
        }
    }
    public void update(){
        if(CM.up|| CM.down || CM.left || CM.right) {
            if (!hit) {
                if (CM.up) {
                    direction="up";
                    //y -= speed;
                } else if (CM.down) {
                    direction="down";
                    //y += speed;
                } else if (CM.right) {
                    direction="right";
                    x += speed;
                } else if (CM.left) {
                    direction="left";
                    x -= speed;
                }
                movement();
                eatFood();
                checkCollusion();
                /*
                if (x <= 0 || x > ScreenWidth - 20 || y <= 0 || y > ScreenHeight - 20) {
                    hit = true;
                    System.out.println("Game over");
                }

                if (x == foodx && y == foody) {
                    food();
                    System.out.println("This is working");
                }

                 */
            }
        }
    }
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d=(Graphics2D) g;
        //g2d.setPaint(Color.white);

        for (int i=0; i<snakeBodyParts; i++){
            if(i==0){
                g2d.setPaint(Color.GREEN);
                g2d.fillRect(snakeBodyX[i],snakeBodyY[i],snakeSize,snakeSize);
            }
            else{
                g2d.setPaint(Color.WHITE);
                g2d.fillRect(snakeBodyX[i],snakeBodyY[i],snakeSize,snakeSize);
            }
        }

        g2d.setPaint(Color.red);
        g2d.fillOval(foodx,foody,snakeSize,snakeSize);

    }
}
