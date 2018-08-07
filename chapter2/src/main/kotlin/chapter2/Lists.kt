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

fun partition(l : List<Int> , p : Int) : List<Int> {
    val res = l.fold(Pair(mutableListOf<Int>(), mutableListOf<Int>()))
    {(xs, ys),  x  ->
            if (x > p) ys.add(x) else xs.add(x)
            Pair(xs, ys)
    }

    return res.first + res.second
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


fun <T> kthToLast_1(ls : Node<T>, k: Int) : Node<T> {
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
    return kthToLast(ls, k).second
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


fun sumList(one: List<Int> , two: List<Int> ) : List<Int> {

    val a = listToNumber(one)
    val b = listToNumber(two)
    val sum = a + b
    return numberToList(sum)
}

fun numberToList(sum: Int): List<Int> {
    if( sum < 10 ){
        return listOf(sum)
    }
    fun toList(n: Int, soFar: MutableList<Int>) : List<Int> {
        return when(n == 0) {
            true -> soFar
            else -> {
                soFar.add(0, n % 10)
                toList(n / 10 , soFar)
            }
        }
    }
    return toList(sum, mutableListOf())
}


fun sumListReverseOrder(one: List<Int> , two: List<Int> ) : List<Int> {

    val a = reverseListToNumber(one)
    val b = reverseListToNumber(two)
    val sum = a + b
    return  numberToReverseList(sum)
}

fun numberToReverseList(input: Int) : List<Int>{
    if( input == 0){
        return listOf(0)
    }

    fun toList(i: Int): List<Int>{
         return when( i == 0) {
             true -> return emptyList()
             false -> listOf(i % 10) + toList(i / 10)
         }
    }
    return toList(input)
}



fun reverseListToNumber(input: List<Int>) : Int{
  return input.fold(Pair(0,1)){ (sum, pow), x -> Pair(x * pow + sum, pow * 10 )}.first
}




fun listToNumber(input: List<Int>) : Int{
    return when(input.size == 1){
        true -> input[0]
        else ->  input.drop(1).fold(input[0]) {t ,x -> x + t * 10 }
    }
}

fun <T> buildFrom(l : List<T>) : Node<T> {
    return l.foldRight(EmptyNode as Node<T>) { x, t -> DataNode(x , t) }
}

fun main(args: Array<String>) {
    println(sumListReverseOrder(listOf(1), listOf(9,9)))
    println(sumListReverseOrder(listOf(1,1), listOf(8,9,9,9,9)))
    println(sumListReverseOrder(listOf(0), listOf(0)))
    println(sumListReverseOrder(listOf(-1), listOf(1)))


    println(sumList(listOf(1), listOf(9,9)))
    println(sumList(listOf(1, 5), listOf(9,9)))
    println(sumList(listOf(1, 2, 1), listOf(8,9)))
}