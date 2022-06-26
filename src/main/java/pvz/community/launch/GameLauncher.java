package pvz.community.launch;

import pvz.community.PlantsVSZombies;

public class GameLauncher {

    public static void main(String[] args) {

        boolean debugMode = false;
        boolean fullscreen = false;
        boolean firstLaunch = true;



        PlantsVSZombies gameInstance = new PlantsVSZombies(new LauncherSettings(debugMode, firstLaunch).setFullscreen(fullscreen));
    }


}
