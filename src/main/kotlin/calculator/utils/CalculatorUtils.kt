package calculator.utils

import calculator.enums.Operator

fun multipleCalculate(formula: String, separator: String): Double {
    requireNullOrEmpty(formula)

    val trimFormula = splitBySeparator(formula, separator)
    var answer = trimFormula[0].toDouble()
    for (i in 1 until trimFormula.size step 2) {
        val operand = trimFormula[i + 1].toDouble()
        val operator = Operator.of(trimFormula[i])
        answer = operator.calculate(answer, operand)
    }
    return answer
}
