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
})
