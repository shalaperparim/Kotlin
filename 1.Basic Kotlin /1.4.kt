/*
- Problem
You want to raise a number to a power but notice that Kotlin doesn’t have a
predefined exponentiation operator.

- Solution
Define an infix function that delegates to the Kotlin extension function
pow already added to Int and Long.
*/

//----------------------------------------------------
// Example 1.4-1. Defining an infix operation for exponentiation
import kotlin.math.pow

infix fun Int.`**`(x: Int) = toDouble().pow(x).toInt()
infix fun Long.`**`(x: Int) = toDouble().pow(x).toLong()
infix fun Float.`**`(x: Int) = pow(x)
infix fun Double.`**`(x: Int) = pow(x)

// Pattern similar to existing functions on Float and Double
fun Int.pow(x: Int) = `**`(x)
fun Long.pow(x: Int) = `**`(x)

// The infix keyword was used in the definition of the ** function, but not in
// extending pow to Int and Long to keep with the pattern in Float and Double.
//----------------------------------------------------


//----------------------------------------------------
// Example 1.4-2. Using the ** extension function
@Test
fun `raise to power`() {
    assertAll(
        { assertThat(1, equalTo(2 `**` 0)) },
        { assertThat(2, equalTo(2 `**` 1)) },
        { assertThat(4, equalTo(2 `**` 2)) },
        { assertThat(8, equalTo(2 `**` 3)) },
        { assertThat(1L, equalTo(2L `**` 0)) },
        { assertThat(2L, equalTo(2L `**` 1)) },
        { assertThat(4L, equalTo(2L `**` 2)) },
        { assertThat(8L, equalTo(2L `**` 3)) },
        { assertThat(1F, equalTo(2F `**` 0)) },
        { assertThat(2F, equalTo(2F `**` 1)) },
        { assertThat(4F, equalTo(2F `**` 2)) },
        { assertThat(8F, equalTo(2F `**` 3)) },
        { assertThat(1.0, closeTo(2.0 `**` 0, 1e-6)) },
        { assertThat(2.0, closeTo(2.0 `**` 1, 1e-6)) },
        { assertThat(4.0, closeTo(2.0 `**` 2, 1e-6)) },
        { assertThat(8.0, closeTo(2.0 `**` 3, 1e-6)) },
    )
}
// The tests on Double.** use the Hamcrest matcher closeTo to avoid comparing for equality on doubles.
//----------------------------------------------------



