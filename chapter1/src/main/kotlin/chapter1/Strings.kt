package chapter1

import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.LinkedHashMap

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

//This could also be done using groupBy
fun compress(s : String): String {
    val seq = LinkedHashMap<Char, AtomicInteger>()


    s.forEach {
        c ->
            seq.putIfAbsent(c, AtomicInteger())
            seq[c]!!.incrementAndGet()
    }

    return when(seq.values.all { v -> v.get() == 1 }) {
        true -> s
        else -> seq.entries.fold("" ){ str, (k, v) -> str + k + v }
    }



}

fun main(args: Array<String>) {
    println(isUniqueWithoutAdditionalDataStructure("abba"))
    println(isUniqueWithoutAdditionalDataStructure("abcd"))

    println(isUnique("abba"))
    println(isUnique("abcd"))

    println(isPermutationPalindrome("aab b"))
    println(isPermutationPalindrome("aab  ab"))


}