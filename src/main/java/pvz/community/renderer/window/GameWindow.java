package pvz.community.renderer.window;

import pvz.community.launch.GameLauncher;

import javax.swing.*;

public class GameWindow extends JFrame{

    public final int HEIGHT = 600;
    public final int WIDTH = 800;

    public GameWindow(){
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle(GameLauncher.TITLE);
        setVisible(true);

    }

}
