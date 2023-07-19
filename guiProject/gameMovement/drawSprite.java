package guiProject.gameMovement;

import guiProject.gameMovement.entity.Player;

import javax.swing.*;
import java.awt.*;

public class drawSprite extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int maxScreenWidth = maxScreenCol * tileSize;
    final int maxScreenHeight = maxScreenRow * tileSize;
    int x = 100;
    int y = 100;
    int speed = 4;
    double FPS = 60;
    moveChar move = new moveChar();
    Thread gameThread;

    Player player=new Player(move,this);

    drawSprite() {
        this.setPreferredSize(new Dimension(maxScreenWidth, maxScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double interval = 1000000000 / FPS;
        double delta = 0;
        long timer = 0;
        int fpsCounter = 0;
        while (gameThread != null) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            while (delta >= 1) {
                update();
                repaint();
                fpsCounter++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + fpsCounter);
                fpsCounter = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        player.paint(g);

        Graphics2D graphics = (Graphics2D) g;

    }
}
