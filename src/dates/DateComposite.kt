package dates

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
internal class DateComposite(growthController: GrowthController, growthPeriod: MutableList<Int>) :
    DateUnit(growthController) {

    init {
        //Get Date Information out of the GrowthRateList
        val totalDays = growthPeriod.removeFirst()
        val overflowDays = totalDays % growthPeriod.first()
        val totalDayGroups = totalDays / growthPeriod.first()

        //Grab the Current Growth
        val currentGrowth = growthController.currentGrowth().clone()

        //Loop through the Days and add them to the list
        if (growthPeriod.size > 1) {
            for (i in 0 until totalDayGroups) {
                DateComposite( growthController, growthPeriod)
            }
        } else {
            for (i in 0 until totalDayGroups) {
                DateLeaf(growthController, growthPeriod.first())
            }
        }

        //Check for overflow
        if (overflowDays != 0) {
            DateLeaf(growthController, overflowDays)
        }

        //Calculate the Growth.GrowthData for the current AbstractDate Section
        val currencyController = growthController.calculateGrowth(currentGrowth)

        println(" --- Growth over $totalDays day(s) --- \n$currencyController")
    }
}