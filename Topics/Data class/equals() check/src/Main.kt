data class Client(val name: String, val age: Int){
    val balance: Int = 0
}
const val SIZE = 3
fun main() {
    val fir = Array(SIZE) { readLine()!! }
    val sec = Array(SIZE) { readLine()!! }
    val first = Client(fir[0], fir[1].toInt())
    val second = Client(sec[0], sec[1].toInt())
    println(first == second)
}
