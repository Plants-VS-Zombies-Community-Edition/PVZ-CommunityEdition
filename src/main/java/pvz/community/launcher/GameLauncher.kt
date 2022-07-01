package pvz.community.launcher

import pvz.community.PlantsVSZombies
import pvz.community.utils.Logger.info

object GameLauncher {

    const val VERSION = "1.0.0"
    const val TITLE = "Plants VS Zombies $VERSION"
    private fun getProp(of: String) = System.getProperty(of).lowercase()

    val OS = getProp("os.name")
    val OS_ARCH = getProp("os.arch")
    val OS_VERSION = getProp("os.version")
    val JAVA_VERSION = getProp("java.version")
    val JAVA_VENDOR = getProp("java.vendor")


}

fun main() {
    info(
        """Launching Plants VS Zombies...
            OS: ${GameLauncher.OS}
            OS Arch: ${GameLauncher.OS_ARCH}
            OS Version: ${GameLauncher.OS_VERSION}
            Java Version: ${GameLauncher.JAVA_VERSION}
            Java Vendor: ${GameLauncher.JAVA_VENDOR}
    """.trimMargin()
    )
    // TODO- FIX THIS
    val settings = LauncherSettings()
    val game = PlantsVSZombies(settings)
}