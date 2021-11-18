fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toDouble()
    val product = when {
        productType =="headphones" -> HeadPhones(1.11, price)
        productType == "smartphone" -> SmartPhone(1.15, price)
        productType == "tv" -> Tv(1.17, price)
        productType == "laptop" -> Laptop(1.19, price)
        else -> Product(0.00,0.00)
    }
    println(totalPrice(product).toInt())
}

fun totalPrice(product: Product) = product.finalprice()

open class Product(val tax:Double, val price: Double){
    fun finalprice(): Double{
        return price * tax
    }
}

class HeadPhones(tax: Double, price: Double): Product(tax, price)

class SmartPhone(tax: Double, price: Double): Product(tax, price)

class Tv(tax: Double, price: Double): Product(tax, price)

class Laptop(tax: Double, price: Double): Product(tax, price)
