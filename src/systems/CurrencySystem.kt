package systems

import growth.GrowthExpression
import growth.SystemController

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

    override fun calculateChanges(oldSystem: System): CurrencySystem {
        if (oldSystem !is CurrencySystem) throw ClassCastException("Provided Class: ${oldSystem.javaClass.name} cannot be cast to CurrencySystem")

        oldSystem.systemValue = systemValue
        return oldSystem
    }

    override fun resetSystem() {
        systemValue.currentValue = 0
    }

    override fun toString(): String {
        return "Currency $name\n" +
                    "Currency value: $systemValue"

    }
}