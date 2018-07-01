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
})