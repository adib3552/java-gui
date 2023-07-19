package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class testFrame extends JFrame implements ActionListener {
    JComboBox comboBox;
    testFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] months={"January","February","March"};
        comboBox=new JComboBox(months);
        comboBox.addActionListener(this);
        //comboBox.setEditable(true);
        //System.out.println(comboBox.getItemCount());
        comboBox.addItem("April");
        comboBox.insertItemAt("June",0);
        comboBox.setSelectedIndex(0);
        comboBox.removeItem("June");
        //comboBox.removeAllItems();

        this.setVisible(true);
        this.add(comboBox);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num=0;
       if(e.getSource()==comboBox) {
           //num=comboBox.getSelectedIndex();
           System.out.println(comboBox.getSelectedItem());
           //System.out.println(num);
       }
       /*
       if (num==0){
           System.out.println("January has 31 days");
       }
       else if (num==1){
            System.out.println("February has 28 days");
        }
       else if (num==2){
            System.out.println("March has 31 days");
        }
        */
    }
}
public class comboBoxes {
    public static void main(String[] args){

        new testFrame();
    }
}
