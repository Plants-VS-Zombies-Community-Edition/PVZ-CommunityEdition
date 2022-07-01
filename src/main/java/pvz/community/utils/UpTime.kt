package pvz.community.utils

class UpTime {

    val start = System.currentTimeMillis()
    val startNano = System.nanoTime()

    enum class Format(val ms: Int) {
        MILLISECOND(1),
        SECOND(1000),
        MINUTE(60000),
        HOUR(3600000),
        DAY(86400000),
        WEEK(604800000),
    }
    enum class FormatDelta(val deltaTime: Double) {
        SECOND(1E-9),
        MINUTE(1E-6),
        HOUR(1E-3),
        DAY(1E-0),
        WEEK(1E3),
    }

    data class Time(
        var weeks: Long = 0,
        var days: Long = 0,
        var hours: Long = 0,
        var minutes: Long = 0,
        var seconds: Long = 0,
        var milliseconds: Long = 0
    )

    fun getTime(format: Format): Long = (System.currentTimeMillis()- start ) / format.ms
    fun getTimeNano(format: FormatDelta): Float = ((System.nanoTime() - startNano ) * format.deltaTime).toFloat()
    fun getUpTime(): Time {
        var currentMs = System.currentTimeMillis() - start
        return Time().apply {
            weeks = currentMs / Format.WEEK.ms
            currentMs -= weeks * Format.WEEK.ms
            days = currentMs / Format.DAY.ms
            currentMs -= days * Format.DAY.ms
            hours = currentMs / Format.HOUR.ms
            currentMs -= hours * Format.HOUR.ms
            minutes = currentMs / Format.MINUTE.ms
            currentMs -= minutes * Format.MINUTE.ms
            seconds = currentMs / Format.SECOND.ms
            currentMs -= seconds * Format.SECOND.ms
            milliseconds = currentMs
        }
    }
}