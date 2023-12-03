import advent.of.code.utils.Debugger
import advent.of.code.year2023.Day02
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Test : DescribeSpec({

    describe("example test") {
        it("part one answer is 8") {
            Day02.partOne("example01.txt") shouldBe 8
        }

//        it("part two answer is 281") {
//            Day01.partTwo("example02.txt") shouldBe 281
//        }
    }

    describe("compute solution") {
        it("solution not asserted") {
            Debugger.solution {
                /**
                 * Results {
                 * 	=> partOne: 2716 |  6ms
                 * }
                 */
                inspect(Day02::partOne, "problem.txt")
//                inspect(Day02::partTwo, "problem.txt")
            } shouldBe Unit
        }
    }
})