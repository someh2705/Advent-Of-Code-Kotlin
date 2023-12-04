import advent.of.code.utils.Debugger
import advent.of.code.year2023.Day01
import advent.of.code.year2023.Day02
import advent.of.code.year2023.Day03
import advent.of.code.year2023.Day04
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Benchmark : DescribeSpec({
    describe("benchmark problems") {
        it("create day1 bench file") {
            Debugger.benchmark(Day01::class.simpleName!!) {
                create(Day01::partOne, "problem.txt")
                create(Day01::partTwo, "problem.txt")
            } shouldBe Unit
        }

        it("create day2 bench file") {
            Debugger.benchmark(Day02::class.simpleName!!) {
                create(Day02::partOne, "problem.txt")
                create(Day02::partTwo, "problem.txt")
            } shouldBe Unit
        }

        it("create day3 bench file") {
            Debugger.benchmark(Day03::class.simpleName!!) {
                create(Day03::partOne, "problem.txt")
                create(Day03::partTwo, "problem.txt")
            } shouldBe Unit
        }

        it("create day4 bench file") {
            Debugger.benchmark(Day04::class.simpleName!!) {
                create(Day04::partOne, "problem.txt")
                create(Day04::partTwo, "problem.txt")
            } shouldBe Unit
        }
    }
})