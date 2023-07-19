package guiProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tictactoe implements ActionListener {
    JFrame frame;
    JLabel label;
    //JPanel panel2;
    //JLabel label3;
    //JLabel label4;
    JButton[] button=new JButton[9];
    JButton resButton;
    JPanel panel;
    boolean xturn;
    boolean resetGame=false;
    Border border=BorderFactory.createLineBorder(Color.black,4);
    int countx=0,counto=0;
    Tictactoe(){
        frame=new JFrame();
        frame.setLayout(null);
        //frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(750,670);
        frame.setVisible(true);

        label=new JLabel();
        label.setText("Tic Tac Toe");
        label.setFont(new Font("Mv boli", Font.PLAIN, 35));
        label.setBounds(20,0,560,130);
        label.setForeground(Color.BLACK);



        panel=new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(25,85,500,460);
        panel.setLayout(new GridLayout(3,3));

        resButton=new JButton("Reset");
        resButton.setBounds(25,570,100,50);
        //resButton.setForeground(Color.RED);
        resButton.setFocusable(false);
        resButton.addActionListener(this);

        for(int i=0; i<9; i++){
            button[i]=new JButton();
            button[i].addActionListener(this);
            button[i].setFocusable(false);
            button[i].setBackground(Color.WHITE);
        }
        panel.add(button[0]);
        panel.add(button[1]);
        panel.add(button[2]);
        panel.add(button[3]);
        panel.add(button[4]);
        panel.add(button[5]);
        panel.add(button[6]);
        panel.add(button[7]);
        panel.add(button[8]);

        frame.add(panel);
        frame.add(label);
        frame.add(resButton);
        //frame.add(label2);
    }
    public static void main(String[] args){

        new Tictactoe();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++){
            if (e.getSource()==button[i]){
                if(xturn){
                    if(button[i].getText()=="") {
                        button[i].setText("X");
                        button[i].setFont(new Font("Mv boli", Font.PLAIN, 50));
                        xturn = false;
                        checkWinner();
                    }
                }
                else if (!xturn) {
                    if (button[i].getText()=="") {
                        button[i].setText("O");
                        button[i].setFont(new Font("Mv boli", Font.PLAIN, 50));
                        button[i].setForeground(Color.RED);
                        xturn = true;
                        checkWinner();
                    }
                }
            }
        }
        if (e.getSource()==resButton){
            for (int i=0; i<9; i++){
                button[i].setText("");
                resetGame=true;
            }
        }
        if(resetGame==true){
            for(int i=0; i<9; i++){
                button[i].setEnabled(true);
                button[i].setBackground(Color.WHITE);
                checkWinner();
            }
        }
    }

    public void checkWinner(){
        if (    button[0].getText()=="X" &&
                button[1].getText()=="X" &&
                button[2].getText()=="X"){
            xWins(0,1,2);
        }
        if (    button[3].getText()=="X" &&
                button[4].getText()=="X" &&
                button[5].getText()=="X"){
            xWins(3,4,5);
        }
        if (    button[6].getText()=="X" &&
                button[7].getText()=="X" &&
                button[8].getText()=="X"){
            xWins(6,7,8);
        }
        if (    button[0].getText()=="X" &&
                button[3].getText()=="X" &&
                button[6].getText()=="X"){
            xWins(0,3,6);
        }
        if (    button[1].getText()=="X" &&
                button[4].getText()=="X" &&
                button[7].getText()=="X"){
            xWins(1,4,7);
        }
        if (    button[2].getText()=="X" &&
                button[5].getText()=="X" &&
                button[8].getText()=="X"){
            xWins(2,5,8);
        }
        if (    button[0].getText()=="X" &&
                button[4].getText()=="X" &&
                button[8].getText()=="X"){
            xWins(0,4,8);
        }
        if (    button[2].getText()=="X" &&
                button[4].getText()=="X" &&
                button[6].getText()=="X"){
            xWins(2,4,6);
        }
        if (    button[0].getText()=="O" &&
                button[1].getText()=="O" &&
                button[2].getText()=="O"){
            oWins(0,1,2);
        }
        if (    button[3].getText()=="O" &&
                button[4].getText()=="O" &&
                button[5].getText()=="O"){
            oWins(3,4,5);
        }
        if (    button[6].getText()=="O" &&
                button[7].getText()=="O" &&
                button[8].getText()=="O"){
            oWins(6,7,8);
        }
        if (    button[0].getText()=="O" &&
                button[3].getText()=="O" &&
                button[6].getText()=="O"){
            oWins(0,3,6);
        }
        if (    button[1].getText()=="O" &&
                button[4].getText()=="O" &&
                button[7].getText()=="O"){
            oWins(1,4,7);
        }
        if (    button[2].getText()=="O" &&
                button[5].getText()=="O" &&
                button[8].getText()=="O"){
            oWins(2,5,8);
        }
        if (    button[0].getText()=="O" &&
                button[4].getText()=="O" &&
                button[8].getText()=="O"){
            oWins(0,4,8);
        }
        if (    button[2].getText()=="O" &&
                button[4].getText()=="O" &&
                button[6].getText()=="O"){
            oWins(2,4,6);
        }

    }
    public void xWins(int a,int b,int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            button[i].setEnabled(false);
            //resetGame=true;
        }
    }
    public void oWins(int a,int b,int c){

            button[a].setBackground(Color.GREEN);
            button[b].setBackground(Color.GREEN);
            button[c].setBackground(Color.GREEN);

            for (int i = 0; i < 9; i++) {
                button[i].setEnabled(false);
                //resetGame=true;
            }

    }

}
