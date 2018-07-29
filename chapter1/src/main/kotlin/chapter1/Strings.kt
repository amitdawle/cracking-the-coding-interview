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


fun oneEditAway(s: String, t: String) : Boolean {

    val (longer, shorter) = if (s.length > t.length) Pair(s, t) else Pair(t, s)

    fun isDeletion(l: String, s: String): Boolean {
        return l.length > s.length
    }

    fun countEdits(l: String, s: String) : Int{
       return when(s.isEmpty()){
            true -> l.length
            false -> if( l.take(1) == s.take(1)) {
                countEdits(l.drop(1), s.drop(1))
            } else if( isDeletion(l , s) ) {
                1 + countEdits(l.drop(1), s)
            } else {
                1 + countEdits(l.drop(1), s.drop(1))
            }

        }
    }
    return countEdits(longer, shorter) <= 1
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
//    println(isUniqueWithoutAdditionalDataStructure("abba"))
//    println(isUniqueWithoutAdditionalDataStructure("abcd"))
//
//    println(isUnique("abba"))
//    println(isUnique("abcd"))
//
//    println(isPermutationPalindrome("aab b"))
//    println(isPermutationPalindrome("aab  ab"))

    println(oneEditAway("pale", "ple"))
    println(oneEditAway("pales", "pale"))
    println(oneEditAway("pale", "bale"))
    println(oneEditAway("pale", "bake"))
}