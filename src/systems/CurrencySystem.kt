package systems

import growth.GrowthExpression
import growth.SystemController
import systems.helpers.Value
import systems.interfaces.System

open class CurrencySystem(
    override val name: String,
    override var systemValue: Value,
    private val growthRate: GrowthExpression
) :
    System {

    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        val newCurrencyValue = growthRate.runCalculation(systemController, days)
        systemValue.currentValue = newCurrencyValue
    }

    override fun resetSystem() {
        systemValue.currentValue = 0
    }

    override fun toString(): String {
        return "Currency $name\n" +
                    "Currency value: $systemValue"

    }
}