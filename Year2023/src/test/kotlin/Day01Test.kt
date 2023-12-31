import advent.of.code.utils.Debugger
import advent.of.code.year2023.Day01
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Test : DescribeSpec({

    describe("example test") {
        it("part one answer is 142") {
            Day01.partOne("example01.txt") shouldBe 142
        }

        it("part two answer is 281") {
            Day01.partTwo("example02.txt") shouldBe 281
        }
    }

    describe("compute solution") {
        it("inspect answer") {
            Debugger.inspect {
                log(Day01::partOne, "problem.txt")
                log(Day01::partTwo, "problem.txt")
            } shouldBe Unit
        }
    }
})