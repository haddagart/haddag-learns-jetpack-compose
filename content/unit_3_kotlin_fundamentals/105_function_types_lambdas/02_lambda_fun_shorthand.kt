fun main() {
    // Ommiting the parameter using `it`
    val coins: (Int) -> String = {"Here $it quarters"}
    val cupcake: (Int) -> String = {"Have a cupcake!"}
    
    /*
        A lambda function is like any literal like 0, "hello"
        You can pass it directly as a param
    */
    val literallLambda = trickOrTreat(false, {"Here $it quarters"}) // trick
    literallLambda()

    /*
        If the last parameters of a function is a function
        you can pass it in the tailing format i.e as funName(params) {lambda expression}
    */
    val tailingLambda = trickOrTreat(false) {"Here $it apples"}
    tailingLambda()
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