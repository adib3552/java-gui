package uniproject2;
import javax.swing.*;

public class gameFrame extends JFrame{
    gameFrame(){
        gamePanel gp=new gamePanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gp);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        }
}
