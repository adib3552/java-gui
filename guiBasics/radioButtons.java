package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioButtons {
      public static void main(String[] args) {

          new test();
      }
}
class test extends JFrame implements ActionListener{
    JRadioButton pizza;
    JRadioButton burger;
    JRadioButton sandwich;
   test(){
       this.setLayout(new FlowLayout());

       pizza=new JRadioButton("Pizza");
       pizza.setFocusable(false);
       pizza.addActionListener(this);
       burger=new JRadioButton("Burger");
       burger.setFocusable(false);
       burger.addActionListener(this);
       sandwich=new JRadioButton("Sandwich");
       sandwich.setFocusable(false);
       sandwich.addActionListener(this);

       ButtonGroup group=new ButtonGroup();
       group.add(pizza);
       group.add(burger);
       group.add(sandwich);

       this.setVisible(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(pizza);
       this.add(burger);
       this.add(sandwich);
       this.pack();

   }
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==pizza){
          System.out.println("You get pizza");
      }
      if (e.getSource()==burger){
          System.out.println("You get burger");
      }
      if (e.getSource()==sandwich){
          System.out.println("You get sandwich");
      }
    }
}


