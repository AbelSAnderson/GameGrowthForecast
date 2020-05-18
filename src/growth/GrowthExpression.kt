package growth

import systems.SystemController

class GrowthExpression(private val growthFunction: (SystemController, Int) -> Double) {

    fun runCalculation(systemController: SystemController, days: Int) : Double {
        return growthFunction(systemController, days)
    }
}