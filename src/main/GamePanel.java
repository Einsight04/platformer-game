package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 0.1f, yDir = 0.1f;
    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(150, 20, 90);
    private final Random random = new Random();

    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateRectangle();
        g.setColor(color);
        g.fillRect(((int) xDelta), ((int) yDelta), 200, 50);

        frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
    }

    private void updateRectangle() {
        xDelta += xDir;
        if (xDelta > getWidth() || xDelta < 0) {
            xDir *= -1;
            color = randomColor();
        }

        yDelta += yDir;
        if (yDelta > getHeight() || yDelta < 0) {
            yDir *= -1;
            color = randomColor();
        }

    }

    private Color randomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }
}
