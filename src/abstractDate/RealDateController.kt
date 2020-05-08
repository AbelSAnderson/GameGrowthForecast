package abstractDate

import growth.GrowthController
import java.time.YearMonth

/**
 * Calculates Growth over a year.
 *
 * @author Abel Anderson
 * @since 08/05/2020
 * @see performGrowth
 */
class RealDateController {

    /**
     * Performs Growth over a year.
     *
     * @param growthController Calculates growth over the time given.
     * @param showPerWeek Determines if the updates shown per week.
     * @param repeatFor Determines how many years to repeat this process.
     */
    fun performGrowth(growthController: GrowthController, showPerWeek: Boolean, repeatFor: Int = 1) {

        for (i in 0 until repeatFor) {
            println("\n\n****** Set ${i + 1} of $repeatFor Started ******\n\n")

            val oldGrowth = growthController.currentGrowth()

            for (z in 0 until 12) {
                if(showPerWeek) {
                    DateComposite(mutableListOf(YearMonth.of(2020, z + 1).lengthOfMonth(), 7), growthController)
                } else {
                    DateComposite(mutableListOf(YearMonth.of(2020, z + 1).lengthOfMonth()), growthController)
                }
            }

            println("Growth over 365 days:")
            println(growthController.calculateGrowth(oldGrowth))
            println("\n\n****** Set ${i + 1} of $repeatFor Completed ******\n\n")
        }
    }
}