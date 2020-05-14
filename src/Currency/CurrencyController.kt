package Currency

class CurrencyController(initialCurrencies: MutableList<Currency> = mutableListOf()): Cloneable {

    private var currencies: HashMap<String, Currency> = hashMapOf()

    init {
        initialCurrencies.forEach{
            currencies[it.name] = it
        }
    }

    fun getCurrency(currencyName: String): Currency {
        return currencies[currencyName] ?: Currency("Error", -1.0)
    }

    fun getCurrencyValue(currencyName: String): Double {
        return currencies[currencyName]?.currentValue ?: -1.0
    }

    fun addCurrencies(newCurrencies: HashMap<String, Currency>) {
        currencies.putAll(newCurrencies)
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