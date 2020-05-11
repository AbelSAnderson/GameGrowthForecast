package growth

class CurrencyController(intialAttributes: MutableList<Currency> = mutableListOf()) {

    private val currencies: HashMap<String, Currency> = hashMapOf()

    init {
        intialAttributes.forEach{
            currencies[it.name] = it
        }
    }

    fun getAttribute(attribute: String): Currency {
        return currencies[attribute] ?: Currency("Error", -1.0)
    }

    fun addAttributes(newAttributes: HashMap<String, Currency>) {
        currencies.putAll(newAttributes)
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
}