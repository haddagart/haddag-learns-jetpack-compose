fun main() {
    //27.0 degrees Celsius is 80.60 degrees Fahrenheit.
    printFinalTemperature(
        27.0,
        "Celsius",
        "Fahrenheit",
    ) {it * 9 / 5 + 32}

    //350.0 degrees Kelvin is 76.85 degrees Celsius.
    printFinalTemperature(
        350.0,
        "Kelvin",
        "Celsius",
    ) {it - 273.15}

    //10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
    printFinalTemperature(
        10.0,
        "Fahrenheit",
        "Kelvin",
    ) {(it - 32) * 5 / 9 + 273.15}
}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}