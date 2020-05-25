package growth

import systems.helpers.SystemInfoShell
import systems.interfaces.System

class SystemController(initialSystems: MutableList<System> = mutableListOf()) {

    private var systems: HashMap<String, System> = hashMapOf()
    private var totalDays: Int = 0

    init {
        initialSystems.forEach {
            systems[it.name] = it
        }
    }

    fun calculateGrowth(days: Int) {
        totalDays += days

        systems.forEach {
            it.value.performGrowth(this, days, totalDays)
        }
    }

    fun getSystem(systemName: String): System {
        return systems[systemName]
            ?: throw NoSuchElementException("System could not be found - Please check the system name you provided")
    }

    fun getSystemValue(systemName: String): Number {
        return getSystem(systemName).systemValue.currentValue
    }

    fun getSystemsShells(): MutableList<SystemInfoShell> {
        val systemShells = mutableListOf<SystemInfoShell>()

        systems.forEach {
            systemShells.add(it.value.convertToShell())
        }

        return systemShells
    }

    override fun toString(): String {
        var summaryString = ""

        systems.forEach {
            summaryString += "\n${it.value}\n"
        }

        return summaryString
    }
}