package chapter2

sealed class Node<out T>
data class DataNode<out T>(val data: T, val next:Node<T>) : Node<T>()
object EmptyNode : Node<Nothing>()


fun main(args: Array<String>) {
    println(buildFrom(listOf(1,2,3,4,5,6)))
    println( removeDuplicates(DataNode(1, DataNode(1, DataNode(1, EmptyNode))), mutableSetOf()) )
}

fun <T> removeDuplicates(n: Node<T>) : Node<T>{
    return removeDuplicates(n, mutableSetOf())
}

private fun <T> removeDuplicates(n: Node<T>, m: MutableSet<T>) : Node<T> {
    return when(n) {
       is EmptyNode -> EmptyNode
       is DataNode  ->  if( m.contains(n.data)) {
                            removeDuplicates(n.next, m)
                        } else {
                          m.add(n.data)
                          DataNode(n.data, removeDuplicates(n.next, m))
                        }
    }
}

fun <T> buildFrom(l : List<T>) : Node<T> {
    val e : Node<T> = EmptyNode
    return l.foldRight(e) { x, t -> DataNode(x , t) }
}