// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val input = Array(4) { readLine()!!.toInt() }
    val firstBox = Box(input[0], input[1], input.last())
    val secondBox = firstBox.copy(length = input[2])
    println(firstBox)
    println(secondBox)
}
