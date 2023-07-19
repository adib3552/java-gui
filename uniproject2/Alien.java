package uniproject2;

public class Alien {
     public int enemyX;
     public int enemyY;
     public boolean isVisible;
     public boolean moveLeft;
     public boolean moveRight;
    public boolean showBlast;
     Alien(int x, int y){
         enemyX=x;
         enemyY=y;
         isVisible=true;
         moveLeft=false;
         moveRight=true;
     }
}
