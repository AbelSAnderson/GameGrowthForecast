package growth

class Currency(val name: String, var currentValue: Double) {
    var oldValue: Double = currentValue

    fun updateCurrency(value: Double) {
        oldValue = currentValue
        currentValue = value
    }

    fun calculateChanges(oldCurrency: Currency): Currency {
        oldCurrency.currentValue = currentValue
        return oldCurrency
    }

    override fun toString(): String {
        return "Player $name\n" +
                "Old Value: $oldValue" +
                "$name(s) Gained: ${currentValue - oldValue}" +
                "Currency Value: $currentValue"
    }
}