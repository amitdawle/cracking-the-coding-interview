package chapter4

import org.junit.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

class TreeTest : Spek({


    describe("Build minimal tree") {
        given("an empty list") {
            it("should build an Empty tree") {
                assertEquals(Empty, minimalTree(emptyList<Int>()))
            }
        }
        given("a list with one element") {
            it("should build a tree with one Node") {
                assertEquals(Node(1, Empty, Empty), minimalTree(listOf(1)))
            }
        }
        given("a list with two elements") {
            it("should build a tree with 2 Nodes with second node at mid as parent") {
                assertEquals(Node(2, Node(1, Empty, Empty),Empty), minimalTree(listOf(1,2)))
            }
        }
        given("a list with three elements") {
            it("should build a tree with 3 Nodes with the node at mid as parent") {
                assertEquals(Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)), minimalTree(listOf(1,2,3)))
            }
        }
        given("a list with some odd elements") {
            it("should build a tree with some Nodes with the node at mid as parent") {
                assertEquals(Node(3,
                                                 Node(2, Node(1, Empty, Empty), Empty),
                                                 Node(5, Node(4, Empty, Empty), Empty)
                                        ), minimalTree(listOf(1,2,3,4,5))
                        )
            }
        }
        given("a list with some even elements") {
            it("should build a tree with some Nodes with the node at mid as parent") {
                assertEquals(Node(4,
                                Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)),
                                Node(6,
                                        Node(5, Empty, Empty),
                                        Empty)
                              ),
                        minimalTree(listOf(1,2,3,4,5,6))
                )
            }
        }
   }
})