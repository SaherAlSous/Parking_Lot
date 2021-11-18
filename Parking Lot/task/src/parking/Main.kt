package parking

private lateinit var Park: MutableList<MutableList<String>>

fun main() {
    do {
        val command = readLine()!!.split(" ")
        when{
            command[0] == "create" -> createPark(command)
            command[0] == "park" -> parkCar(command)
            command[0] == "leave" -> leavePark(command)
            command[0] == "status" -> status()
            command[0] == "reg_by_color" -> regByColor(command)
            command[0] == "spot_by_color" -> spotByColor(command)
            command[0] == "spot_by_reg" -> spotByReg(command)
        }
    } while (command[0] != "exit")
}

fun spotByReg(command: List<String>) {
    if (::Park.isInitialized){
        for (i in 0 until Park.size){
            if (Park[i][0].lowercase() == command.last().lowercase()){
                println(i + 1)
                return
            }
        }
        println("No cars with registration number ${command.last()} were found.")
    } else {
        println("Sorry, a parking lot has not been created.")
        return
    }

}

fun spotByColor(command: List<String>) {
    if (::Park.isInitialized){
        val list = mutableListOf<Int>()
        for (i in 0 until Park.size){
            if (Park[i][1].lowercase() == command.last().lowercase()){
                list.add(i + 1)
            }
        }
        if (list.size == 0) println("No cars with color ${command.last()} were found.") else println(list.joinToString(", "))
    } else {
        println("Sorry, a parking lot has not been created.")
        return
    }
}

fun regByColor(command: List<String>) {
    if (::Park.isInitialized){
        val list = mutableListOf<String>()
        for (i in 0 until Park.size){
            if (Park[i][1].lowercase() == command.last().lowercase()){
                list.add(Park[i][0])
            }
        }
        if (list.size == 0) println("No cars with color ${command.last()} were found.") else println(list.joinToString(", "))

    } else {
        println("Sorry, a parking lot has not been created.")
        return
    }
}

fun status() {
   if (::Park.isInitialized) {
       var empty = true
       for (i in 0 until Park.size){
           if (Park[i][0] != "empty"){
               println("${i + 1} ${Park[i][0]} ${Park[i][1]}")
               empty = false
           }
       }
       if (empty) println("Parking lot is empty.")
       return
   } else {
       println("Sorry, a parking lot has not been created.")
       return
   }
}

fun leavePark(command: List<String>) {
    if (::Park.isInitialized) {
        println("Spot ${command.last()} is free.")
        Park[command.last().toInt() - 1] = mutableListOf("empty", "empty")
        return
    } else {
        println("Sorry, a parking lot has not been created.")
        return
    }
}

fun parkCar(command: List<String>) {
    if (::Park.isInitialized) {
        for (i in 0 until Park.size){
            if (Park[i][0] == "empty"){
                println("${command.last()} car parked in spot ${i + 1}.")
                Park[i] = mutableListOf(command[1], command.last())
                return
            }
        }
        println("Sorry, the parking lot is full.")
        return
    } else {
        println("Sorry, a parking lot has not been created.")
        return
    }
}

fun createPark(command: List<String>) {
    Park = MutableList(command.last().toInt()) { MutableList(2) {"empty"} }
    println("Created a parking lot with ${command.last()} spots.")
}