package abstractDate

import growth.GrowthController
import growth.GrowthData

/**
 * Parent Class for DateComposite & DateLeaf
 *
 * @param growthController The growthController that performs growth calculations for this DateUnit
 *
 * @author Abel Anderson
 * @since 08/05/2020
 *
 * @see DateComposite
 * @see DateLeaf
 */
internal abstract class DateUnit(private val growthController: GrowthController) {
    var growthData: GrowthData? = null
}