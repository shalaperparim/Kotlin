/*
- Problem
You want to ensure that a variable is never null.

- Solution
Define the type of a variable without a question mark. Nullable types also
combine with the safe call operator (?.) and the Elvis operator (?:)
*/

//----------------------------------------------------
// Example 1-1. Declaring a non-nullable variable
var name: String
name = "Perparim" // Assignment to a non-null string
name = null    // Assignment to null does not compile
//----------------------------------------------------


//----------------------------------------------------
// Example 1-2. Declaring a nullable variable
class Person(val first: String, val middle: String?, val last: String)
val pShala = Person("Perparim", null, "Shala") // In the Person class, we still have to supply a value for the middle parameter, even if it’s null
//----------------------------------------------------


//----------------------------------------------------
// Example 1-3. Checking nullability of a [val] variable
val p = Person(first = "North", middle = null, last = "West")
if (p.middle != null) {
    val middleNameLength = p.middle.length // Smart cast to non-null String
}
//----------------------------------------------------


//----------------------------------------------------
// Example 1-4. Asserting that a var variable is not null
var p = Person(first = "North", middle = null, last = "West")
if (p.middle != null) {
    // val middleNameLength = p.middle.length --> Smart cast to String impossible, because p.middle is a complex expression
    val middleNameLength = p.middle!!.length // --> Null-asserted (please don’t do this unless absolutely necessary)
}
// The !! operator forces the variable to be treated as non-null and throws an exception if that is not correct. 
// That’s one of the few ways it is still possible to get a NullPointerException even in Kotlin code, so try to
// avoid it if possible.
//----------------------------------------------------


//----------------------------------------------------
// Example 1-5. Using the safe call operator
var p = Person(first = "North", middle = null, last = "West")
val middleNameLength = p.middle?.length // --> Safe call; the resulting type is Int?
// Therefore, it is helpful to combine the safe call operator with the Elvis
// operator (?:), as in Example 1-6.
//----------------------------------------------------


//----------------------------------------------------
// Example 1-6. Safe call with Elvis
var p = Person(first = "North", middle = null, last = "West")
val middleNameLength = p.middle?.length ?: 0 // --> Elvis operator, returns 0 if middle is null
//----------------------------------------------------



