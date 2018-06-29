package chapter8

fun addParenthesis(count:Int): List<String> {

    fun add(soFar: List<String>, l :Int, r :Int) : List<String>{
        if( l < 0 || r < l ) {
            return emptyList()
        }
        return when( l == 0 && r == 0 ){
            true -> soFar
            else -> add( soFar.map { s -> "$s(" }, l - 1, r) +
                    add(soFar.map { s -> "$s)" }, l , r - 1)
        }

    }
    return add( listOf(""), count, count)
}




fun isPalindrome(l:List<Int>) : Boolean {
    fun checkPalindrome(head:Int, n:Int, lst: List<Int>) : Pair<Boolean, List<Int>> {
        return when(n){
            0 -> Pair(lst[0] == head, lst.drop(1))
            1 -> Pair(true, lst.drop(1))
            else -> {
                val (x, xs) = checkPalindrome(lst[0], n - 2, lst.drop(1))
                when(x){
                    true -> Pair(true, xs.drop(1))
                    false -> Pair(false, emptyList())
                }
            }
        }
    }
    return checkPalindrome(l[0], l.size , l).first
}
