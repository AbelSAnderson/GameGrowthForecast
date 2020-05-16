package currency

class CurrencyController(initialCurrencies: MutableList<Currency> = mutableListOf()): Cloneable {

    private var currencies: HashMap<String, Currency> = hashMapOf()

    init {
        initialCurrencies.forEach{
            currencies[it.name] = it
        }
    }

    fun getCurrency(currencyName: String): Currency {
        return currencies[currencyName] ?: throw NoSuchElementException("Currency Could not be found - Please check the currency name you provided.")
    }

    fun getCurrencyValue(currencyName: String): Double {
        return currencies[currencyName]?.currentValue ?: throw NoSuchElementException("Currency Could not be found - Please check the currency name you provided.")
    }

    fun addCurrencies(newCurrencies: HashMap<String, Currency>) {
        currencies.putAll(newCurrencies)
    }

    fun calculateGrowth(days: Int) {
        currencies.forEach {
            it.value.calculateGrowth(this, days)
        }
    }

    fun calculateGrowth(oldCurrencyController: CurrencyController): CurrencyController {
        oldCurrencyController.currencies.forEach {
            currencies[it.key]?.calculateChanges(it.value)
        }

        return oldCurrencyController
    }

    override fun toString(): String {
        var summaryString = ""

        currencies.forEach {
            summaryString += "\n${it.value}\n"
        }

        return summaryString
    }

    public override fun clone(): CurrencyController {
        val newCurrencyController = CurrencyController()

        currencies.forEach { newCurrencyController.currencies[it.key] = it.value.clone() }

        return newCurrencyController
    }
}