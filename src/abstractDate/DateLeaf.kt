package abstractDate

import growth.GrowthController

class DateLeaf(growthController: GrowthController, dayAmount: Int) :
    DateUnit(growthController) {

    init {
        growthData = growthController.calculateGrowth(dayAmount.toDouble())
        println("Growth over $dayAmount day(s): \n$growthData")
    }
}