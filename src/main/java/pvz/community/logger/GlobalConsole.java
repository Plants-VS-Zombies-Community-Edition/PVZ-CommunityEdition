package pvz.community.logger;

import lombok.Getter;
import pvz.community.launcher.GameLauncher;
import pvz.community.logger.types.LinuxLogger;
import pvz.community.logger.types.WindowsLogger;

public class GlobalConsole {

    @Getter private static final Logger logger = (GameLauncher.OS.contains("windows")) ? new WindowsLogger() : new LinuxLogger();




}
