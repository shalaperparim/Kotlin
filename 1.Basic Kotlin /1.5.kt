/*
- Problem
You want to perform bitwise shift operations.

- Solution
Kotlin includes bitwise infix functions like shr, shl, and ushr for this
purpose.
*/

//----------------------------------------------------
//Kotlin defines the following shift operators as extension functions on Int and Long:
    shl
        Signed left shift
    shr
        Signed right shift
    ushr
        Unsigned right shift
//----------------------------------------------------


//----------------------------------------------------
//Example 1.5-1. Multiplying and dividing by 2
@Test
fun `doubling and halving`() {
    assertAll("left shifts doubling from 1", // 0000_0001
        { assertThat( 2, equalTo(1 shl 1)) },    // 0000_0010
        { assertThat( 4, equalTo(1 shl 2)) },    // 0000_0100
        { assertThat( 8, equalTo(1 shl 3)) },    // 0000_1000
        { assertThat( 16, equalTo(1 shl 4)) },   // 0001_0000
        { assertThat( 32, equalTo(1 shl 5)) },   // 0010_0000
        { assertThat( 64, equalTo(1 shl 6)) },   // 0100_0000
        { assertThat(128, equalTo(1 shl 7)) }    // 1000_0000
assertAll("right shifts halving from 235", // 1110_1011
    { assertThat(117, equalTo(235 shr 1)) }, // 0111_0101
    { assertThat( 58, equalTo(235 shr 2)) }, // 0011_1010
    { assertThat( 29, equalTo(235 shr 3)) }, // 0001_1101
    { assertThat( 14, equalTo(235 shr 4)) }, // 0000_1110
    { assertThat( 7, equalTo(235 shr 5)) }, // 0000_0111
    { assertThat( 3, equalTo(235 shr 6)) }, // 0000_0011
    { assertThat( 1, equalTo(235 shr 7)) } // 0000_0001
}

// The ushr function is needed when you want to shift a value and not
// preserve its sign. Both shr and ushr behave the same for positive values.
// But for negative values, shr fills in from the left with 1s so that the
// resulting value is still negative, as shown in Example 1.5-2.
//----------------------------------------------------


//----------------------------------------------------
// Example 1.5-2. Using the ushr function versus shr
val n1 = 5
val n2 = -5
println(n1.toString(2)) // 0b0101
println(n2.toString(2)) // -0b0101

assertThat(n1 shr 1, equalTo(0b0010)) // 2
assertThat(n1 ushr 1, equalTo(0b0010)) // 2

assertThat(n2 shr 1, equalTo(-0b0011)) // -3

assertThat(n2 ushr 1, equalTo(0x7fff_fffd)) // 2_147_483_645
//----------------------------------------------------


//----------------------------------------------------
// Example 1.5-3. Finding the midpoint of two large integers
val high = (0.99 * Int.MAX_VALUE).toInt()
val low = (0.75 * Int.MAX_VALUE).toInt()
val mid1 = (high + low) / 2  // --> Sum is greater than max Int, so result is negative
val mid2 = (high + low) ushr 1 // --> Unsigned shift ensures result inside desired range
assertTrue(mid1 !in low..high)
assertTrue(mid2 in low..high)
//----------------------------------------------------



