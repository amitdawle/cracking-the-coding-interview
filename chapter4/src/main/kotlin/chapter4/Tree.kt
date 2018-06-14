package chapter4

import kotlin.math.E


sealed class Tree<out T>
data class Node<out T>(val value:T, val left: Tree<T>, val right: Tree<T>) : Tree<T>()
object Empty : Tree<Nothing>()


fun  minimalTree(list : List<Int>) : Tree<Int> {
       return when(list.size) {
           0 -> Empty
           1 -> Node(list[0], Empty, Empty)
           2 -> Node(list[1], Node(list[0], Empty, Empty), Empty)
           else -> {
               val mid = list.size / 2
               Node(list[mid],
                       minimalTree(list.subList(0, mid)),
                       minimalTree(list.subList(mid + 1, list.size)))
           }
       }
}


