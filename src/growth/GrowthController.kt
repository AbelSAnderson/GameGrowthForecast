package growth

import systems.System

class GrowthController(systems: MutableList<System>) {
    private val systemController: SystemController =
        SystemController(systems)

    fun calculateGrowth(days: Int): SystemController {
        systemController.calculateGrowth(days)
        return systemController
    }

    fun calculateGrowth(oldGrowthData: SystemController): SystemController {
        return systemController.calculateGrowth(oldGrowthData)
    }

    fun currentGrowth(): SystemController {
        return systemController
    }
}