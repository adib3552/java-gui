package guiProject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calendar {
    public static void main(String[] args){

        new Design();
    }
}
class Design implements ActionListener {
    JFrame frame;
    JPanel panel31;
    JPanel panel30;
    JPanel panel28;
    JPanel parentPanel;
    String[] bar={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    JLabel[] days;
    JLabel[] bars31;
    JLabel[] bars30;
    JLabel[] bars28;
    CardLayout cardLayout;
    JComboBox months;
    JComboBox years;
    JLabel monthYearName;
    String[] month={"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};
    int[] year;
    JButton jump;
    String m;
    int y;
    Design(){
        jump=new JButton("Jump");
        year=new int[1000];
        frame=new JFrame();
        panel31=new JPanel();
        panel30=new JPanel();
        panel28=new JPanel();
        days=new JLabel[32];
        bars31=new JLabel[7];
        bars30=new JLabel[7];
        bars28=new JLabel[7];
        monthYearName=new JLabel();
        months=new JComboBox(month);
        years=new JComboBox();
        cardLayout =new CardLayout();
        parentPanel=new JPanel();
        Border border=BorderFactory.createLineBorder(Color.WHITE,5);

        parentPanel.setLayout(cardLayout);

        monthYearName.setBounds(300,18,200,30);
        monthYearName.setBackground(null);
        monthYearName.setFont(new Font(null,Font.BOLD,20));

        months.setBounds(10,10,90,30);
        months.addActionListener(this);

        int y=1950;
        for (int i=0; i<1000; i++){
            year[i]=y;
            y++;
            years.addItem(year[i]);
        }



        years.setBounds(100,10,60,30);
        years.addActionListener(this);
        monthYearName.setText(""+months.getSelectedItem()+"-"+""+years.getSelectedItem());

        jump.setBounds(180,10,100,30);
        jump.setFocusable(false);
        jump.addActionListener(this);

        for (int i=0; i< bar.length; i++){
            bars31[i]=new JLabel(""+bar[i]);
            bars31[i].setHorizontalAlignment(JLabel.CENTER);
            bars31[i].setVerticalAlignment(JLabel.BOTTOM);

            bars30[i]=new JLabel(""+bar[i]);
            bars30[i].setHorizontalAlignment(JLabel.CENTER);
            bars30[i].setVerticalAlignment(JLabel.BOTTOM);

            bars28[i]=new JLabel(""+bar[i]);
            bars28[i].setHorizontalAlignment(JLabel.CENTER);
            bars28[i].setVerticalAlignment(JLabel.BOTTOM);
        }
        for (int i=0; i<bars31.length; i++){
            panel31.add(bars31[i]);
            panel30.add(bars30[i]);
            panel28.add(bars28[i]);
        }


        panel28.setBounds(10,100,560,470);
        panel28.setLayout(new GridLayout(5,6));


        for(int i=1; i<29; i++){
            days[i]=new JLabel(""+i);
            days[i].setHorizontalAlignment(JLabel.CENTER);
            //days[i].setBackground(Color.BLUE);
            days[i].setBorder(border);
            panel28.add(days[i]);
        }



        panel30.setBounds(10,100,560,470);
        panel30.setLayout(new GridLayout(6,6));


        for(int i=1; i<31; i++){
            days[i]=new JLabel(""+i);
            days[i].setHorizontalAlignment(JLabel.CENTER);
            //days[i].setBackground(Color.BLUE);
            days[i].setBorder(border);
            panel30.add(days[i]);
        }


        panel31.setBounds(10,1000,560,470);
        panel31.setLayout(new GridLayout(6,6));


        for(int i=1; i<32; i++){
            days[i]=new JLabel(""+i);
            days[i].setHorizontalAlignment(JLabel.CENTER);
            //days[i].setBackground(Color.BLUE);
            days[i].setBorder(border);
            panel31.add(days[i]);
        }

        parentPanel.add(panel28,"1");
        parentPanel.add(panel30,"2");
        parentPanel.add(panel31,"3");
        cardLayout.show(parentPanel,"3");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);
        //frame.setLayout(null);

        frame.add(jump);
        frame.add(years);
        frame.add(monthYearName);
        frame.add(months);
        frame.add(parentPanel);
        //frame.pack();
        //frame.add(panel31);
        //frame.add(panel30);
        //frame.add(panel28);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index=0;
        if(e.getSource()==months ){
            index=months.getSelectedIndex();
            m= (String) months.getSelectedItem();
        }
        if (e.getSource()==years){
            y=(int)years.getSelectedItem();
        }
        if(e.getSource()==jump) {
            monthYearName.setText("" + m + "-" + "" + y);
        }

            if (index == 0 || index == 2 || index == 4 || index == 6 || index == 8 || index == 10 || index == 12) {
                cardLayout.show(parentPanel, "3");
            } else if (index == 1) {
                cardLayout.show(parentPanel, "1");
            } else {
                cardLayout.show(parentPanel, "2");
            }

    }
}