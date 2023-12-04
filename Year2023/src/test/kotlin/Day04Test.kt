import advent.of.code.utils.Debugger
import advent.of.code.year2023.Day04
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Test : DescribeSpec({

    describe("example test") {
        it("part one answer is 13") {
            Day04.partOne("example01.txt") shouldBe 13
        }

        it("part two answer is 13") {
            Day04.partTwo("example01.txt") shouldBe 30
        }
    }

    describe("compute solution") {
        it("inspect answer") {
            Debugger.inspect {
                log(Day04::partOne, "problem.txt")
                log(Day04::partTwo, "problem.txt")
            } shouldBe Unit
        }
    }
})