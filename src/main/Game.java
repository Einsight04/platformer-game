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
        int TARGET_FPS = 144;
        double TARGET_TIME_PER_FRAME = 1_000_000_000.0 / TARGET_FPS;

        int frames = 0;
        long currentTime;
        long lastFrame = System.nanoTime();
        long lastCheck = System.currentTimeMillis();

        while (true) {
            currentTime = System.nanoTime();
            if (currentTime - lastFrame >= TARGET_TIME_PER_FRAME) {
                gamePanel.repaint();
                lastFrame = currentTime;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }

        }
    }
}
