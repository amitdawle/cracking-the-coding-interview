package chapter4

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

class TreeTest : Spek({


    describe("Build minimal tree") {
        given("an empty list") {
            it("should build an Empty tree") {
                assertEquals(minimalTree(emptyList()), Empty)
            }
        }
        given("a list with one element") {
            it("should build a tree with one Node") {
                assertEquals(minimalTree(listOf(1)), Node(1, Empty, Empty))
            }
        }
        given("a list with two elements") {
            it("should build a tree with 2 Nodes with second node at mid as parent") {
                assertEquals(minimalTree(listOf(1,2)), Node(2, Node(1, Empty, Empty),Empty))
            }
        }
        given("a list with three elements") {
            it("should build a tree with 3 Nodes with the node at mid as parent") {
                assertEquals(minimalTree(listOf(1,2,3)), Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)))
            }
        }
        given("a list with some odd elements") {
            it("should build a tree with some Nodes with the node at mid as parent") {
                assertEquals(minimalTree(listOf(1,2,3,4,5)),
                                        Node(3,
                                                 Node(2, Node(1, Empty, Empty), Empty),
                                                 Node(5, Node(4, Empty, Empty), Empty)
                                        )
                        )
            }
        }
        given("a list with some even elements") {
            it("should build a tree with some Nodes with the node at mid as parent") {
                assertEquals(minimalTree(listOf(1,2,3,4,5,6)),
                        Node(4,
                                Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)),
                                Node(6,
                                        Node(5, Empty, Empty),
                                        Empty)
                        )
                )
            }
        }
   }
})