package growth

abstract class CurrencySystem(
    private val growthExpression: GrowthExpression,
    private val curencyPerDay: GrowthExpression,
    val startingCurrency: Int,
    val currency: Currency
) {

    fun calculateGrowth(currencyController: CurrencyController, days: Int) {

    }
}