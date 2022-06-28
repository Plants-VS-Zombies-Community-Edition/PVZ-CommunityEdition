package pvz.community.renderer.window;

import lombok.Getter;
import pvz.community.launcher.GameLauncher;

import javax.swing.*;

public class GameWindow extends JFrame{

    @Getter private final GamePanel gamePanel = new GamePanel();

    public GameWindow(){
        setTitle(GameLauncher.TITLE);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(gamePanel);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        gamePanel.initializeGameThread();
    }




}
