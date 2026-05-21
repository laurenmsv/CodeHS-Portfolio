import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;

public class Panel extends JPanel implements KeyListener{
    
    MyRect rect=new MyRect();
    Car car = new Car();
    
    ArrayList<Obstacle> obstacles = new ArrayList<>();
    
    Timer timer;
    boolean gameRunning=false;
    
    int score = 0;
    int highScore = 0;
    int spawnCounter =0;
    
    public Panel(){
    
    setBackground(Color.GRAY);
      setFocusable(true);  
        addKeyListener(this);
        
         timer = new Timer (100, e-> {
        
      
           if(gameRunning){
                rect.move();
                spawnCounter++;
                
                if(spawnCounter>37){
                    obstacles.add(new Obstacle());
                    spawnCounter=0;
                }
                
                for (int i=0;i<obstacles.size(); i++){
                    Obstacle o = obstacles.get(i);
                    o.move();
                    
                    if(o.checkCollision(car)){
                        gameRunning = false;
                        
                        if (score>highScore){
                            highScore = score;
                        }
                    }
                    if (o.isOffScreen()){
                        obstacles.remove(i);
                        score++;
                        i--;
                    }
                }
                
            }
            repaint();
        });
    timer.start();
    
    addMouseListener(new MouseAdapter(){
        @Override 
        public void mouseClicked(MouseEvent e){
          if(!gameRunning){
              gameRunning = true;
              score =0;
              obstacles.clear();
          }
        }
    });
}
    
    
    @Override
    public void addNotify(){
        super.addNotify();
        requestFocus();
    }
    
    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        rect.draw(g);
       
       for(Obstacle o : obstacles){
           o.draw(g);
       }
        car.draw(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font ("Arial", Font.BOLD, 20));
        
        g.drawString("Score: " + score, 20,30);
        g.drawString("High Score: " + highScore, 360, 30);
        
        if(!gameRunning){
            g.setFont(new Font ("Arial",Font.BOLD, 40));
       
            if(score ==0){
                g.drawString("Click to Start!", 150, 350);
            } else {
                g.drawString("Game Over", 180,300);
                g.drawString("High Score: " + highScore, 160, 350);
                  g.drawString("Click to Start!", 150, 400);
            }
        }
    
        
    }

    
    
    @Override
    public void keyPressed(KeyEvent e){
       if(gameRunning){
           if(e.getKeyCode()==KeyEvent.VK_LEFT){
               car.moveLeft();
           }
           
           if (e.getKeyCode()==KeyEvent.VK_RIGHT){
               car.moveRight();
           }
       }
    }
    
@Override
public void keyReleased(KeyEvent e){}
@Override
public void keyTyped(KeyEvent e){}

}
