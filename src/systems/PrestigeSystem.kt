package systems

import growth.SystemController
import java.lang.ClassCastException

class PrestigeSystem(
    override val name: String,
    val prestigeCurrency: System,
    private val resetSystems: MutableList<System>,
    private val resetAfterDays: Int
    ) : System {

    override var systemValue: Value = Value(0)

    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        if ((totalDays % resetAfterDays) > days) {
            systemValue++
            prestigeCurrency.performGrowth(systemController, days, totalDays)
            resetSystems.forEach { it.resetSystem() }
        }
    }

    override fun calculateChanges(oldSystem: System): PrestigeSystem {
        if (oldSystem !is PrestigeSystem) throw ClassCastException("Provided Class: ${oldSystem.javaClass.name} cannot be cast to PrestigeSystem")

        prestigeCurrency.calculateChanges(oldSystem.prestigeCurrency)

        return oldSystem
    }

    override fun resetSystem() {
        systemValue.currentValue = 0
        prestigeCurrency.resetSystem()
    }

    override fun clone(): PrestigeSystem {
        val clone = PrestigeSystem(name, prestigeCurrency.clone() as CurrencySystem, resetSystems, resetAfterDays)
        clone.systemValue = systemValue
        return clone
    }

    override fun toString(): String {
        return "Prestige System $name\n" +
                "PrestigeCount: $systemValue\n\n" +
                prestigeCurrency
    }
}