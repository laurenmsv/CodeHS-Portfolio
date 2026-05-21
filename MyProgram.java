import javax.swing.JFrame;

public class MyProgram {
    public static void main(String[] args) {
     
         JFrame MainFrame = new JFrame();
        
        MainFrame.setSize(600,800);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
Panel panel = new Panel();
  
MainFrame.add(panel);
           
       MainFrame.setVisible(true);
     
     panel.requestFocus();
     
     
    }
}
