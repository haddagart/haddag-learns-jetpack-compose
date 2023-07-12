fun main() {
    // Assigning a normal function to a variable
    // val trickFunction = ::trick
    // trickFunction()
    
    // Assigning a lambda function to a variable
    // val trickFunction = trick
    // trickFunction()
    
    // Let's define the lambda function
    // you can't use return here
    val coins: (Int) -> String = {
        // params -> body like is JS somehow
        quantity -> "Here $quantity quarters"
    }
    
    val cupcake: (Int) -> String = {
        // We can omit the params if we don't need them
        "Have a cupcake!"
    }
    
    // Returning a function as a variable
    val trickFunction = trickOrTreat(true, coins) // trick
    val treatFunction = trickOrTreat(false, cupcake) // treat
    trickFunction()
    treatFunction()
    
    
}

// Trick defined as a lamda function
val trick = {
    println("No treats!")
}

// Bind a function signature to a data type
val treat : () -> Unit = {
    println("Have a treat!")
}

/* 	Use a function as a return type:
	Set the output signature to 
	() -> Unit i.e. function
*/

/* In this version:
 * 	- The function takes two parameters
 * 	- First parameter is a Boolean
 * 	- Second parameter is a function with signature:
 * 		(Int) -> String
 * 	- Output is a function:
 * 		() -> Unit
 * 	- Then comes the body of the function
 */

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