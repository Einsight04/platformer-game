package main;

public class Game implements Runnable {
    private final GamePanel gamePanel;
    private final GameWindow gameWindow;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        startGameLoop();
    }

    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        int FPS = 144;

        double timePerFrame = 1_000_000_000.0 / FPS;
        long lastFrame = System.nanoTime();
        long currentTime;

        while (true) {
            currentTime = System.nanoTime();
            if (currentTime - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = currentTime;
            }
        }
    }
}
