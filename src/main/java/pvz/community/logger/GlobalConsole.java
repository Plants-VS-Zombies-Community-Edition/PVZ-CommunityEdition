package pvz.community.logger;

import lombok.Getter;
import pvz.community.logger.types.LinuxLogger;
import pvz.community.logger.types.WindowsLogger;

public class GlobalConsole {

    @Getter private static final Logger logger = (System.getProperty("os.name").toLowerCase().contains("windows")) ? new WindowsLogger() : new LinuxLogger();




}
