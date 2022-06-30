package pvz.community.launcher;

import pvz.community.utils.Logger;
import pvz.community.PlantsVSZombies;

public class GameLauncher {

    public static final String VERSION = "1.0.0";
    public static final String TITLE = "Plants VS Zombies " + VERSION;

    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final String OS_ARCH = System.getProperty("os.arch").toLowerCase();
    public static final String OS_VERSION = System.getProperty("os.version").toLowerCase();
    public static final String JAVA_VERSION = System.getProperty("java.version").toLowerCase();
    public static final String JAVA_VENDOR = System.getProperty("java.vendor").toLowerCase();

    public static void main(String[] args) {

        Logger.Companion.info("Launching Plants VS Zombies...");
        Logger.Companion.info("OS: " + OS);
        Logger.Companion.info("OS Arch: " + OS_ARCH);
        Logger.Companion.info("OS Version: " + OS_VERSION);
        Logger.Companion.info("Java Version: " + JAVA_VERSION);
        Logger.Companion.info("Java Vendor: " + JAVA_VENDOR);

        // TODO- FIX THIS
        final LauncherSettings settings = new LauncherSettings(false, true);
        PlantsVSZombies game = new PlantsVSZombies(settings);
    }


}
