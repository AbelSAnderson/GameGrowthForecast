package abstractDate

import growth.GrowthController
import growth.GrowthData

abstract class DateUnit(val growthController: GrowthController) {
    var growthData: GrowthData? = null
}