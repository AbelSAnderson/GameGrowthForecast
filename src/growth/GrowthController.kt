package growth

import currency.Currency
import currency.CurrencyController

class GrowthController(currencies: MutableList<Currency>) {
    private val currencyController: CurrencyController = CurrencyController(currencies)

    fun calculateGrowth(days: Int): CurrencyController {
        currencyController.calculateGrowth(days)
        return currencyController
    }

    fun calculateGrowth(oldGrowthData: CurrencyController): CurrencyController {
        return currencyController.calculateGrowth(oldGrowthData)
    }

    fun currentGrowth(): CurrencyController {
        return currencyController
    }
}