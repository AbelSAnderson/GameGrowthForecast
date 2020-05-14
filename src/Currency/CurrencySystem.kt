package Currency

import Growth.GrowthExpression

class CurrencySystem(
    val currency: Currency,
    private val growthExpression: GrowthExpression
) {

    fun calculateGrowth(currencyController: CurrencyController, days: Int) {
        val newCurrencyValue = growthExpression.runCalculation(currencyController, days)
        currency.updateCurrency(newCurrencyValue)
    }
}