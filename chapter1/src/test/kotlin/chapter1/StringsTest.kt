package chapter1

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.*


class StringsTest : Spek({
    describe("Check for uniqueness "){
        given("an empty list"){
            it("returns true"){
                assertTrue(isUnique(""))
            }
        }
        given("an unique list"){
            it("returns true"){
                assertTrue(isUnique("abcdefghijklmnopqrstuvwxyz"))
            }
        }

        given("an non unique list"){
            it("returns false"){
                assertFalse(isUnique("abcdefghijklmnopqrstuvwxyza"))
            }
        }
    }
    describe("Check for uniqueness without datastructure "){
        given("an empty list"){
            it("returns true"){
                assertTrue(isUniqueWithoutAdditionalDataStructure(""))
            }
        }
        given("an unique list"){
            it("returns true"){
                assertTrue(isUniqueWithoutAdditionalDataStructure("abcdefghijklmnopqrstuvwxyz"))
            }
        }

        given("an non unique list"){
            it("returns false"){
                assertFalse(isUniqueWithoutAdditionalDataStructure("abcdefghijklmnopqrstuvwxyza"))
            }
        }
    }

    describe("Check if permutation is a palindrome ") {
        given("an empty list") {
            it("returns true") {
                assertTrue(isPermutationPalindrome(""))
            }
        }
        given("an list that has palindrome") {
            it("returns true") {
                assertTrue(isPermutationPalindrome("abb  a  vv  cc")) // one possibility "abvc  a  cvba"
            }
        }

        given("an list that has palindrome") {
            it("returns true") {
                assertFalse(isPermutationPalindrome("abb  a  vv  c"))
            }
        }
    }

    describe("Compression of list "){
        given("an empty list"){
            it("returns \"\""){
                assertEquals("", compress(""))
            }
        }

        given("a list aabbbbcccddddddddd"){
            it("returns a2b4c3d9"){
                assertEquals("a2b4c3d9", compress("aabbbbcccddddddddd"))
            }
        }

        given("a list abcde"){
            it("returns abcde"){
                assertEquals("abcde", compress("abcde"))
            }
        }


    }


})