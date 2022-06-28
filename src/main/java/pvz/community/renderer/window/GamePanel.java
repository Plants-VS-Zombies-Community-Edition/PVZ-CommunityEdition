package pvz.community.renderer.window;

import pvz.community.PlantsVSZombies;
import pvz.community.logger.GlobalConsole;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int WIDTH = 800;
    final int HEIGHT = 600;

    final int SPRITE_SIZE = 16; // 16x16
    final int SPRITE_SCALE = 3;

    final int TILE_SIZE = SPRITE_SIZE * SPRITE_SCALE;

    private Thread gameThread;

    private int FPS = PlantsVSZombies.Companion.getInstance().getGame().getSettings().getMAX_FPS();

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

    }


    public void initializeGameThread() {
        GlobalConsole.getLogger().info("Initializing game thread...");
        gameThread = new Thread(this);
        gameThread.start();
        GlobalConsole.getLogger().info("Game thread initialized.");
    }

    // Delta/Accumulator game loop
    @Override
    public void run() {


        final double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.RED);
        graphics2D.drawString("FPS: " + FPS, 100, 100);

        graphics2D.dispose(); // Stays in the bottom :d
    }

    private void update() {

    }

}
