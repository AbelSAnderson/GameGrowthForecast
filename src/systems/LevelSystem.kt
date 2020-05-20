package systems

import growth.GrowthExpression
import growth.SystemController

class LevelSystem(
    override val name: String,
    override var systemValue: Value,
    growthRate: GrowthExpression,
    experienceCurrency: System,
    firstLevelExperience: Int
) :
    Level(
        growthRate,
        experienceCurrency,
        firstLevelExperience
    ), System {

    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        experienceCurrency.performGrowth(systemController, days, totalDays)

        calculateLevel(systemController, days)
    }

    override fun calculateChanges(oldSystem: System): LevelSystem {
        if (oldSystem !is LevelSystem) throw ClassCastException("Provided Class: ${oldSystem.javaClass.name} cannot be cast to LevelSystem")

        oldSystem.systemValue.currentValue = systemValue.currentValue
        experienceCurrency.calculateChanges(oldSystem.experienceCurrency)
        return oldSystem
    }

    override fun resetSystem() {
        systemValue.currentValue = 0
    }

    override fun clone(): LevelSystem {
        return LevelSystem(name, systemValue, growthRate, experienceCurrency.clone(), firstLevelExperience)
    }

    override fun toString(): String {
        return "Level $name\n" +
                "Current Level: $systemValue\n\n" +
                experienceCurrency
    }
}