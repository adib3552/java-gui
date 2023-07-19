package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class launchPage implements ActionListener {
    JFrame frame=new JFrame();
    JButton button=new JButton("New Window");
    launchPage(){
        button.setFocusable(false);
        button.setBounds(170,200,120,50);
        button.addActionListener(this);

      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500,500);
      frame.setVisible(true);
      frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            frame.dispose();
           openNewWindow myWindow= new openNewWindow();
        }
    }
}
class main{
    public static void main(String[] args){
        new launchPage();
    }
}

public class openNewWindow {
    JFrame frame=new JFrame();
    JLabel label=new JLabel("You're gay");
    openNewWindow(){
        label.setBounds(100,100,200,200);
        label.setFont(new Font(null,Font.PLAIN,30));

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

