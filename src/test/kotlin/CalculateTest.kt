import calculator.utils.multipleCalculate
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

private const val WHITESPACE = " "

class CalculateTest : DescribeSpec({
    describe("Calculate") {
        context("덧셈식이 주어졌을 때") {
            val formula = "12 + 6"
            it("덧셈") {
                multipleCalculate(formula, WHITESPACE) shouldBe 18
            }
        }

        context("뺄셈식이 주어졌을 때") {
            val formula = "17 - 7"
            it("뺄셈") {
                multipleCalculate(formula, WHITESPACE) shouldBe 10
            }
        }

        context("곱셈식이 주어졌을 때") {
            val formula = "13 * 13"
            it("곱셈") {
                multipleCalculate(formula, WHITESPACE) shouldBe 169
            }
        }

        context("나눗셈식이 주어졌을 때") {
            val formula = "15 / 3"
            it("나눗셈") {
                multipleCalculate(formula, WHITESPACE) shouldBe 5
            }
        }

        context("공백이 주어졌을 때") {
            val formula = ""
            it("에러발생") {
                shouldThrow<IllegalArgumentException> {
                    multipleCalculate(formula, WHITESPACE)
                }
            }
        }

        context("사칙연산 기호가 아닌 경우가 주어졌을 때") {
            val formula = "17 ] 12"
            it("에러발생") {
                shouldThrow<IllegalArgumentException> {
                    multipleCalculate(formula, WHITESPACE)
                }
            }
        }

        context("곱셈 혹은 나눗셈에서 분모가 0인 경우가 주어졌을 때") {
            val formula = "17 * 12 / 0"
            it("에러발생") {
                shouldThrow<IllegalArgumentException> {
                    multipleCalculate(formula, WHITESPACE)
                }
            }
        }

        context("사칙연산이 주어졌을 때") {
            val formula = "10 - 5 * 10 + 10 / 5"
            it("순차적으로 계산") {
                multipleCalculate(formula, WHITESPACE) shouldBe 12
            }
        }
    }
})
