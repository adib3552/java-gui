package guiBasics;

import javax.swing.*;
import java.awt.*;

public class graphics2d {
    public static void main(String[] args){

        new graphicsFrame();
    }
}
class graphicsFrame extends JFrame {
     graphicsFrame(){
         Panel2d p=new Panel2d();

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.add(p);
         this.pack();
         this.setLocationRelativeTo(null);
         this.setVisible(true);
     }

}
class Panel2d extends JPanel{

    Image img;
   Panel2d(){
       img=new ImageIcon("guts.png").getImage();

      this.setPreferredSize(new Dimension(500,500));
    }
    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D) g;

        g2d.drawImage(img,0,0,null);
        //g2d.setStroke(new BasicStroke(5));
        g2d.setPaint(Color.red);
        //g2d.drawLine(0,0,500,500);
        //g2d.drawRect(100,100,50,50);
        //g2d.fillRect(100,100,50,50);

        //g2d.drawOval(200,200,50,50);
        //g2d.fillOval(200,200,50,50);

        g2d.drawArc(250,250,100,100,0,180);
        g2d.fillArc(250,250,100,100,0,180);
        g2d.setPaint(Color.white);
        g2d.fillArc(250,250,100,100,180,180);

        int[] x={150,250,300};
        int[] y={300,250,150};
        g2d.drawPolygon(x,y,3);
        g2d.fillPolygon(x,y,3);

        //g2d.drawString("Hello",50,50);



    }
}
