fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Valid age range
    if (age in 1..100){
        return if(age <= 12) {15}
        else if(isMonday && age in 13..60) {25}
        else if(age in 13..60) {30}
        else {20}
    }
    // Catch all invalid ages
    return -1
}