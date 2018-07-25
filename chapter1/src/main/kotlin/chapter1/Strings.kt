package chapter1

import java.util.*

fun isUniqueWithoutAdditionalDataStructure(s: String): Boolean {
    return when(s.isEmpty()) {
        true -> true
        false -> {
            val cs = s.toCharArray()
            cs.sort()
            val sorted = String(cs)
            sorted.zip(sorted.drop(1)).all { (a,b) -> a != b }
        }
    }
}


fun isUnique(s: String): Boolean {
    var set = mutableSetOf<Char>()
    return s.foldRight(true) { c, r ->  set.add(c) && r  }
}


fun isPermutationPalindrome(s: String): Boolean {
    val b = BitSet()
    s.map (Char::toLowerCase).map(Char::toInt).forEach{b.flip(it)}
    return b.cardinality() <= 1
}

fun main(args: Array<String>) {
    println(isUniqueWithoutAdditionalDataStructure("abba"))
    println(isUniqueWithoutAdditionalDataStructure("abcd"))

    println(isUnique("abba"))
    println(isUnique("abcd"))

    println(isPermutationPalindrome("aab b"))
    println(isPermutationPalindrome("aab  ab"))


}