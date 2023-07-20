package calculator.utils

import calculator.enums.Error.CANNOT_BLANK_INPUT_FORMULA

fun requireNullOrEmpty(formula: String?) {
    require(formula != null && formula.isNotBlank()) {
        throw IllegalArgumentException(CANNOT_BLANK_INPUT_FORMULA.message)
    }
}

fun splitBySeparator(formula: String, separator: String) = formula.split(separator)
