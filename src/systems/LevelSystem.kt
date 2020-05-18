package systems

import growth.GrowthExpression

class LevelSystem(
    override val name: String,
    level: Int,
    growthRate: GrowthExpression,
    experienceCurrency: CurrencySystem,
    firstLevelExperience: Int
) :
    Level(
        level,
        growthRate,
        experienceCurrency,
        firstLevelExperience
    ), System {

    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        experienceCurrency.performGrowth(systemController, days, totalDays)

        calculateLevel(systemController, days)
    }

    override fun calculateChanges(oldSystem: System): System {
        if (oldSystem !is LevelSystem) throw ClassCastException("Provided Class: ${oldSystem.javaClass.name} cannot be cast to LevelSystem")

        oldSystem.level = level
        experienceCurrency.calculateChanges(oldSystem.experienceCurrency)
        return oldSystem
    }

    override fun resetSystem() {
        level = 0
    }

    override fun toString(): String {
        return "Level $name\n" +
                "Old Level: $oldLevel\n" +
                "level(s) Gained: ${level - oldLevel}\n" +
                "Current Level: $level" +
                experienceCurrency
    }
}