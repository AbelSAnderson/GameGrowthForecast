package systems

import growth.GrowthExpression

class PrestigeCurrencySystem(
    name: String,
    value: Double,
    growthRate: GrowthExpression,
    private val resetSystems: MutableList<System>,
    private val resetAfterDays: Int
) : CurrencySystem(name, value, growthRate) {
    override fun performGrowth(systemController: SystemController, days: Int, totalDays: Int) {
        super.performGrowth(systemController, days, totalDays)

        if ((totalDays % resetAfterDays) > days) {
            resetSystems.forEach { it.resetSystem() }
        }
    }
}