package systems.interfaces

import growth.SystemController
import systems.helpers.SystemInfoShell
import systems.helpers.Value

interface System {
    val name: String
    var systemValue: Value

    fun performGrowth(systemController: SystemController, days: Int, totalDays: Int)

    fun resetSystem()

    fun convertToShell(): SystemInfoShell {
        return SystemInfoShell(
            name,
            systemValue.clone(),
            if (this is SubSystem) this.innerSystem.convertToShell() else null
        )
    }

    override fun toString(): String
}