package abstractDate

import growth.GrowthController


/**
 * The Leaf class used in the composite pattern by DateComposite.
 *
 * @param growthController Calculate growth from the dayAmount.
 * @param dayAmount The Amount of Days to calculate growth for.
 * @author Abel Anderson
 * @since 08/05/2020
 *
 * @see DateComposite
 */
internal class DateLeaf(growthController: GrowthController, dayAmount: Int) :
    DateUnit(growthController) {

    init {
        growthData = growthController.calculateGrowth(dayAmount.toDouble())
        println("Growth over $dayAmount day(s): \n$growthData")
    }
}