package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkboxes extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    ImageIcon checkIcon=new ImageIcon("checkicon.jpg");
    ImageIcon xIcon=new ImageIcon("xicon.jpg");
    checkboxes(){
        checkBox=new JCheckBox();
        button=new JButton("upload");
        button.setFocusable(false);
        button.addActionListener(this);

        checkBox.setIcon(xIcon);
        checkBox.setText("Are you a Pedophile?");
        checkBox.setFocusable(false);
        checkBox.setSelectedIcon(checkIcon);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,250);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
        this.add(checkBox);
        this.add(button);
    }
    public static void main(String[] args){

        new checkboxes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==button){
           if (checkBox.isSelected()){
               while (true) {
                   JOptionPane.showMessageDialog(null, "PEDOPHILE SPOTTED", "WTF", JOptionPane.WARNING_MESSAGE);
               }
           }
           else{
               JOptionPane.showMessageDialog(null,"GOOD JOB","NICE",JOptionPane.INFORMATION_MESSAGE);
           }
       }
    }
}