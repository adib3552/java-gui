package guiProject.gameMovement;

import javax.swing.*;


public class CharacterSprite extends JFrame {
    drawSprite sprite;
    CharacterSprite(){
        sprite=new drawSprite();

        sprite.startGameThread();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(sprite);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

