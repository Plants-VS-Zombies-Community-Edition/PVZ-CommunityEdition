package pvz.community.launcher.configuration

import pvz.community.launcher.configuration.Configuration.Companion.newConfiguration
import pvz.community.utils.Logger.info
import java.io.File
import java.io.IOException

class LaunchConfiguration {
    var configFolder = File("pvz-community")
    var launchConfigurationJSON = File(configFolder, "launch.json")
    var launchConfig = newConfiguration(launchConfigurationJSON)

    @Throws(IOException::class)
    fun saveLaunchConfiguration() {
        if (!configFolder.exists()) {
            configFolder.mkdirs()
        }
        info("Saving launch configuration...")
    }
}