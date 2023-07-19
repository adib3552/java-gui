package guiBasics;

import javax.swing.*;
import java.awt.*;

public class progressbar {
    public static void main(String[] args){

        new demo();
    }
}
class demo{
    JFrame frame;
    JProgressBar bar;
    demo(){
        frame=new JFrame();
        bar=new JProgressBar();

        bar.setValue(200);
        bar.setBounds(0,0,280,30);
        bar.setStringPainted(true);
        bar.setFont(new Font(null,Font.PLAIN,15));
        bar.setBackground(Color.BLACK);
        bar.setForeground(Color.RED);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(bar);
        //frame.pack();

        barProgress();
    }
    public void barProgress() {
        int i=200;
        while(i>=0){
            bar.setValue(i);
            bar.setString(""+i+"/200HP");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i--;
            if (i==0){
                bar.setString("You Are Dead");
            }
        }

    }
}
