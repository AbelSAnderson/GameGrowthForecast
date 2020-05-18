package systems

import growth.GrowthExpression
import kotlin.math.floor
import kotlin.math.ln

abstract class Level(
    level: Int,
    private val growthRate: GrowthExpression,
    val experienceCurrency: CurrencySystem,
    private val firstLevelExperience: Int
) {
    private var _oldLevel: Int? = null
    val oldLevel: Int
        get() = _oldLevel ?: level

    var level: Int = level
    set(value) {
        _oldLevel = value
        field = value
    }

    fun calculateLevel(systemController: SystemController, days: Int) {
        val newLevel = ln(experienceCurrency.value / firstLevelExperience) / ln(growthRate.runCalculation(systemController, days))

        level = floor(newLevel).toInt()
    }
}