package guiProject.gameMovement.entity;

import guiProject.gameMovement.drawSprite;
import guiProject.gameMovement.moveChar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    moveChar move;
    drawSprite sprite;


    public Player(moveChar move,drawSprite sprite){
        this.move=move;
        this.sprite=sprite;
        setDefaultValues();
        loadImage();
    }
    public void setDefaultValues(){
         x=100;
         y=100;
         speed=4;
         directions="down";
    }
    public void loadImage(){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_up1.png")));
            up2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_up2.png")));
            down1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_down1.png")));
            down2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_down2.png")));
            right1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_right1.png")));
            right2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_right2.png")));
            left1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_left1.png")));
            left2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/link_left2.png")));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    public void update() {
        if(move.up || move.down || move.right || move.left) {
            if (move.up == true) {
                directions = "up";
                y -= speed;
            } else if (move.down == true) {
                directions = "down";
                y += speed;
            } else if (move.right == true) {
                directions = "right";
                x += speed;
            } else if (move.left == true) {
                directions = "left";
                x -= speed;
            }
            spriteCounter++;
            if (spriteCounter > 14) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void paint(Graphics g2) {


        //Graphics2D graphics = (Graphics2D) g;
        //graphics.setColor(Color.white);
        //graphics.fillRect(x, y, sprite.tileSize, sprite.tileSize);

        BufferedImage image=null;

        switch (directions){
            case "up":
                if(spriteNum==1){
                    image=up1;
                }
                else if(spriteNum==2){
                    image=up2;
                }
            break;
            case "down":
                if(spriteNum==1){
                    image=down1;
                }
                else if(spriteNum==2){
                    image=down2;
                }
                break;
            case "right":
                if(spriteNum==1){
                    image=right1;
                }
                else if(spriteNum==2){
                    image=right2;
                }
                break;
            case "left":
                if(spriteNum==1){
                    image=left1;
                }
                else if(spriteNum==2){
                    image=left2;
                }
                break;
        }
        g2.drawImage(image,x,y,sprite.tileSize,sprite.tileSize,null);
    }
}
