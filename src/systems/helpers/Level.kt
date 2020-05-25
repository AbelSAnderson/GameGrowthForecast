package systems.helpers

import growth.GrowthExpression
import growth.SystemController
import systems.interfaces.SubSystem
import systems.interfaces.System
import kotlin.math.floor
import kotlin.math.ln

abstract class Level(
    val growthRate: GrowthExpression,
    override val innerSystem: System,
    val firstLevelExperience: Int
) : SubSystem {

    fun calculateLevel(systemController: SystemController, days: Int): Int {
        val newLevel = ln(innerSystem.systemValue.currentValue.toDouble() / firstLevelExperience) / ln(growthRate.runCalculation(systemController, days))

        return floor(newLevel).toInt()
    }
}