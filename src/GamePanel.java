import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, 50, 50);
    }
}
