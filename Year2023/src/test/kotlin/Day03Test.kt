import advent.of.code.utils.Debugger
import advent.of.code.year2023.Day03
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day03Test : DescribeSpec({

    describe("example test") {
        it("part one answer is 4361") {
            Day03.partOne("example01.txt") shouldBe 4361
        }

        it("part two answer is 467835") {
            Day03.partTwo("example01.txt") shouldBe 467835
        }
    }

    describe("compute solution") {
        it("inspect answer") {
            Debugger.inspect {
                log(Day03::partOne, "problem.txt")
                log(Day03::partTwo, "problem.txt")
            } shouldBe Unit
        }
    }
})