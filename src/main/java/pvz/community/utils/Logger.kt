package pvz.community.utils

object Logger {

    enum class LogType(val color: Colors) {
        INFO(Colors.GREEN),
        WARN(Colors.YELLOW),
        ERROR(Colors.RED)
    }

    private fun log(type: LogType, message: String) {
        println("${"[$type]:".color(type.color,Colors.BOLD)} $message")
    }

    fun info(message: String) = log(LogType.INFO, message)
    fun warn(message: String) = log(LogType.WARN, message)
    fun error(message: String) = log(LogType.ERROR, message)

}