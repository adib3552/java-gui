package guiProject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.io.*;

public class loginPage implements ActionListener {
    JFrame frame;
    String savePass;
    String saveName;
    JPanel panel;
    JCheckBox policy;
    JLabel name,pass;
    JButton login,signIn;
    JButton forgotPass;
    JTextField username;
    JPasswordField password;
    loginPage(){
        frame=new JFrame();
        login=new JButton("Log In");
        signIn=new JButton("Sign Up");
        name=new JLabel();
        pass=new JLabel();
        policy =new JCheckBox("I agree with the terms and policy");
        forgotPass=new JButton();
        username=new JTextField();
        password=new JPasswordField();
        panel=new JPanel();

        panel.setSize(400,400);
        panel.setLayout(null);
        //panel.setBackground(Color.YELLOW);

        name.setText("Username:");
        name.setBounds(15,50,55,20);
        name.setFont(new Font(null,Font.BOLD,10));

        pass.setText("Password:");
        pass.setBounds(15,90,55,20);
        pass.setFont(new Font(null,Font.BOLD,10));

        username.setBounds(85,50,150,20);

        password.setBounds(85,90,150,20);
        password.setEchoChar('*');

        //policy.setText();
        policy.setBounds(40,115,260,14);
        //policy.setFont(new Font(null,Font.PLAIN,5));

        login.setBounds(150,140,100,35);
        login.setFocusable(false);
        login.addActionListener(this);

        signIn.setBounds(53,140,100,35);
        //signIn.setBackground(Color.BLUE);
        signIn.setFocusable(false);
        signIn.setForeground(Color.BLUE);
        signIn.addActionListener(this);

     //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);

        panel.add(username);
        panel.add(password);
        panel.add(name);
        panel.add(pass);
        panel.add(policy);
        panel.add(signIn);
        panel.add(login);
        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login) {
            if (policy.isSelected()) {
                boolean found;
                try {
                    BufferedReader check = new BufferedReader(new FileReader("signUp.txt"));
                    savePass = "" + new String(password.getPassword());
                    saveName = username.getText();
                    String line;
                    //line.equals
                    found = true;
                    while ((line = check.readLine()) != null) {
                        if (Objects.equals((saveName + "\t" + savePass),line)) {
                            found=true;
                            break;
                        } else {
                            found = false;
                        }
                    }
                    System.out.println(found);
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Wrong username or password", "message", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        new openNewWindow();
                        frame.dispose();
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Accept policy first", "Message", JOptionPane.PLAIN_MESSAGE);
            }
        }
        else if(e.getSource()==signIn){
            new signUpPage();
        }

    }
}
class openNewWindow implements ActionListener{
    JFrame frame2;
    JButton previous;
    JButton Tic_tac_toe;
    JButton simple_quiz_game;
    JLabel welcome;
    openNewWindow(){
        frame2 =new JFrame();
        previous=new JButton("Log out");
        welcome=new JLabel();
        Tic_tac_toe=new JButton("Play Tic Tac Toe");
        simple_quiz_game=new JButton("Play simple quiz game");

        welcome.setText("WELCOME!!");
        welcome.setBounds(20,20,150,60);

        Tic_tac_toe.setBounds(10,100,250,30);
        Tic_tac_toe.setFocusable(false);
        Tic_tac_toe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Tic_tac_toe){
                    //new Tictactoe();
                    frame2.dispose();
                }
            }
        });
        simple_quiz_game.setBounds(10,150,250,30);
        simple_quiz_game.setFocusable(false);
        simple_quiz_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==simple_quiz_game){
                    new logic();
                    frame2.dispose();
                }
            }
        });


        previous.setBounds(250,250,100,30);
        previous.addActionListener(this);
        previous.setFocusable(false);

        frame2.setSize(400,400);
        frame2.setLayout(null);
        frame2.setVisible(true);
        frame2.setBackground(Color.BLUE);

        frame2.add(previous);
        frame2.add(welcome);
        frame2.add(Tic_tac_toe);
        frame2.add(simple_quiz_game);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==previous){
            frame2.dispose();
            new loginPage();
        }
    }
}
class signUpPage implements ActionListener{
    JFrame frame3;
    JButton submit;
    JTextField username;
    JLabel name;
    JLabel pass;
    JPasswordField password;
    signUpPage(){
        frame3=new JFrame();
        username=new JTextField();
        password=new JPasswordField();
        submit=new JButton("submit");
        name=new JLabel("Username:");
        pass=new JLabel("Password:");

        name.setBounds(10,100,70,30);

        pass.setBounds(10,140,70,30);

        username.setBounds(100,100,190,30);

        password.setBounds(100,140,190,30);


        submit.setBounds(160,180,80,40);
        submit.setFocusable(false);
        submit.addActionListener(this);

        frame3.setSize(400,400);
        frame3.setLayout(null);
        frame3.setVisible(true);

        frame3.add(name);
        frame3.add(pass);
        frame3.add(username);
        frame3.add(password);
        frame3.add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==submit){
              try {
               FileWriter save=new FileWriter("signUp.txt",true);
                  String pass=""+new String(password.getPassword());
                  save.write(""+username.getText()+"\t"+""+pass+"\n");
                  save.close();
              } catch (IOException ex) {
                  throw new RuntimeException(ex);
              }
              JOptionPane.showMessageDialog(null,"Successfully Submitted");
              frame3.dispose();
          }
    }
}
class driverClass{
    public static void main(String[] args){
        new loginPage();
    }
}