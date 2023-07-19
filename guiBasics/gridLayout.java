package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gridLayout extends JFrame implements ActionListener {
    JPanel panel=new JPanel();
    JPanel panel1=new JPanel();
    JLabel label=new JLabel();
    //JButton button=new JButton();
    public static void main(String[] args){
      new gridLayout();
    }
    gridLayout(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new GridLayout(3,3));
        this.setLayout(new BorderLayout(10,10));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(100,100));
        panel1.setLayout(new GridLayout(3,3));
        panel1.setBackground(Color.GRAY);
        panel1.setPreferredSize(new Dimension(400,400));

        panel1.add(new JButton("0"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("2"));
        panel1.add(new JButton("3"));
        panel1.add(new JButton("4"));
        panel1.add(new JButton("5"));
        panel1.add(new JButton("6"));
        panel1.add(new JButton("7"));
        panel1.add(new JButton("8"));
        panel1.add(new JButton("9"));
        panel1.add(new JButton("+"));
        panel1.add(new JButton("-"));

        this.add(panel,BorderLayout.NORTH);
        this.add(panel1,BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

