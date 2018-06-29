package chapter4

import java.util.*
import kotlin.math.abs
import kotlin.math.max

sealed class Tree<out T>
data class Node<out T>(val value:T, val left: Tree<T>, val right: Tree<T>) : Tree<T>()
object Empty : Tree<Nothing>()

fun  <T> minimalTree(list : List<T>) : Tree<T> {
        return when(list.size){
            0 -> Empty
            else -> {
                val mid = list.size / 2
                return  Node(list[mid],
                        minimalTree(list.take(mid)),
                        minimalTree(list.drop(mid + 1)))

            }
        }
 }


fun <T> isBalanced(tree : Tree<T>) : Boolean {

    fun <T> checkHeight(t : Tree<T>) : Int? {
        return when (t) {
            is Empty -> 0
            is Node -> {
                val l:Int? = checkHeight(t.left)
                val r:Int? = checkHeight(t.right)
                l?.let { lh ->
                    r?.let { rh ->
                            if (abs(rh - lh) > 1) null
                            else max(lh, rh) + 1
                }}
            }
        }
    }
    return checkHeight(tree)?.let{ _ -> true } ?: false
}


