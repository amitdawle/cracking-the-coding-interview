package chapter2

import org.junit.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


class ListsTest : Spek({
    describe("remove duplicate"){
        given("an empty list"){
            it("returns an empty list"){
                assertEquals(EmptyNode, removeDuplicates(EmptyNode) )
            }
        }
        given("an list with no duplicates"){
            it("returns same list"){
                assertEquals(DataNode(1, DataNode(2, EmptyNode)),
                        removeDuplicates(buildFrom(listOf(1,2))) )
            }
        }
        given("an list with duplicates"){
            it("returns list without duplicates"){
                assertEquals(DataNode(1, DataNode(2, EmptyNode)),
                        removeDuplicates(buildFrom(listOf(1,2,2))) )
            }
        }
    }

    describe("kth to last"){
        given("an empty list"){
            it("returns an empty list"){
                assertEquals(EmptyNode, kthToLast(EmptyNode, 4) )
            }
        }
        given("an list"){
            it("returns entire list when k > length "){
                assertEquals(DataNode(1, DataNode(2, EmptyNode)),
                        kthToLast(buildFrom(listOf(1,2)), 3) )
            }
        }
        given("an list"){
            it("returns sublist when k < length "){
                assertEquals(DataNode(2, DataNode(1, EmptyNode)),
                        kthToLast(buildFrom(listOf(6,5,4,3,2,1)), 2) )
            }
        }
    }


    describe("kth to last _1"){
        given("an empty list"){
            it("returns an empty list"){
                assertEquals(EmptyNode, kthToLast_1(EmptyNode, 4) )
            }
        }
        given("an list _1"){
            it("returns entire list when k > length "){
                assertEquals(DataNode(1, DataNode(2, EmptyNode)),
                        kthToLast_1(buildFrom(listOf(1,2)), 3) )
            }
        }
        given("an list _1"){
            it("returns sublist when k < length "){
                assertEquals(DataNode(2, DataNode(1, EmptyNode)),
                        kthToLast_1(buildFrom(listOf(6,5,4,3,2,1)), 2) )
            }
        }
    }


    describe("Partition"){
        given("an empty list"){
            it("returns an empty list"){
                assertEquals(emptyList<Int>(), partition(emptyList(), 4) )
            }
        }
        given("a list"){
            it("returns partitioned list"){
                assertEquals(listOf(1,2,3,4,4,5,5,6,7,7,5),
                        partition(listOf(1,2,3,4,5,4,5,6,7,7,5), 4) )
            }
        }
        given("a list without partition element"){
            it("returns same list"){
                assertEquals(listOf(1,2,3,4,4,5,5,6,7,7,5),
                        partition(listOf(1,2,3,4,4,5,5,6,7,7,5), 11) )
            }
        }

    }

    describe("sum list (numbers in reverse)"){
        given("lists containing 0"){
            it("returns 0"){
                assertEquals(listOf(0) , sumListReverseOrder(listOf(0), listOf(0))  )
            }
        }
        given("lists containing 100 (0,0,1) and 23 (3, 2)"){
            it("returns 123 (3,2,1)"){
                assertEquals(listOf(3,2,1)  , sumListReverseOrder(listOf(0,0,1), listOf(3, 2)) )
            }
        }
        given("lists containing 99989 (9,8,9,9,9) and 21 (1,2)"){
            it("returns 100010 (0,1,0,0,0,1)"){
                assertEquals(listOf(0,1,0,0,0,1), sumListReverseOrder(listOf(9,8,9,9,9), listOf(1,2)))
            }
        }
    }


    describe("sum list (numbers in correct order))"){
        given("lists containing 0"){
            it("returns 0"){
                assertEquals(listOf(0), sumList(listOf(0), listOf(0)))
            }
        }
        given("lists containing 100 (1,0,0) and 23 (2,3)"){
            it("returns 123 (1,2,3)"){
                assertEquals(listOf(1,2,3)  , sumList(listOf(1,0,0), listOf(2, 3)) )
            }
        }
        given("lists containing 99989 (9,9,9,8,9) and 21 (2, 1)"){
            it("returns 100010 (1,0,0,1,0)"){
                assertEquals(listOf(1,0,0,0,1,0), sumList(listOf(9,9,9,8,9), listOf(2,1)))
            }
        }
    }
})