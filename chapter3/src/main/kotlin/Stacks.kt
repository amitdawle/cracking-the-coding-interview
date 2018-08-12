import java.util.*

class MyStack {

    private val minList = mutableListOf<Int>()
    private val stack = Stack<Int>()

    fun push(i : Int ) {
        if(minList.isEmpty() || i <= minList[0] ) {
            minList.add(0 , i)
        }
        stack.push(i)
    }


    fun pop() : Int? {
        if(!stack.isEmpty() && stack.peek() == minList[0]){
            minList.removeAt(0)
        }
        return stack.pop()
    }

    fun min() : Int? {
        return when(minList.isEmpty()){
            true -> null
            else -> minList[0]
        }
    }

}

fun main(args: Array<String>) {
    val s = MyStack()

    s.push(5)
    println(s.min())
    s.push(3)
    s.push(3)
    s.push(1)
    println(s.min())
    s.pop()
    println(s.min())
    s.pop()
    println(s.min())
    s.pop()
    println(s.min())



}