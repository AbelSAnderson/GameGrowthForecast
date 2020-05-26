package growth

import systems.helpers.SystemInfoShellSave
import systems.interfaces.System

class GrowthController(systems: MutableList<System>) {
    private val systemController: SystemController = SystemController(systems)

    fun calculateGrowth(days: Int): SystemController {
        systemController.calculateGrowth(days)
        return systemController
    }

    fun calculateGrowth(systemInfoShellSave: SystemInfoShellSave): SystemInfoShellSave {
        systemInfoShellSave.calculateGrowth(systemController.getSystemsShells())
        return systemInfoShellSave
    }

    fun currentGrowth(): SystemInfoShellSave {
        return SystemInfoShellSave(systemController.getSystemsShells())
    }
}