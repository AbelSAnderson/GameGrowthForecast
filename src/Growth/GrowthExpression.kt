package Growth

import Currency.CurrencyController

class GrowthExpression(private val growthFunction: (CurrencyController, Int) -> Double) {

    fun runCalculation(currencyController: CurrencyController, days: Int) : Double {
        return growthFunction(currencyController, days)
    }
}