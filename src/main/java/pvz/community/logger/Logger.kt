package pvz.community.logger

interface Logger {
    fun info(message: String?)
    fun warning(message: String?)
    fun error(message: String?)
}