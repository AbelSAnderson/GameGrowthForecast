package abstractDate

import growth.GrowthController

class DateComposite(growthRateList: MutableList<Int>, growthController: GrowthController) :
    DateUnit(growthController) {

    private var dateList: MutableList<DateUnit> = mutableListOf()

    init {
        //Clone the List
        val clonedList = growthRateList.toMutableList()

        //Get Date Information out of the GrowthRateList
        val totalDays = clonedList.removeFirst()
        val overflowDays = totalDays % clonedList.first()
        val totalDayGroups = totalDays / clonedList.first()

        //Grab the Current Growth
        val currentGrowth = growthController.currentGrowth()

        //Loop through the Days and add them to the list
        if (clonedList.size > 1) {
            for (i in 0 until totalDayGroups) {
                dateList.add(DateComposite(clonedList, growthController))
            }
        } else {
            for (i in 0 until totalDayGroups) {
                dateList.add(DateLeaf(growthController, clonedList.first()))
            }
        }

        //Check for overflow
        if (overflowDays != 0) {
            dateList.add(DateLeaf(growthController, overflowDays))
        }

        //Calculate the Growth.GrowthData for the current AbstractDate Section
        growthData = growthController.calculateGrowth(currentGrowth)

        println("Growth over $totalDays day(s): \n$growthData")
    }

    override fun toString(): String {
        return ""
    }
}




