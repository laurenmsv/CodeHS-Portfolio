import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;

public class Obstacle {
    
    int lane;
    int[] laneX = {55,265,465};
    
    int x;
    int y = -100;
    int width = 100;
    int height = 100;
    int speed = 15;
    
    Image image;
    Random rand = new Random();
    
    public Obstacle(){
        lane = rand.nextInt(3);
    int laneWidth=200;
    x= laneX[lane] +(laneWidth-width)/2;
        int type = rand.nextInt(3);
        
        if(type == 0){
            image = new ImageIcon("cone.png").getImage();
        }
        else if (type==1){
            image = new ImageIcon("man.png").getImage();
    } 
    else {
           image = new ImageIcon("boulder.png").getImage();
    }
}


public void move (){
    y +=speed;
}

public void draw (Graphics g){
    g.drawImage(image, laneX[lane], y, width, height, null);
}

public boolean isOffScreen(){
    return y>800;
}

public boolean checkCollision(Car car){
    int pad = 22;
    
    return x < car.getX() + car.getWidth()-pad && 
  x + width -pad> car.getX()+pad &&
    y+pad>car.getY()+ car.getHeight()-pad&&
    y+height-pad>car.getY()+pad;
}
}
