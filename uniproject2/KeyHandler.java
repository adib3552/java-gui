package uniproject2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    boolean right, left, shoot, restart, shootSound, start;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='a'){
            left=true;
        }
        else if(e.getKeyChar()=='d'){
            right=true;
        }
        else if(e.getKeyChar()==' '){
            shootSound=true;
            shoot=true;
        }
        else if(e.getKeyChar()=='r'){
            restart=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar()=='a'){
            left=false;
        }
        else if(e.getKeyChar()=='d'){
            right=false;
        }
        else if(e.getKeyChar()==' '){
            shootSound=false;
        }
    }
}
