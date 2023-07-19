package guiBasics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simpleCalculator implements ActionListener {
    static JTextField textfield;
    static JFrame frame;
    static JButton[] button;
    static JButton resButton;
    static JButton delButton;
    static JPanel panel;
    static char[] operator=new char[]{'+','-','/','X'};
    static JButton[] opButton;
    static JButton equalButton;
    static int num1;
    static int num2;
    static int result;
    static char function;
    simpleCalculator() {
        frame=new JFrame("Practice");
        opButton=new JButton[4];
        button=new JButton[10];
        textfield=new JTextField();
        panel=new JPanel();


        panel.setBounds(10,150,460,300);
        //adding button 1 to 9
        panel.setLayout(new GridLayout(4,3));
        for (int i=0; i<10; i++){
            button[i]=new JButton(""+i);
            button[i].setFocusable(false);
            button[i].addActionListener(this);
            panel.add(button[i]);
        }

        //adding operator button
        for (int i=0; i<operator.length; i++){
           opButton[i]=new JButton(""+operator[i]);
           opButton[i].setFocusable(false);
           opButton[i].addActionListener(this);
           panel.add(opButton[i]);
        }

        equalButton =new JButton("=");
        equalButton.setFocusable(false);
        equalButton.addActionListener(this);
        panel.add(equalButton);

        //reset button
        resButton=new JButton("Reset");
        resButton.setFocusable(false);
        resButton.setBounds(10,600,80,30);
        resButton.addActionListener(this);

        //delete button
        delButton=new JButton("Delete");
        delButton.setFocusable(false);
        delButton.setBounds(250,600,80,30);
        delButton.addActionListener(this);

        //adding textfield
        textfield.setBounds(10,40,460,100);
        textfield.setBackground(Color.WHITE);

        //frame
        frame.setSize(500,700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(textfield);
        frame.add(panel);
        frame.add(resButton);
        frame.add(delButton);
    }


    public static void main(String[] args) {
       new simpleCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<10; i++){
            if (e.getSource()==button[i]){
                textfield.setText(textfield.getText().concat(""+i));
            }
        }
        if (e.getSource()==resButton){
            textfield.setText("");
        }
        if (e.getSource()==opButton[0]){
            //textfield.setText(textfield.getText().concat("+"));
            num1= Integer.parseInt(textfield.getText());
            function='+';
            textfield.setText("");
        }
        if (e.getSource()==opButton[1]){
            //textfield.setText(textfield.getText().concat("-"));
            num1= Integer.parseInt(textfield.getText());
            function='-';
            textfield.setText("");
        }
        if (e.getSource()==opButton[2]){
            //textfield.setText(textfield.getText().concat("/"));
            num1= Integer.parseInt(textfield.getText());
            function='/';
            textfield.setText("");
        }
        if (e.getSource()==opButton[3]){
            //textfield.setText(textfield.getText().concat("X"));
            num1= Integer.parseInt(textfield.getText());
            function='*';
            textfield.setText("");
        }

        if (e.getSource()==equalButton){
            num2=Integer.parseInt(textfield.getText());
            textfield.setText("");
            switch (function){
                case '+':result=num1+num2;break;
                case '-':result=num1-num2;break;
                case '*':result=num1*num2;break;
                case '/':result=num1/num2;break;
            }
            textfield.setText(textfield.getText()+result);
            num1=result;
        }

    }
}

