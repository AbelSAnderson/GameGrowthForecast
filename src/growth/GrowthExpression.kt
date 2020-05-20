package growth

class GrowthExpression(private val growthFunction: (SystemController, Int) -> Double) {

    fun runCalculation(systemController: SystemController, days: Int) : Double {
        return growthFunction(systemController, days)
    }
}