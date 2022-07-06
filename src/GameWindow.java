import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(GamePanel gamePanel) {
        JFrame jframe = new JFrame();
        
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setVisible(true);
    }
}
