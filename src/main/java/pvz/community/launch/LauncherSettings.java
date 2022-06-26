package pvz.community.launch;

public class LauncherSettings {

    public final boolean DEBUG_MODE;
    public final boolean FIRST_LAUNCH;
    public boolean FULLSCREEN;


    public LauncherSettings(boolean debugMode, boolean firstLaunch) {
        this.DEBUG_MODE = debugMode;
        this.FIRST_LAUNCH = firstLaunch;
    }

    public LauncherSettings setFullscreen(boolean fullscreen) {
        this.FULLSCREEN = fullscreen;
        return this;
    }






}
