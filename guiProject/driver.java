package guiProject;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class driver{
  public static void main(String[] args){
      new quizGame();
  }
}


class quizGame implements ActionListener {
    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JRadioButton Easy;
    JRadioButton Medium;
    JRadioButton Hard;
    JLabel intro;
    JLabel difficulty;
    JLabel question=new JLabel();
    JButton start;
    JButton submit;
    JButton next;
    JPanel parentPanel;
    int num1;
    int num2;
    int num3;
    int num4;
    int result;
    JRadioButton[] options=new JRadioButton[4];
    char[] operator={'+','-','X'};
    CardLayout cardLayout;
    JLabel timer;
    quizGame(){
      frame =new JFrame();
      panel1 =new JPanel();
      Easy =new JRadioButton();
      Medium=new JRadioButton();
      Hard=new JRadioButton();
      intro=new JLabel();
      difficulty =new JLabel();
      start =new JButton("Start");
      panel2=new JPanel();
      panel3=new JPanel();
      panel4=new JPanel();
      parentPanel=new JPanel();
      cardLayout=new CardLayout();

      parentPanel.setLayout(cardLayout);


      intro.setText("SIMPLE MATH QUIZ!");
      intro.setSize(250,100);
      intro.setFont(new Font(null,Font.PLAIN,50));

      difficulty.setText("Select Difficulty:        ");
      difficulty.setFont(new Font(null,Font.BOLD,20));

      Easy.setText("Easy");
      Easy.setFocusable(false);
      Easy.addActionListener(this);
      Medium.setText("Medium");
      Medium.setFocusable(false);
      Medium.addActionListener(this);
      Hard.setText("Hard");
      Hard.setFocusable(false);
      Hard.addActionListener(this);

      ButtonGroup group=new ButtonGroup();
      group.add(Easy);
      group.add(Medium);
      group.add(Hard);

      start.setFocusable(false);
      start.setPreferredSize(new Dimension(100,25));
      start.setBackground(Color.RED);
      start.addActionListener(this);

      //panel1.setSize(100,100);
      panel1.setPreferredSize(new Dimension(500,100));
      panel1.add(intro);
      panel1.add(difficulty);
      panel1.add(Easy);
      panel1.add(Medium);
      panel1.add(Hard);
      panel1.add(start);


      //panel2.setBackground(Color.RED);

      panel3.setPreferredSize(new Dimension(300,300));
      panel3.setBackground(Color.BLUE);

      panel4.setPreferredSize(new Dimension(300,300));
      panel4.setBackground(Color.GREEN);

      parentPanel.add(panel1,"1");
      parentPanel.add(panel2,"2");
      parentPanel.add(panel3,"3");
      parentPanel.add(panel4,"4");
      cardLayout.show(parentPanel,"1");

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300,300);
      frame.add(parentPanel);
      //frame.pack();
      frame.setVisible(true);

    }

    public void easy(){
        next=new JButton("Next");
        next.setFocusable(false);
        next.setBounds(150,200,50,30);
        ButtonGroup group=new ButtonGroup();

        for (int i=0; i<options.length; i++){
            num1=(int)(1+Math.random()*(999-1+1));
            options[i]=new JRadioButton(""+num1);
            options[num4]=new JRadioButton(""+result);
            group.add(options[i]);
        }


        num1=(int)(1+Math.random()*(999-1+1));
        num2=(int)(1+Math.random()*(999-1+1));
        num3=(int)(0+Math.random()*(2-0+1));
        num4=(int)(0+Math.random()*(3-0+1));
        result(num3);
        question.setText(""+num1+""+operator[num3]+""+num2+"=?");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==next){
                    num1=(int)(1+Math.random()*(999-1+1));
                    num2=(int)(1+Math.random()*(999-1+1));
                    num3=(int)(0+Math.random()*(2-0+1));
                    num4=(int)(0+Math.random()*(3-0+1));

                    result(num3);
                    question.setText(""+num1+""+operator[num3]+""+num2+"=?");
                    for (int i=0; i<options.length; i++){
                        num1=(int)(1+Math.random()*(999-1+1));
                        options[i].setText(""+num1);
                        options[num4].setText(""+result);
                        //panel2.add(options[i]);
                    }
                    if (options[num4].isSelected()){
                        question.setBackground(Color.GREEN);
                        options[num4].getDisabledIcon();
                    }
                }
            }
        });

        panel2.setSize(300,300);
        panel2.add(question);
        for (int i=0; i<options.length; i++){
            panel2.add(options[i]);
        }
        if (options[num4].isSelected()){
            question.setBackground(Color.GREEN);
            options[num4].getDisabledIcon();
        }

        panel2.add(next);
        cardLayout.show(parentPanel, "2");
    }
    public void result(int r){
        if (r==0){
            result=num1+num2;
        }
        else if(r==1){
            if (num1>num2)
                result=num1-num2;
            else
                result=num2-num1;
        }
        else if(r==2){
            result=num1*num2;
        }
    }

        @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource()==start) {
         if (Easy.isSelected()) {
             easy();
         }
         if (Medium.isSelected()) {
             cardLayout.show(parentPanel, "3");
         }
         if (Hard.isSelected()) {
             cardLayout.show(parentPanel, "4");
         }
     }
    }
}
