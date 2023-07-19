package guiBasics;

import javax.swing.*;

public class optionpane {
    //JOptionPane = pop up a standard dialog that prompts user for a value or informs about something

    public static void main(String[] args){
        ImageIcon image=new ImageIcon("sun.jpg");

        while(true){
            JOptionPane.showMessageDialog(null,"You need to work hard", "message", JOptionPane.PLAIN_MESSAGE);
        }
        //JOptionPane.showMessageDialog(null,"You need to work hard", "message", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null,"You need to work hard", "message", JOptionPane.QUESTION_MESSAGE);
        //JOptionPane.showMessageDialog(null,"You need to work hard", "message", JOptionPane.ERROR_MESSAGE);
        //JOptionPane.showMessageDialog(null,"You need to work hard", "message", JOptionPane.WARNING_MESSAGE);

        //String name= JOptionPane.showInputDialog("What is your name? : ");
        //System.out.println("Hello "+name);
      /*
        int value=JOptionPane.showConfirmDialog(null,"Is java hard?","title",JOptionPane.YES_NO_CANCEL_OPTION);
        if (value==2){
            JOptionPane.showMessageDialog(null,"Answer the question","message",JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showConfirmDialog(null,"Is java hard?","title",JOptionPane.YES_NO_CANCEL_OPTION);
        }
        else if (value==0){
            System.out.println("IKR");
        }
        else if (value==1){
            System.out.println("you're a genius");
        }
       */
        /*
        String[] responses={"Yeah! pretty hot","Nope","IDK"};
        JOptionPane.showOptionDialog(null,
                "Is it hot outside?",
                "random",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                image,
                responses,
                0);

         */
    }
}
