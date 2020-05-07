package abstractDate

import growth.GrowthController

class AbstractDateController(var growthRateList: MutableList<Int>) {

    var dateList: MutableList<DateUnit> = mutableListOf()

    fun performGrowth(growthController: GrowthController, repeatFor: Int = 1) {
        dateList = mutableListOf()

        for (i in 0 until repeatFor) {
            println("\n\n****** Set ${i + 1} of $repeatFor Started ******\n\n")

            if(growthRateList.size > 1) {
                dateList.add(DateComposite(growthRateList, growthController))
            } else {
                dateList.add(DateLeaf(growthController, growthRateList.first()))
            }

            println("\n\n****** Set ${i + 1} of $repeatFor Completed ******\n\n")
        }
    }
}