package systems

import growth.SystemController
import systems.helpers.Value
import systems.interfaces.SubSystem
import systems.interfaces.System

class PrestigeSystem(
    override val name: String,
    override val innerSystem: System,
    private val resetSystems: MutableList<System>,
    private val resetAfterDays: Int
    ) : System, SubSystem {

    override var systemValue: Value = Value(0)

    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        if ((totalDays % resetAfterDays) > days) {
            systemValue++
            innerSystem.performGrowth(systemController, days, totalDays)
            resetSystems.forEach { it.resetSystem() }
        }
    }

    override fun resetSystem() {
        systemValue.currentValue = 0.1
        innerSystem.resetSystem()
    }

    override fun toString(): String {
        return "Prestige System - $name\n" +
                "$systemValue\n\n" +
                innerSystem
    }
}