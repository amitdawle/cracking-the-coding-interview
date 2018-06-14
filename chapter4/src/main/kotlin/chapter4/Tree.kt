package chapter4


sealed class Tree<out T>
data class Node<out T>(val value:T, val left: Tree<T>, val right: Tree<T>) : Tree<T>()
object Empty : Tree<Nothing>()


fun  minimalTree(list : List<Int>) : Tree<Int> {
       return when(list.isEmpty()) {
           true -> Empty
           else -> {
               val mid = list[list.size / 2]
               Node(mid,
                       minimalTree(list.filter { it < mid }),
                       minimalTree(list.filter { it > mid }))
           }
       }
}


