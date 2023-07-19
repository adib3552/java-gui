package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JLabel label;
    MyFrame(){
        ImageIcon image=new ImageIcon("home.png");
        ImageIcon image2=new ImageIcon("dwnd.png");

        label=new JLabel();
        label.setVisible(false);
        label.setBounds(150,200,100,100);
        label.setIcon(image2);

        button=new JButton();
        button.setBounds(100,100,200,100);
        button.addActionListener(this);
        button.setText("Click me");
        button.setFocusable(false);
        button.setIcon(image);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setFont(new Font("Comic Sans", Font.BOLD,20));
        button.setIconTextGap(-5);
        button.setForeground(Color.BLUE);
        button.setBackground(Color.GRAY);
        button.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(500,500);
        this.setTitle("guiButton");
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            System.out.println("Deez Nuts");
            //button.setEnabled(false);
            label.setVisible(true);
        }
    }
}
