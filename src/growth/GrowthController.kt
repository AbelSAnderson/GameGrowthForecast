package growth

class GrowthController(currencySystems: MutableList<CurrencySystem>) {

    private val player = Player(currencySystems)

    fun calculateGrowth(forDays: Int): CurrencyController {
        return player.calculateGrowth(forDays)
    }

    fun calculateGrowth(oldGrowthData: CurrencyController): CurrencyController {
        return player.getGrowthData(oldGrowthData)
    }

    fun currentGrowth(): CurrencyController {
        return player.currencyController
    }
}