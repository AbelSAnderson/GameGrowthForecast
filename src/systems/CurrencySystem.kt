package systems

import growth.GrowthExpression
import kotlin.math.roundToInt

open class CurrencySystem(
    override val name: String,
    var value: Double,
    private val growthRate: GrowthExpression,
    private val showDouble: Boolean = false
) :
    System {

    private var _oldValue: Double? = null
    private val oldValue: Double
        get() = _oldValue ?: value

    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        val newCurrencyValue = growthRate.runCalculation(systemController, days)
        _oldValue = value
        value += newCurrencyValue
    }

    override fun calculateChanges(oldSystem: System): CurrencySystem {
        if (oldSystem !is CurrencySystem) throw ClassCastException("Provided Class: ${oldSystem.javaClass.name} cannot be cast to CurrencySystem")

        oldSystem.value = value
        return oldSystem
    }

    override fun resetSystem() {
        _oldValue = value
        value = 0.0
    }

    override fun toString(): String {
        return if (showDouble) {
            "Currency $name\n" +
                    "Old Value: $oldValue\n" +
                    "$name(s) Gained: ${value - oldValue}\n" +
                    "Currency Value: $value"
        } else {
            "Currency $name\n" +
                    "Old Value: ${oldValue.roundToInt()}\n" +
                    "$name(s) Gained: ${(value - oldValue).roundToInt()}\n" +
                    "Currency Value: ${value.roundToInt()}"
        }
    }
}