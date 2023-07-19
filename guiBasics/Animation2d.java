package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation2d extends JFrame {
    animation a;
     Animation2d(){
        a =new animation();

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.add(a);
         this.pack();
         this.setLocationRelativeTo(null);
         this.setVisible(true);
     }
}
class driverAnimation {
    public static void main(String[] args){
        new Animation2d();
    }
}
class animation extends JPanel implements ActionListener {

    final int panel_width=500;
    final int panel_height=500;
    Image linkFront;
    Image background;
    int xVelocity=2;
    int yVelocity=3;
    int x=0;
    int y=0;
     animation(){
         this.setPreferredSize(new Dimension(panel_height,panel_width));
         this.setBackground(Color.black);
         linkFront=new ImageIcon("link_front.png").getImage();
         Timer timer=new Timer(10,this);
         timer.start();
     }
     public void paint(Graphics g){
         super.paint(g); //this will paint background

         Graphics2D graphics=(Graphics2D) g;

         graphics.drawImage(linkFront,x,y,null);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(x >= panel_width-linkFront.getWidth(null) || x<0){
            xVelocity=xVelocity*(-1);
         }

         x=x+xVelocity;

        if(y >= panel_height-linkFront.getWidth(null) || y<0){
            yVelocity=yVelocity*(-1);
        }
        y=y+yVelocity;
        repaint();
    }
}
