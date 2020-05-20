package systems

import growth.GrowthExpression
import growth.SystemController
import kotlin.math.floor
import kotlin.math.ln

abstract class Level(
    val growthRate: GrowthExpression,
    val experienceCurrency: System,
    val firstLevelExperience: Int
) {

    fun calculateLevel(systemController: SystemController, days: Int): Int {
        val newLevel = ln(experienceCurrency.systemValue.currentValue.toDouble() / firstLevelExperience) / ln(growthRate.runCalculation(systemController, days))

        return floor(newLevel).toInt()
    }
}