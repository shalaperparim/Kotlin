/*
- Problem
You want to apply masks to bit values.

- Solution
Use the bitwise and, or, xor, and inv operators supplied by Kotlin for that
purpose.
*/

//----------------------------------------------------
// The bitwise operations and, or, and xor are familiar to most developers.
// The only difference between them and their logical counterparts is that they
// do not short-circuit. As a trivial example, see Example 1.6-1.

// Example 1.6-1. Simple example of and, or, and xor

@Test
fun `and, or, xor`() {
    val n1 = 0b0000_1100 // decimal 12
    val n2 = 0b0001_1001 // decimal 25

    val n1_and_n2 = n1 and n2
    val n1_or_n2 = n1 or n2
    val n1_xor_n2 = n1 xor n2

    assertThat(n1_and_n2, equalTo(0b0000_1000)) // 8
    assertThat(n1_or_n2, equalTo(0b0001_1101)) // 29
    assertThat(n1_xor_n2, equalTo(0b0001_0101)) // 21
}
//----------------------------------------------------


//----------------------------------------------------
// Example 2-36. Converting an integer to its individual RGB values
fun intsFromColor(color: Color): List<Int> {
    val rgb = color.rgb                 // Invokes Java’s getRGB method
    val alpha = rgb shr 24 and 0xff     // Shifts right and applies mask to return the proper Int
    val red = rgb shr 16 and 0xff       // Shifts right and applies mask to return the proper Int
    val green = rgb shr 8 and 0xff      // Shifts right and applies mask to return the proper Int
    val blue = rgb and 0xff
    return listOf(alpha, red, green, blue)
}

// The advantage to returning the individual values in a list is that you can use
// destructuring in a test, as in Example 2-37.
//----------------------------------------------------





