package chapter2

import javax.xml.crypto.Data

sealed class Node<out T>
data class DataNode<out T>(val data: T, val next:Node<T>) : Node<T>()
object EmptyNode : Node<Nothing>()


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

// length is not known, recursive
fun <T> kthToLast(l : Node<T>, k: Int) : Node<T> {
    fun kthToLast(xs: Node<T>, ys: Node<T>) : Node<T>{
       return when(ys){
            is EmptyNode -> xs
            is DataNode  -> kthToLast((xs as DataNode).next, ys.next)
        }
    }
    return kthToLast(l, l.drop(k))
}


fun <T> kthToLast_1(l : Node<T>, k: Int) : Node<T> {
    fun kthToLast(xs: Node<T>, n : Int) : Pair<Int, Node<T>> {
        return when (xs) {
            is EmptyNode -> Pair(0, EmptyNode)
            is DataNode -> {
                    val (l, node) = kthToLast(xs.next, n - 1)
                    if (l == k) {
                        Pair(l, node)
                    } else {
                        Pair(l + 1, xs)
                    }
            }
        }
    }
    return kthToLast(l, k).second
}


private fun <T> Node<T>.drop(k: Int): Node<T> {
    return when(this){
        is EmptyNode -> EmptyNode
        is DataNode -> when( k == 0 ){
                            true -> this
                            false -> this.next.drop(k - 1)

        }
    }
}


fun <T> buildFrom(l : List<T>) : Node<T> {
    return l.foldRight(EmptyNode as Node<T>) { x, t -> DataNode(x , t) }
}