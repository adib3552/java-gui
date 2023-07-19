package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField extends JFrame implements ActionListener {
    JButton button;
    TextField(){
        JTextField textField=new JTextField();

        button=new JButton("post");
        button.setFocusable(false);
        button.addActionListener(this);

        textField.setPreferredSize(new Dimension(300,50));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(textField);
        this.add(button);
        this.pack();//this will adjust the frame for the components
        this.setVisible(true);


    }

    public static void main(String[] args){
        new TextField();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==button){
           System.out.println("Hey man");
       }
    }
}
