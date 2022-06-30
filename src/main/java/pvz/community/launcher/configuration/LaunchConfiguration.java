package pvz.community.launcher.configuration;

import pvz.community.utils.Logger;

import java.io.File;
import java.io.IOException;

public class LaunchConfiguration {

    public File configFolder = new File("pvz-community");
    public File launchConfigurationJSON = new File(configFolder, "launch.json");

    public Configuration launchConfig = Configuration.newConfiguration(launchConfigurationJSON);

    public void saveLaunchConfiguration() throws IOException {
        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }
        Logger.Companion.info("Saving launch configuration...");


    }

}
