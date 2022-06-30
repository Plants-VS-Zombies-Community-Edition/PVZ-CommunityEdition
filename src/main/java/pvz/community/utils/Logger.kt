package pvz.community.utils

import pvz.community.launcher.GameLauncher

object Logger {
    private val os = GameLauncher.OS.contains("windows")

    enum class LogType(val id: String, val color: Colors) {
        INFO("info", Colors.GREEN),
        WARN("warning", Colors.YELLOW),
        ERROR("error", Colors.RED)
    }

    fun log(type: LogType, message: String) {
        println("${"[$type]:".color(type.color,Colors.BOLD)} $message}")
    }

    fun info(message: String) = log(LogType.INFO, message)
    fun warn(message: String) = log(LogType.WARN, message)

    fun error(message: String) = log(LogType.ERROR, message)

}