package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class key_Listener extends JFrame implements KeyListener {
    JLabel label;
    JLabel label2;
    int randX;
    int randY;
    int x=0;
    int y=0;
    ImageIcon image=new ImageIcon("spobgebobre.png");
    ImageIcon image2=new ImageIcon("burger.png");
    key_Listener(){
        label=new JLabel();
        label2=new JLabel();

        while (true){
            randX=(int)(50+Math.random()*(300-50+1));
            randY=(int)(50+Math.random()*(300-50+1));
            if (randX%10==0 && randY%10==0)
             break;
        }

        label2.setBounds(randX,randY,60,60);
        label2.setIcon(image2);
        label2.setBackground(Color.BLACK);
        label2.setOpaque(true);

        System.out.println(x);
        System.out.println(y);

        label.setBounds(0,0,100,100);
        label.setIcon(image);
        label.setBackground(Color.BLACK);
        //label.setOpaque(true);

        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(label);
        this.add(label2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //keyTyped=Invoked when a key is typed. Uses keyChar, Char output.


    }

    @Override
    public void keyPressed(KeyEvent e) {
       //keyPressed=Invoked when a physical key is pressed down.Uses keyCode, int output.
        //keyTyped=Invoked when a key is typed. Uses keyChar, Char output.
    double a=1000000000/60;
    double b=System.nanoTime()+a;
        while (true) {
            switch (e.getKeyChar()) {
                case 'a':
                    label.setLocation(label.getX() - 10, label.getY());
                    break;
                case 'd':
                    label.setLocation(label.getX() + 10, label.getY());
                    break;
                case 'w':
                    label.setLocation(label.getX(), label.getY() - 10);
                    break;
                case 's':
                    label.setLocation(label.getX(), label.getY() + 10);
                    break;
            }
            switch (e.getKeyCode()){
                case 37:label.setLocation(label.getX()-10,label.getY());
                    break;
                case 39:label.setLocation(label.getX()+10,label.getY());
                    break;
                case 40:label.setLocation(label.getX(),label.getY()+10);
                    break;
                case 38:label.setLocation(label.getX(),label.getY()-10);
                    break;
            }
            try {
                double c=b-System.nanoTime();
                c=c/100000000;
                Thread.sleep((long) c);
                b+=a;
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            if (label.getX() == 300) {
                label.setLocation(label.getX() - 10, label.getY());
            } else if (label.getX() == -10) {
                label.setLocation(label.getX() + 10, label.getY());
            } else if (label.getY() == 290) {
                label.setLocation(label.getX(), label.getY() - 10);
            } else if (label.getY() == -10) {
                label.setLocation(label.getX(), label.getY() + 10);
            }
            System.out.println("The loop is running");
        }
      /*
        x=label2.getX()-20;
        y=label2.getY()-20;

        System.out.println(x);
        System.out.println(y);

        if(label.getX()==x && label.getY()==y){

            while (true){
                randX=(int)(50+Math.random()*(300-50+1));
                randY=(int)(50+Math.random()*(300-50+1));
                if (randX%10==0 && randY%10==0)
                    break;
            }

            //label2=new JLabel();
            label2.setBounds(randX,randY,60,60);
            label2.setBackground(Color.BLACK);
            //label2.setOpaque(true);

        }

       */
       /*
        if(e.getKeyChar()=='d'){
            while(label.getX() !=300){
                int move=0;


                try {
                    move=move+10;
                    label.setLocation(label.getX()+move,label.getY());
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        */


    }

    @Override
    public void keyReleased(KeyEvent e) {
      //keyReleased=Called whenever a button is released.
        //System.out.println("You released key: "+ e.getKeyChar());
        //System.out.println("Your key code: "+e.getKeyCode());
        System.out.println(label.getLocation());
    }
}
class testKey_listener{
    public static void main(String[] args){
        new key_Listener();
    }
}
