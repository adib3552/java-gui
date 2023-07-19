package guiBasics;

import javax.swing.*;
import java.awt.*;

public class panel {
    public static void main(String[] args){
        //JPanel= a GUI component that functions as a container to hold other component
        JLabel label1=new JLabel();
        label1.setText("1");
        label1.setFont(new Font("MV Boli", Font.PLAIN,30));
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(100,100,100,200);
        ImageIcon image1=new ImageIcon("ball.jpeg");
        label1.setIcon(image1);
        JFrame frame=new JFrame();
        JPanel redPanel=new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,200,350);
        redPanel.setLayout(null);

        JPanel bluePanel=new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(200,0,200,350);
        bluePanel.setLayout(new BorderLayout());

        JPanel greenPanel=new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,350, 400,350);
        greenPanel.setLayout(new BorderLayout());

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.setVisible(true);
        frame.add(redPanel);

        frame.add(bluePanel);

        frame.add(greenPanel);

        redPanel.add(label1);
        //greenPanel.add(label1);
    }
}
