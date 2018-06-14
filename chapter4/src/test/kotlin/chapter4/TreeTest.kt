package chapter4

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

class TreeTest : Spek({


    describe("Build minimal tree") {
        given("An empty list") {
            it("Should build an Empty tree") {
                assertEquals(minimalTree(emptyList()), Empty)
            }
        }
        given("A list with one element") {
            it("Should build a tree with one Node") {
                assertEquals(minimalTree(listOf(1)), Node(1, Empty, Empty))
            }
        }
        given("A list with two elements") {
            it("Should build a tree with 2 Nodes with second node at mid as parent") {
                assertEquals(minimalTree(listOf(1,2)), Node(2, Node(1, Empty, Empty),Empty))
            }
        }
        given("A list with three elements") {
            it("Should build a tree with 3 Nodes with the node at mid as parent") {
                assertEquals(minimalTree(listOf(1,2,3)), Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)))
            }
        }
   }
})