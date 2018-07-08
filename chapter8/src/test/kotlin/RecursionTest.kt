package chapter8

import org.junit.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


class RecursionTest : Spek({

    describe("get balanced parenthesis"){
        given("we have 0 ( and 0 )") {
            it("should produce the following list") {
                assertEquals(listOf(""), addParenthesis(0))
            }
        }
        given("we have 1 ( and 1 )") {
            it("should produce the following list") {
                assertEquals(listOf("()"), addParenthesis(1))
            }
        }
        given("we have 2 ( and 2 )") {
            it("should produce the following list") {
                assertEquals(listOf("(())", "()()"), addParenthesis(2))
            }
        }
        given("we have 3 ( and 3 )") {
            it("should produce the following list") {
                assertEquals(listOf("((()))", "(()())", "(())()", "()(())", "()()()" ), addParenthesis(3))
            }
        }

    }

    describe(" triple steps") {
        given(" some step") {
            it ("should give only 1 way to climb 1 step") {
                assertEquals(1, tripleStep(1))
            }
            it ("should give 2 ways to climb 2 steps") {
                assertEquals(2, tripleStep(2))
            }
            it ("should give 4 ways to climb 3 steps") {
                assertEquals(4, tripleStep(3))
            }
            it ("should give 7 ways to climb 4 steps") {
                assertEquals(7, tripleStep(4))
            }
            it ("should give 13 ways to climb 5 steps") {
                assertEquals(13, tripleStep(5))
            }
        }
    }

    describe(" memoized triple steps") {
        given(" some step") {
            it ("should give only 1 way to climb 1 step") {
                assertEquals(1, memoisedTripleStep(1))
            }
            it ("should give 2 ways to climb 2 steps") {
                assertEquals(2, memoisedTripleStep(2))
            }
            it ("should give 4 ways to climb 3 steps") {
                assertEquals(4, memoisedTripleStep(3))
            }
            it ("should give 7 ways to climb 4 steps") {
                assertEquals(7, memoisedTripleStep(4))
            }
            it ("should give 13 ways to climb 5 steps") {
                assertEquals(13, memoisedTripleStep(5))

            }
        }
    }

    describe(" power set") {
        given(" an empty set") {
            it ("should produce [[]]") {
                assertEquals(listOf(emptyList<String>()), powerSet(emptyList()))
            }
        }
        given(" a set with 1 element") {
            it ("should produce [[1] []]") {
                assertEquals(listOf(emptyList(), listOf("1")), powerSet(listOf("1")))
            }
        }
        given(" a set with 3 element") {
            it (" should produce powerset with 8 elements ") {
                assertEquals(listOf(emptyList(), listOf("3"), listOf("2"),
                     listOf("2", "3"), listOf("1"), listOf("1", "3"), listOf("1", "2"), listOf("1", "2", "3")), powerSet(listOf("1", "2", "3")))
            }
        }
    }


    describe(" permutations as") {
        given(" an empty string") {
            it ("produces no permutations" ) {
                assertEquals(listOf(""), permutations(""))
            }
        }
        given(" a string with 1 element") {
            it ("should have permutation with one element") {
                assertEquals(listOf("1"), permutations("1"))
            }
        }
        given(" a set with 3 elements") {
            it ("should produce 6 permutation ") {
                assertEquals(listOf("abc", "acb", "bac", "bca" ,"cab", "cba" ), permutations("abc"))
            }
        }
    }


})
