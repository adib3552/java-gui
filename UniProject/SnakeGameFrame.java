package UniProject;

import javax.swing.*;

public class SnakeGameFrame extends JFrame {
    GamePanel panel;
    SnakeGameFrame(){
        panel=new GamePanel();
        panel.startGameThread();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
