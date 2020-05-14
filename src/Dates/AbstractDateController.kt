package Dates

import Growth.GrowthController

/**
 * Lets you perform growth over an abstract amount of time. The amount of time you want to perform growth over can be specified in the growthRateList param.
 *
 * Say you wanted to see growth over 300 days, but with reports back every 30. You would simply provide the growthPeriod with a list of {300, 30}.
 *
 * You can further extends this list if you want, showing reports every 10 days as well, just make sure to keep in mind that the list is organized from greatest to smallest.
 *
 * @param growthPeriod Determines how often to show user progress over time.
 * @author Abel Anderson
 * @since 08/05/2020
 * @see performGrowth
 */
class AbstractDateController(var growthPeriod: MutableList<Int>) {

    /**
     * Performs Growth for the user. This will automatically print out the results for the user.
     *
     * @param growthController The GrowthController that determines how the growth is performed.
     * @param repeatFor Determines how long to repeat the growthPeriod provided.
     */
    fun performGrowth(growthController: GrowthController, repeatFor: Int = 1) {
        growthPeriod.sortDescending()

        for (i in 0 until repeatFor) {
            println("\n\n****** Set ${i + 1} of $repeatFor Started ******\n\n")

            if(growthPeriod.size > 1) {
                DateComposite(growthController, growthPeriod)
            } else {
                DateLeaf(growthController, growthPeriod.first())
            }

            println("\n\n****** Set ${i + 1} of $repeatFor Completed ******\n\n")
        }
    }
}