package guiBasics;

import javax.swing.*;
import java.awt.*;

public class raff extends JPanel {
    int x=200;
    int y=200;
    raff(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);

    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d=(Graphics2D) g;
        for(int i=0; i<3; i++){
            g2d.setPaint(Color.white);
            g2d.fillRect(x,y,50,50);
            x-=25;
            //y-=25;
            System.out.println(x+","+y);
        }
    }

}
class testRaff{
    public static void main(String[] args){
      raff r =  new raff();
      JFrame f=new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(r);
      f.pack();
      f.setVisible(true);
    }
}
