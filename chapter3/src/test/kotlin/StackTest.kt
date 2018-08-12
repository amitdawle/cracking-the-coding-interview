import org.junit.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


class StackTest : Spek({
    describe("Min Stack"){
        given("a stack with elements pushed in following order 1,2,3,4,5"){
            it("returns 1 as min"){
               val m = MyStack()
                m.push(1)
                m.push(2)
                m.push(3)
                m.push(4)
                m.push(5)
                assertEquals(1, m.min())
            }
        }
    }

    describe("Min Stack with elements popped"){
        given("a stack with elements pushed in following order 1,2,3,4,5 and then two popped"){
            it("returns 3 as min"){
                val m = MyStack()
                m.push(3)
                m.push(4)
                m.push(5)
                m.push(2)
                m.push(1)
                m.pop()
                m.pop()
                assertEquals(3, m.min())
            }
        }
    }


})