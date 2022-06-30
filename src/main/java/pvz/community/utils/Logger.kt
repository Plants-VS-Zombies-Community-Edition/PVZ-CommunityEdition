package pvz.community.utils

import pvz.community.launcher.GameLauncher

enum class Logger(val windows: String) {
    RESET("\u001B[0m"),
    REVERSE("\u001B[7m"),
    UNDERLINE("\u001B[4m"),
    BOLD("\u001B[1m"),
    WHITE("\u001B[97m"),
    WHITE_BG("\u001B[107m"),
    BRIGHT_CYAN("\u001B[96m"),
    BRIGHT_CYAN_BG("\u001B[106m"),
    BRIGHT_PURPLE("\u001B[95m"),
    BRIGHT_PURPLE_BG("\u001B[105m"),
    BRIGHT_BLUE("\u001B[94m"),
    BRIGHT_BLUE_BG("\u001B[104m"),
    BRIGHT_GREEN("\u001B[92m"),
    BRIGHT_GREEN_BG("\u001B[102m"),
    BRIGHT_YELLOW("\u001B[93m"),
    BRIGHT_YELLOW_BG("\u001B[103m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_RED_BG("\u001B[101m"),
    GRAY("\u001B[90m"),
    GRAY_BG("\u001B[100m"),
    LIGHT_GRAY("\u001B[37m"),
    LIGHT_GRAY_BG("\u001B[47m"),
    DARK_CYAN("\u001B[36m"),
    DARK_CYAN_BG("\u001B[46m"),
    DARK_PURPLE("\u001B[35m"),
    DARK_PURPLE_BG("\u001B[45m"),
    DARK_BLUE("\u001B[34m"),
    DARK_BLUE_BG("\u001B[44m"),
    DARK_GREEN("\u001B[32m"),
    DARK_GREEN_BG("\u001B[42m"),
    DARK_RED("\u001B[31m"),
    DARK_RED_BG("\u001B[41m"),
    DARK_YELLOW("\u001B[33m"),
    DARK_YELLOW_BG("\u001B[43m");


    enum class LogType(val id: String,val  color: Logger) {
        INFO("info", DARK_GREEN),
        WARN("warning", DARK_YELLOW),
        ERROR("error", DARK_RED)
    }

    companion object{
        private val os = GameLauncher.OS.contains("windows")

        fun log(type: LogType, message: String) {
            println("[$type$BOLD${type.id}]: $message$RESET")
        }
        fun info(message: String) = log(LogType.INFO, message)
        fun warn(message: String) = log(LogType.WARN, message)

        fun error(message: String) = log(LogType.ERROR, message)
    }
}