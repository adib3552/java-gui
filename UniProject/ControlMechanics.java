package UniProject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlMechanics implements KeyListener {
    boolean up,down,right,left;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='w'){
            up=true;
            down=false;
            right=false;
            left=false;
        }
        if (e.getKeyChar()=='s'){
            up=false;
            down=true;
            right=false;
            left=false;
        }
        if (e.getKeyChar()=='d'){
            up=false;
            down=false;
            right=true;
            left=false;
        }
        if (e.getKeyChar()=='a'){
            up=false;
            down=false;
            right=false;
            left=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        /*
        if (e.getKeyChar()=='w'){
            up=false;
        }
        if (e.getKeyChar()=='s'){
            down=false;
        }
        if (e.getKeyChar()=='d'){
            right=false;
        }
        if (e.getKeyChar()=='a'){
            left=false;
        }

         */
    }
}
