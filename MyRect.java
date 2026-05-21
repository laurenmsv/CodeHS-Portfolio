import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

//draws the road lines 
    public class MyRect {
        int x = 200;
        int y = -200;
        int width = 6;
        int height = 50;
    Color color = Color.WHITE;
      
      int speed = 50;

      
      
      
      public void draw (Graphics g){
g.setColor(color);
for ( int i=0; i< 400;i+=200){
    for(int j = 0; j<1000 ;j+=100){
        
    
        g.fillRect(x + i,y+j,width,height);
}
    }
      }
      
      public void move(){
    y += speed;
    if(y>=100){
        y=0;
    }
}
    
      }
