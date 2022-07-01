package pvz.community;

import lombok.Getter;
import pvz.community.launcher.LauncherSettings;
import pvz.community.renderer.WindowObjectRenderer;
import pvz.community.renderer.window.Window;
import pvz.community.utils.UpTime;

public class PlantsVSZombies {

    @Getter
    private static PlantsVSZombies instance = null;
    @Getter
    private final LauncherSettings settings;
    @Getter
    private final Window window;
    @Getter
    private final UpTime systemUtils;
    @Getter
    private final WindowObjectRenderer renderer;

    public PlantsVSZombies(LauncherSettings settings) {
        instance = this;
        this.settings = settings;
        this.systemUtils = new UpTime();
        this.window = Window.get();
        window.run();
        this.renderer = new WindowObjectRenderer();
    }
}
