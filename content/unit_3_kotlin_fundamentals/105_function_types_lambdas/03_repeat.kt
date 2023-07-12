fun main() {
    // Ommiting the parameter using `it`
    val coins: (Int) -> String = {"Here $it quarters"}
    val cupcake: (Int) -> String = {"Have a cupcake!"}
    
    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    
    // Using repeat high-order function
    // 4 is the number of iterations
    repeat(4) {
        // Lambda function core
        treatFunction()
    }
    trickFunction()
}


val trick = {println("No treats!")}
val treat : () -> Unit = {println("Have a treat!")}

fun trickOrTreat(
    isTrick: Boolean, 
    extraTreat: ((Int) -> String)?
    // The (function_signature)? make it nullable
): () -> Unit {
    if(isTrick) {
        return trick
    } else {
        // Here the param function is used
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        // The definition of extraTreat must be a lambda function
        return treat
    }
}