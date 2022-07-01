package pvz.community.utils

import kotlin.random.Random

fun Any?.print() = println(this)


/**
 * Guarantees a number above 0
 */
fun Int?.nBZ() = if ((this ?: 0) < 0) 0 else this?:0
fun Double?.nBZ() = if ((this ?: 0.0) < 0.0) 0.0 else this?:0.0

fun Int.nB(value: Int) = if (this < value) value else this
fun Double.nB(value: Double) = if (this < value) value else this


fun Any?.printAsString() = println(this.toString())
fun Any?.printAsString(prefix: String) = println("$prefix${this.toString()}")
var c = 0
fun Any?.pq() = this.pq(null)
fun Any?.pqr() = pq(Random.nextInt(0, 100))
fun Any?.pq(number: Int) = this.pq("$number")
fun Any?.pq(prefix: String?) {

    val p = (prefix ?: "PRINTED").apply { replace(this[0], this[0].uppercaseChar()) }
    if (this == null) {
        println("[$p] null".color(Colors.RED))
        return
    }
    when (c) {
        0 -> println("[$p] $this".color(Colors.RED))
        1 -> println("[$p] $this".color(Colors.BLUE))
        2 -> println("[$p] $this".color(Colors.GREEN))
        3 -> println("[$p] $this".color(Colors.PURPLE))
        4 -> println("[$p] $this".color(Colors.CYAN))
        5 -> println("[$p] $this".color(Colors.YELLOW))
        else -> println("[$p] $this".color(Colors.CYAN))
    }

    c++
    if (c > 5)
        c = 0
}