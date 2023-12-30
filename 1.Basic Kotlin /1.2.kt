/*
- Problem
Kotlin does not automatically promote primitive types to wider variables,
such as an [Int] to a [Long].

- Solution
Use the explicit conversion functions [toInt, toLong], and so on to convert
the smaller type explicitly.
*/

//----------------------------------------------------
//Example 2-1. Converting from an Integer to a Long
Integer myInteger = 3;
// Long myWrappedLong = myInteger; // --> Does not compile
Long myWrappedLong = myInteger.longValue(); // --> Extracts a long, then wraps it
myWrappedLong = Long.valueOf(myInteger); // --> Unwraps int, promotes to long, then wraps it
//----------------------------------------------------


//----------------------------------------------------
// Example 2-2. Promoting an Int to a Long in Kotlin
val intVar: Int = 3
// val longVar: Long = intVar // --> Does not compile
val longVar: Long = intVar.toLong() // --> Explicit type conversion
//----------------------------------------------------


//----------------------------------------------------
// The available conversion methods are as follows:

    toByte: Byte
    toChar: Char
    toShort: Short
    toInt(): Int
    toLong(): Long
    toFloat(): Float
    toDouble(): Double

// Fortunately, Kotlin does take advantage of operator overloading to perform
// type conversions transparently, so the following code does not require an
// explicit conversion:

    val longSum = 3L + intVar

// The plus operator automatically converts the intVar value to a long and
// adds it to the long literal.
//----------------------------------------------------



