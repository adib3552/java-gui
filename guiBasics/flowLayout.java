package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class flowLayout {
    //Layout Manager defines the natural layout for components within a container

    //Flow layout=  places components in a row, sized at their preferred size.
    //              if the horizontal space in the container is too small,
    //              the flow layout class uses the nex available row

    public static void main(String[] args){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        panel.setPreferredSize(new Dimension(200,200));
        panel.setBackground(Color.GRAY);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        frame.add(panel);
        frame.setVisible(true);

    }
}
