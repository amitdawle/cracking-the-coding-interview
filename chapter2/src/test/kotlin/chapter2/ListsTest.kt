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

})