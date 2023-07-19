package guiBasics;

import javax.swing.*;
import java.awt.*;

public class borderLayout {
    //Layout Manager defines the natural layout for components within a container
    // 3 common managers border layout,flow layout,grid layout
    //Border Layout= a border layout places components in 5 areas: North, South, East, West and Center
    //                                                      all extra space is placed in center area
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        JPanel panel7=new JPanel();

        panel1.setBackground(Color.BLUE);
        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setBackground(Color.GREEN);
        panel2.setPreferredSize(new Dimension(100,100));
        panel2.setLayout(new BorderLayout());
        panel2.add(panel7, BorderLayout.SOUTH);
        panel3.setBackground(Color.RED);
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setBackground(Color.PINK);
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setBackground(Color.CYAN);
        panel5.setPreferredSize(new Dimension(100,100));
        panel5.setLayout(new BorderLayout());
        panel5.add(panel6,BorderLayout.NORTH);
        panel6.setBackground(Color.YELLOW);
        panel6.setPreferredSize(new Dimension(50,50));
        panel7.setBackground(Color.BLACK);
        panel7.setPreferredSize(new Dimension(50,50));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(new BorderLayout(10,10));
        frame.add(panel1,BorderLayout.CENTER);
        frame.add(panel2,BorderLayout.NORTH);
        frame.add(panel3,BorderLayout.EAST);
        frame.add(panel4,BorderLayout.WEST);
        frame.add(panel5,BorderLayout.SOUTH);
    }
}
