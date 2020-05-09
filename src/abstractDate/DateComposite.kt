package abstractDate

import growth.GrowthController

/**
 * Uses the Composite Pattern to calculate growth over a set amount of time.
 *
 * @param growthPeriod Determines how ofter to calculate user progress over time.
 * @param growthController Handles growth for the current time period.
 * @author Abel Anderson
 * @since 08/05/2020
 *
 * @see DateLeaf
 */
internal class DateComposite(growthPeriod: MutableList<Int>, growthController: GrowthController) :
    DateUnit(growthController) {

    init {
        //Clone the List
        val clonedList = growthPeriod.toMutableList()

        //Get Date Information out of the GrowthRateList
        val totalDays = clonedList.removeFirst()
        val overflowDays = totalDays % clonedList.first()
        val totalDayGroups = totalDays / clonedList.first()

        //Grab the Current Growth
        val currentGrowth = growthController.currentGrowth()

        //Loop through the Days and add them to the list
        if (clonedList.size > 1) {
            for (i in 0 until totalDayGroups) {
                DateComposite(clonedList, growthController)
            }
        } else {
            for (i in 0 until totalDayGroups) {
                DateLeaf(growthController, clonedList.first())
            }
        }

        //Check for overflow
        if (overflowDays != 0) {
            DateLeaf(growthController, overflowDays)
        }

        //Calculate the Growth.GrowthData for the current AbstractDate Section
        val growthData = growthController.calculateGrowth(currentGrowth)

        println("Growth over $totalDays day(s): \n$growthData")
    }
}