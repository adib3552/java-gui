package guiProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simpleQuizGame {
    public static void main(String[] args){

        new logic();
    }
}
class logic implements ActionListener {
    JFrame frame;
    JPanel parentPanel;
    JPanel introPanel;
    JPanel easyPanel;
    JLabel gameName;
    JTextField timer;
    JRadioButton Easy;
    JRadioButton Medium;
    JRadioButton Hard;
    JLabel description;
    JPanel scorePanel;
    int seconds=10;
    int score;
    int numCor;
    int numWro;
    char[] operator=new char[]{'+','-','X','/'};
    int num1;
    int num2;
    int opIndex;
    int randomIndex;
    int answer;
    int qNum;
    JLabel question;
    JButton next;
    JButton submit;
    JRadioButton[] options=new JRadioButton[4];
    JLabel difficulty;
    JButton start;
    JLabel showScore;
    JLabel showCor;
    JLabel showWro;
    JLabel showSkip;
    CardLayout cardlayout=new CardLayout();

    Timer t=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          seconds--;
          timer.setText("Timer: "+seconds);
          if (seconds==0){
              t.stop();
              for (int i=0; i<4; i++){
                  options[i].setForeground(Color.RED);
              }
              options[randomIndex].setForeground(Color.GREEN);
              submit.setEnabled(false);
          }
        }
    });
    logic(){
    frame=new JFrame();
    parentPanel=new JPanel();
    introPanel=new JPanel();
    easyPanel=new JPanel();
    scorePanel=new JPanel();
    gameName=new JLabel();
    description=new JLabel();
    difficulty=new JLabel();
    Easy=new JRadioButton("Easy");
    Medium=new JRadioButton("Medium");
    Hard=new JRadioButton("Hard");
    start=new JButton("Start!");

    gameName.setBounds(5,5,400,70);
    gameName.setText("SIMPLE MATH QUIZ!");
    gameName.setForeground(Color.GREEN);
    gameName.setFont(new Font("Mv boli",Font.PLAIN,25));

    description.setBounds(50,50,400,70);
    description.setText("Here you will answer some simple math question in a limited time!");
    description.setForeground(Color.GREEN);
    description.setFont(new Font("Mv boli",Font.PLAIN,11));

    difficulty.setBounds(75,50,70,70);
    difficulty.setText("Set difficulty: ");
    difficulty.setForeground(Color.GREEN);
    difficulty.setFont(new Font("Mv boli",Font.PLAIN,15));

    Easy.setBounds(120,70,50,70);
    Easy.setFocusable(false);
    Easy.setFont(new Font("Mv boli",Font.PLAIN,15));
    Easy.setBackground(Color.BLACK);
    Easy.setForeground(Color.GREEN);

    Medium.setBounds(130,70,50,70);
    Medium.setFocusable(false);
    Medium.setFont(new Font("Mv boli",Font.PLAIN,15));
    Medium.setBackground(Color.BLACK);
    Medium.setForeground(Color.GREEN);

    Hard.setBounds(130,70,50,70);
    Hard.setFocusable(false);
    Hard.setFont(new Font("Mv boli",Font.PLAIN,15));
    Hard.setBackground(Color.BLACK);
    Hard.setForeground(Color.GREEN);

    start.setBounds(130,100,50,50);
    start.setFocusable(false);
    start.setFont(new Font("Mv boli",Font.PLAIN,20));
    start.setBackground(Color.BLACK);
    start.setForeground(Color.GREEN);
    start.addActionListener(this);

    ButtonGroup group=new ButtonGroup();
    group.add(Easy);
    group.add(Medium);
    group.add(Hard);

    parentPanel.setLayout(cardlayout);

    introPanel.setSize(400,250);
    introPanel.setBackground(Color.BLACK);
    introPanel.add(gameName);
    introPanel.add(description);
    introPanel.add(difficulty);
    introPanel.add(Easy);
    introPanel.add(Medium);
    introPanel.add(Hard);
    introPanel.add(start);

    parentPanel.add(introPanel,"1");
    parentPanel.add(easyPanel,"2");
    parentPanel.add(scorePanel,"0");

    frame.setSize(450,250);
    frame.setVisible(true);

    frame.add(parentPanel);
    }

    public void forEasy(){
        easyPanel.setSize(400,250);
        easyPanel.setBackground(Color.BLACK);
        easyPanel.setLayout(new FlowLayout(10,10,15));


        num1=(int)(1+Math.random()*(100-1+1));
        num2=(int)(1+Math.random()*(100-1+1));
        opIndex=(int)(0+Math.random()*(1-0+1));

        qNum=1;
        question=new JLabel();
        question.setBounds(15,40,150,40);
        question.setText(""+qNum+")"+"What is "+num1+""+operator[opIndex]+""+num2+"=?");
        question.setBackground(Color.BLACK);
        question.setForeground(Color.GREEN);
        question.setFont(new Font("Mv boli",Font.PLAIN,15));
        question.setVerticalAlignment(JLabel.BOTTOM);
        result(opIndex);

        ButtonGroup group=new ButtonGroup();

        for(int i=0; i<options.length; i++){
            int rand=0;
            num1=(int)(1+Math.random()*(100-1+1));
            randomIndex=(int)(0+Math.random()*(3-0+1));
            options[i]=new JRadioButton();
            options[randomIndex]=new JRadioButton();
            //options[i].setBounds(15,75+(rand+15),100,20);
            options[i].setText(""+num1);
            options[i].setFont(new Font("Mv boli",Font.PLAIN,15));
            options[i].setBackground(Color.BLACK);
            options[i].setForeground(Color.WHITE);
            options[i].setFocusable(false);
            options[randomIndex].setFont(new Font("Mv boli",Font.PLAIN,15));
            options[randomIndex].setBackground(Color.BLACK);
            options[randomIndex].setForeground(Color.WHITE);
            options[randomIndex].setFocusable(false);
            group.add(options[i]);
            group.add(options[randomIndex]);
            options[randomIndex].setText(""+answer);
        }

        timer=new JTextField();
        timer.setBounds(250,10,60,20);
        timer.setText("Timer: "+seconds);
        timer.setBackground(Color.BLACK);
        timer.setFont(new Font("Mv boli",Font.PLAIN,15));
        timer.setForeground(Color.GREEN);
        t.start();

        next=new JButton("Next>>");
        next.setBounds(280,300,100,30);
        next.setFocusable(false);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.GREEN);
        next.setFont(new Font("Mv boli",Font.PLAIN,15));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==next){
                    qNum++;
                    submit.setEnabled(true);
                    num1=(int)(1+Math.random()*(100-1+1));
                    num2=(int)(1+Math.random()*(100-1+1));
                    opIndex=(int)(0+Math.random()*(1-0+1));
                    question.setText(""+qNum+")"+"What is "+num1+""+operator[opIndex]+""+num2+"=?");
                    result(opIndex);

                    for(int i=0; i<options.length; i++){
                        num1=(int)(1+Math.random()*(100-1+1));
                        randomIndex=(int)(0+Math.random()*(3-0+1));
                        options[i].setText(""+num1);
                        options[i].setBackground(Color.BLACK);
                        options[i].setForeground(Color.WHITE);
                        group.add(options[i]);
                    }
                    options[randomIndex].setText(""+answer);
                      seconds=11;
                      t.restart();
                    if(qNum>10){
                        next.setEnabled(false);
                        scoreBoard(score,numCor,numWro);
                    }
                }
            }
        });

        submit=new JButton("Submit");
        submit.setBounds(80,300,100,30);
        submit.setFocusable(false);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.GREEN);
        submit.setFont(new Font("Mv boli",Font.PLAIN,15));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submit){
                    submit.setEnabled(false);
                    if(options[randomIndex].isSelected()){
                        for (int i=0;i<4;i++){
                            options[i].setForeground(Color.red);
                        }
                        options[randomIndex].setForeground(Color.GREEN);
                        score++;
                        numCor++;
                    }
                    else{
                        for (int i=0;i<4;i++){
                            options[i].setForeground(Color.red);
                        }
                        options[randomIndex].setForeground(Color.GREEN);
                        numWro++;
                    }
                    t.stop();
                }
            }
        });

        cardlayout.show(parentPanel,"2");
        easyPanel.add(question);
        for(int i=0; i<options.length; i++){
            easyPanel.add(options[i]);
        }
        easyPanel.add(submit);
        easyPanel.add(next);
        easyPanel.add(timer);
    }

    public void result(int res){
        if (opIndex==0){
            answer=num1+num2;
        }
        else if(opIndex==1){
            answer=num1-num2;
        }
        else if(opIndex==2){
            answer=num1*num2;
        }
    }
    public void scoreBoard(int a,int b,int c){
        showScore=new JLabel();
        showCor=new JLabel();
        showWro=new JLabel();
        showSkip=new JLabel();
        int skip=10-(b+c);

        showWro.setText("Wrong Answers: "+c);
        showWro.setBounds(10,80,200,30);
        showWro.setBackground(Color.BLACK);
        showWro.setForeground(Color.RED);
        showWro.setFont(new Font("Mv boli",Font.PLAIN,20));

        showSkip.setText("Questions skipped: "+skip);
        showSkip.setBounds(10,120,250,30);
        showSkip.setBackground(Color.BLACK);
        showSkip.setForeground(Color.RED);
        showSkip.setFont(new Font("Mv boli",Font.PLAIN,20));

        showCor.setText("Correct Answers: "+b);
        showCor.setBounds(10,50,200,30);
        showCor.setBackground(Color.BLACK);
        showCor.setForeground(Color.GREEN);
        showCor.setFont(new Font("Mv boli",Font.PLAIN,20));

        showScore.setText("Your Score: "+a);
        showScore.setBounds(10,20,200,30);
        showScore.setBackground(Color.BLACK);
        showScore.setForeground(Color.WHITE);
        showScore.setFont(new Font("Mv boli",Font.PLAIN,20));

        scorePanel.setSize(400,250);
        scorePanel.setLayout(null);
        scorePanel.setBackground(Color.BLACK);
        scorePanel.add(showScore);
        scorePanel.add(showCor);
        scorePanel.add(showWro);
        scorePanel.add(showSkip);
        cardlayout.show(parentPanel,"0");
    }
    public void forMedium(){
        easyPanel.setSize(450,250);
        easyPanel.setBackground(Color.BLACK);
        easyPanel.setLayout(new FlowLayout(10,5,10));


        num1=(int)(1+Math.random()*(100-1+1));
        num2=(int)(1+Math.random()*(100-1+1));
        opIndex=(int)(0+Math.random()*(2+1));
        if (opIndex==0 || opIndex==1){
            num1=(int)(150+Math.random()*(999-150+1));
            num2=(int)(150+Math.random()*(999-150+1));
        }

        qNum=1;
        question=new JLabel();
        question.setBounds(15,40,150,40);
        question.setText(""+qNum+")"+"What is "+num1+""+operator[opIndex]+""+num2+"=?");
        question.setBackground(Color.BLACK);
        question.setForeground(Color.GREEN);
        question.setFont(new Font("Mv boli",Font.PLAIN,15));
        question.setVerticalAlignment(JLabel.BOTTOM);
        result(opIndex);

        ButtonGroup group=new ButtonGroup();

        for(int i=0; i<options.length; i++){
            int rand=0;
            num1=(int)(200+Math.random()*(1500-200+1));
            randomIndex=(int)(0+Math.random()*(3+1));
            options[i]=new JRadioButton();
            options[randomIndex]=new JRadioButton();
            //options[i].setBounds(15,75+(rand+15),100,20);
            options[i].setText(""+num1);
            options[i].setFont(new Font("Mv boli",Font.PLAIN,15));
            options[i].setBackground(Color.BLACK);
            options[i].setForeground(Color.WHITE);
            options[i].setFocusable(false);
            options[randomIndex].setFont(new Font("Mv boli",Font.PLAIN,15));
            options[randomIndex].setBackground(Color.BLACK);
            options[randomIndex].setForeground(Color.WHITE);
            options[randomIndex].setFocusable(false);
            group.add(options[i]);
            group.add(options[randomIndex]);
            options[randomIndex].setText(""+answer);
        }

        timer=new JTextField();
        timer.setBounds(250,10,60,20);
        timer.setText("Timer: "+seconds);
        timer.setBackground(Color.BLACK);
        timer.setFont(new Font("Mv boli",Font.PLAIN,15));
        timer.setForeground(Color.GREEN);
        t.start();

        next=new JButton("Next>>");
        next.setBounds(280,300,100,30);
        next.setFocusable(false);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.GREEN);
        next.setFont(new Font("Mv boli",Font.PLAIN,15));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==next){
                    qNum++;
                    submit.setEnabled(true);
                    num1=(int)(1+Math.random()*(100-1+1));
                    num2=(int)(1+Math.random()*(100-1+1));
                    opIndex=(int)(0+Math.random()*(2+1));
                    if (opIndex==0 || opIndex==1){
                        num1=(int)(150+Math.random()*(999-150+1));
                        num2=(int)(150+Math.random()*(999-150+1));
                    }
                    question.setText(""+qNum+")"+"What is "+num1+""+operator[opIndex]+""+num2+"=?");
                    result(opIndex);

                    for(int i=0; i<options.length; i++){
                        num1=(int)(200+Math.random()*(1500-200+1));
                        if(answer<0){
                            options[i].setText(""+(num1*(-1)));
                        }
                        randomIndex=(int)(0+Math.random()*(3-0+1));
                        options[i].setText(""+num1);
                        options[i].setBackground(Color.BLACK);
                        options[i].setForeground(Color.WHITE);
                        group.add(options[i]);
                    }
                    options[randomIndex].setText(""+answer);
                    seconds=11;
                    t.restart();
                    if(qNum>10){
                        next.setEnabled(false);
                        scoreBoard(score,numCor,numWro);
                    }
                }
            }
        });

        submit=new JButton("Submit");
        submit.setBounds(80,300,100,30);
        submit.setFocusable(false);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.GREEN);
        submit.setFont(new Font("Mv boli",Font.PLAIN,15));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submit){
                    submit.setEnabled(false);
                    if(options[randomIndex].isSelected()){
                        for (int i=0;i<4;i++){
                            options[i].setForeground(Color.red);
                        }
                        options[randomIndex].setForeground(Color.GREEN);
                        score++;
                        numCor++;
                    }
                    else{
                        for (int i=0;i<4;i++){
                            options[i].setForeground(Color.red);
                        }
                        options[randomIndex].setForeground(Color.GREEN);
                        numWro++;
                    }
                    t.stop();
                }
            }
        });

        cardlayout.show(parentPanel,"2");
        easyPanel.add(question);
        for(int i=0; i<options.length; i++){
            easyPanel.add(options[i]);
        }
        easyPanel.add(submit);
        easyPanel.add(next);
        easyPanel.add(timer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==start){
         if(Easy.isSelected()){
           forEasy();
         }
         else if(Medium.isSelected()){
           forMedium();
         }
         else if(Hard.isSelected()){

         }
     }
    }
}
