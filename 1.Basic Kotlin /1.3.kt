/*
- Problem
You want to print a number in a base other than base 10.

- Solution
Use the extension function toString(radix: Int) for a valid radix.
*/

//----------------------------------------------------
//Example 1.3-1. Printing 42 in binary
42.toString(2) == "101010"
//----------------------------------------------------


//----------------------------------------------------
//Example 1.3-2. Printing 42 in all available radix values
(Character.MIN_RADIX..Character.MAX_RADIX).forEach { radix ->
    println("$radix: ${42.toString(radix)}")
}
// The output is as follows:
/*
                Radix Value
                2:      101010
                3:      1120
                4:      222
                5:      132
                6:      110
                7:      60
                8:      52
                9:      46
                10:     42
                ...
                32:     1a
                33:     19
                34:     18
                35:     17
                36:     16 
*/
//----------------------------------------------------