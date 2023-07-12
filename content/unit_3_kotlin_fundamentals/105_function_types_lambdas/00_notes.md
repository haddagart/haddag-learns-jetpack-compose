> The composable functions that you used to declare your UI take functions as parameters and are typically called using trailing lambda syntax.

> When a function returns a function or takes a function as an argument, it's called a higher-order function.

repeat is consice way to use functions with a for

```kotlin
// for loop
for(iteration in start..end) {
    // code
}

// repeat function
repeat(times) { iteration ->
    // code
}

```


### Summary
- Functions in Kotlin are first-class constructs and can be treated like data types.
- Lambda expressions provide a shorthand syntax to write functions.
- You can pass function types into other functions.
- You can return a function type from another function.
- A lambda expression returns the value of the last expression.
- If a parameter label is omitted in a lambda expression with a single parameter, it's referred to with the it identifier.
- Lambdas can be written inline without a variable name.
- If a function's last parameter is a function type, you can use trailing lambda syntax to move the lambda expression after the last parenthesis when you call a function.
- Higher-order functions are functions that take other functions as parameters or return a function.
- The repeat() function is a higher-order function that works similarly to a for loop.