package pvz.community.renderer.window;

import pvz.community.utils.Logger;
import pvz.community.PlantsVSZombies;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {

    final int WIDTH = 800;
    final int HEIGHT = 600;

    final int SPRITE_SIZE = 16; // 16x16
    final int SPRITE_SCALE = 3;

    final int TILE_SIZE = SPRITE_SIZE * SPRITE_SCALE;

    private Thread gameThread;

    private final int FPS = PlantsVSZombies.getInstance().getSettings().getMAX_FPS();

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

    }


    public void initializeGameThread() {
        Logger.INSTANCE.info("Initializing game thread...");
        gameThread = new Thread(this);
        gameThread.start();
        Logger.INSTANCE.info("Game thread initialized.");
    }

    // Delta/Accumulator game loop
    @Override
    public void run() {


        final double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int drawCount = 0;
        long timer = 0;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;


            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;


        BufferedImage image = PlantsVSZombies.getInstance().getRenderer().getBufferedImageLoader().loadImage("test.png");

        graphics2D.drawImage(image, 100, 100, null);


        graphics2D.dispose(); // Stays in the bottom :d
    }

    private void update() {

    }

}
