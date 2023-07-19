package guiBasics;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class label {
    public static void main(String[] args){
        //JLabel=A GUI display area for text, an image, or both
        Border border=BorderFactory.createLineBorder(Color.red,4);
        JFrame frame=new JFrame();
        JLabel label=new JLabel();//create a label
        ImageIcon image=new ImageIcon("guts.png");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);//set text left, center, right of ImageIcon
        label.setVerticalTextPosition(JLabel.TOP);//set text top, center, bottom of ImageIcon
        label.setForeground(Color.blue);//set text color
        label.setFont(new Font("MV Boli",Font.PLAIN,30));//set text font
        label.setIconTextGap(50);//set gap of text to image
        label.setBackground(Color.black);//set background color
        label.setOpaque(true);//display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);//set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER);//set horizontal position of icon+text within label
        //label.setBounds(100,100,250,350);//set x , y position within label as well as dimensions
        label.setText("Reject modernity embrace Masculinity");//set text of label
        frame.setSize(600, 600);
        //frame.setResizable(false);
        frame.setVisible(true);
        //frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setTitle("guiLabel");
        //ImageIcon image1=new ImageIcon("");
        //frame.setIconImage(image1.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);

    }
}
