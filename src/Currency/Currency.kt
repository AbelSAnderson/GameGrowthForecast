package Currency

import kotlin.math.roundToInt

class Currency(val name: String, var currentValue: Double, private val showDouble: Boolean = false): Cloneable {
    var oldValue: Double = currentValue

    fun updateCurrency(value: Double) {
        oldValue = currentValue
        currentValue += value
    }

    fun calculateChanges(oldCurrency: Currency): Currency {
        oldCurrency.currentValue = currentValue
        return oldCurrency
    }

    override fun toString(): String {
        return if(showDouble) {
            "Player $name\n" +
                    "Old Value: $oldValue\n" +
                    "$name(s) Gained: ${currentValue - oldValue}\n" +
                    "Currency Value: $currentValue"
        } else {
            "Player $name\n" +
                    "Old Value: ${oldValue.roundToInt()}\n" +
                    "$name(s) Gained: ${(currentValue - oldValue).roundToInt()}\n" +
                    "Currency Value: ${currentValue.roundToInt()}"
        }

    }

    public override fun clone(): Currency {
        return super.clone() as Currency
    }
}