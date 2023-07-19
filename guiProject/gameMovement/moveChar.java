package guiProject.gameMovement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class moveChar implements KeyListener {
    public boolean up, down, right, left;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            right = true;
        } else if (e.getKeyChar() == 'w') {
            up = true;
        } else if (e.getKeyChar() == 's') {
            down = true;
        } else if (e.getKeyChar() == 'a') {
            left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            right = false;
        } else if (e.getKeyChar() == 'w') {
            up = false;
        } else if (e.getKeyChar() == 's') {
            down = false;
        } else if (e.getKeyChar() == 'a') {
            left = false;
        }

    }
}
