package pvz.community.logger.types

import pvz.community.logger.Logger

class WindowsLogger : Logger {

    override fun info(message: String?) {
        println(ANSI_DARK_GREEN + ANSI_BOLD + "INFO: " + ANSI_RESET + message)
    }

    override fun warning(message: String?) {
        println(ANSI_DARK_YELLOW + ANSI_BOLD + "WARNING: " + ANSI_RESET + message)
    }

    override fun error(message: String?) {
        println(ANSI_DARK_RED + ANSI_BOLD + "ERROR: " + ANSI_RESET + message)
    }
    companion object {
        const val ANSI_RESET = "\u001B[0m"
        const val ANSI_REVERSE = "\u001B[7m"
        const val ANSI_UNDERLINE = "\u001B[4m"
        const val ANSI_BOLD = "\u001B[1m"
        const val ANSI_WHITE = "\u001B[97m"
        const val ANSI_WHITE_BG = "\u001B[107m"
        const val ANSI_BRIGHT_CYAN = "\u001B[96m"
        const val ANSI_BRIGHT_CYAN_BG = "\u001B[106m"
        const val ANSI_BRIGHT_PURPLE = "\u001B[95m"
        const val ANSI_BRIGHT_PURPLE_BG = "\u001B[105m"
        const val ANSI_BRIGHT_BLUE = "\u001B[94m"
        const val ANSI_BRIGHT_BLUE_BG = "\u001B[104m"
        const val ANSI_BRIGHT_GREEN = "\u001B[92m"
        const val ANSI_BRIGHT_GREEN_BG = "\u001B[102m"
        const val ANSI_BRIGHT_YELLOW = "\u001B[93m"
        const val ANSI_BRIGHT_YELLOW_BG = "\u001B[103m"
        const val ANSI_BRIGHT_RED = "\u001B[91m"
        const val ANSI_BRIGHT_RED_BG = "\u001B[101m"
        const val ANSI_GRAY = "\u001B[90m"
        const val ANSI_GRAY_BG = "\u001B[100m"
        const val ANSI_LIGHT_GRAY = "\u001B[37m"
        const val ANSI_LIGHT_GRAY_BG = "\u001B[47m"
        const val ANSI_DARK_CYAN = "\u001B[36m"
        const val ANSI_DARK_CYAN_BG = "\u001B[46m"
        const val ANSI_DARK_PURPLE = "\u001B[35m"
        const val ANSI_DARK_PURPLE_BG = "\u001B[45m"
        const val ANSI_DARK_BLUE = "\u001B[34m"
        const val ANSI_DARK_BLUE_BG = "\u001B[44m"
        const val ANSI_DARK_GREEN = "\u001B[32m"
        const val ANSI_DARK_GREEN_BG = "\u001B[42m"
        const val ANSI_DARK_RED = "\u001B[31m"
        const val ANSI_DARK_RED_BG = "\u001B[41m"
        const val ANSI_DARK_YELLOW = "\u001B[33m"
        const val ANSI_DARK_YELLOW_BG = "\u001B[43m"

    }
}