package chapter4

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


