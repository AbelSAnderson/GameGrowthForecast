package systems

import growth.GrowthExpression
import growth.SystemController
import systems.helpers.Level
import systems.helpers.Value
import systems.interfaces.System

class LevelSystem(
    override val name: String,
    override var systemValue: Value,
    growthRate: GrowthExpression,
    innerSystem: System,
    firstLevelExperience: Int
) :
    Level(
        growthRate,
        innerSystem,
        firstLevelExperience
    ), System {

    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        innerSystem.performGrowth(systemController, days, totalDays)

        calculateLevel(systemController, days)
    }

    override fun resetSystem() {
        systemValue.currentValue = 0
    }

    override fun toString(): String {
        return "Level $name\n" +
                "Current Level: $systemValue\n\n" +
                innerSystem
    }
}