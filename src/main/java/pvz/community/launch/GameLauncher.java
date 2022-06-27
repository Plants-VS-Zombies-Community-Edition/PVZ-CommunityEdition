package pvz.community.launch;

import pvz.community.PlantsVSZombies;
import pvz.community.logger.GlobalConsole;

public class GameLauncher {

    public static final String VERSION = "1.0.0";
    public static final String TITLE = "Plants VS Zombies " + VERSION;

    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final String OS_ARCH = System.getProperty("os.arch").toLowerCase();
    public static final String OS_VERSION = System.getProperty("os.version").toLowerCase();
    public static final String JAVA_VERSION = System.getProperty("java.version").toLowerCase();
    public static final String JAVA_VENDOR = System.getProperty("java.vendor").toLowerCase();

    public static void main(String[] args) {

        boolean debugMode = false;
        boolean fullscreen = false;
        boolean firstLaunch = true;

        GlobalConsole.getLogger().info("Launching Plants VS Zombies...");
        GlobalConsole.getLogger().info("OS: " + OS);
        GlobalConsole.getLogger().info("OS Arch: " + OS_ARCH);
        GlobalConsole.getLogger().info("OS Version: " + OS_VERSION);
        GlobalConsole.getLogger().info("Java Version: " + JAVA_VERSION);
        GlobalConsole.getLogger().info("Java Vendor: " + JAVA_VENDOR);

        LauncherSettings settings = new LauncherSettings(false, true);
        PlantsVSZombies gameInstance = new PlantsVSZombies(settings);
    }


}
