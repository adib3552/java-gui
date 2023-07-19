package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class colorChooser extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    colorChooser(){
        button=new JButton("Click me");
        label=new JLabel();

        button.addActionListener(this);

        label.setText("This is my text");

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new FlowLayout());

      this.add(label);
      this.add(button);
      this.pack();
      this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            JColorChooser color=new JColorChooser();
            Color c=JColorChooser.showDialog(null,"Pick a color",Color.black);
            label.setForeground(c);
        }
    }
}
class testColor{
    public static void main(String[] args){
        new colorChooser();
    }
}
