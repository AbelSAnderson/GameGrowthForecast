package abstractDate

import growth.GrowthController
import java.time.YearMonth

class RealDateController {

    fun performGrowth(growthController: GrowthController, repeatFor: Int = 1) {

        for (i in 0 until repeatFor) {
            println("\n\n****** Set ${i + 1} of $repeatFor Started ******\n\n")

            val oldGrowth = growthController.currentGrowth()

            for (z in 0 until 12) {
                DateComposite(mutableListOf(YearMonth.of(2020, z + 1).lengthOfMonth(), 7), growthController)
            }

            println("Growth over 365 days:")
            println(growthController.calculateGrowth(oldGrowth))
            println("\n\n****** Set ${i + 1} of $repeatFor Completed ******\n\n")
        }
    }
}