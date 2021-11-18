fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = when(rooms)  {
        in -100..1 -> Cabin(price)
        in 2..3 -> Bungalow(price)
        4 -> Cottage(price)
        in 5..7 -> Mansion(price)
        else -> Palace(price)
    }
    println(totalPrice(house))
}

fun totalPrice(house: House) = house.price().toInt()

open class House(private val price: Int, private val coefficient: Double) {
    fun price(): Double {
        val p = if (price <= 0) 0 else if (price >= 1_000_000) 1_000_000 else price
        return p * coefficient
    }
}

class Cabin(price: Int): House(price, 1.00)
class Bungalow(price: Int): House(price, 1.20)
class Cottage(price: Int): House(price, 1.25)
class Mansion(price: Int): House(price, 1.40)
class Palace(price: Int): House(price, 1.60)