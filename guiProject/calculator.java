package guiProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {
    JFrame frame=new JFrame();
    JTextField textField=new JTextField();
    JButton[] numberButton =new JButton[10];
    JButton[] functionButton=new JButton[8];
    JButton addButton,subButton,divButton,multButton,eqlButton,deciButton;
    JButton delButton,clrButton;

    static JPanel panel=new JPanel();
    double num1=0,num2=0, result=0;

    char operator;
    calculator(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,550);
        textField.setBounds(50,10,300,50);
        frame.setLayout(null);
        frame.add(textField);
        frame.setVisible(true);
        frame.setTitle("Simple calculator");

        addButton =new JButton("+");
        subButton =new JButton("-");
        divButton =new JButton("/");
        multButton =new JButton("*");
        eqlButton =new JButton("=");
        deciButton=new JButton(".");
        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=divButton;
        functionButton[3]=multButton;
        functionButton[4]=eqlButton;
        functionButton[5]=deciButton;
        functionButton[6]=clrButton;
        functionButton[7]=delButton;

        for (int i=0; i<8;i++){
            functionButton[i]=new JButton(String.valueOf(i));
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);

        }
        for(int i=0; i<10; i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
        }
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(50,85,300,250);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multButton);
        panel.add(numberButton[0]);
        panel.add(divButton);
        panel.add(eqlButton);
        panel.add(deciButton);

        delButton =new JButton("Delete");
        clrButton =new JButton("Clear");
        delButton.setBounds(50,400,100,40);
        clrButton.setBounds(250,400,100,40);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(panel);
    }

    public static void main(String[] args){


     new calculator();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<10;i++) {
            if (e.getSource() == numberButton[i]) {
               textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==deciButton) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='+';
            //textField.setText("");
        }
    }
}
