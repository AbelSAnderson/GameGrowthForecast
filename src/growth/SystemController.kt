package growth

import systems.System

class SystemController(initialSystems: MutableList<System> = mutableListOf()) : Cloneable {

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

    fun calculateGrowth(oldSystemController: SystemController): SystemController {
        oldSystemController.systems.forEach {
            systems[it.key]?.calculateChanges(it.value)
        }

        return oldSystemController
    }

    override fun toString(): String {
        var summaryString = ""

        systems.forEach {
            summaryString += "\n${it.value}\n"
        }

        return summaryString
    }

    public override fun clone(): SystemController {
        val newCurrencyController = SystemController()

        systems.forEach { newCurrencyController.systems[it.key] = it.value.clone() }

        return newCurrencyController
    }

    fun getSystem(systemName: String): System {
        return systems[systemName] ?: throw NoSuchElementException("System could not be found - Please check the system name you provided")
    }

    fun getSystemValue(systemName: String): Number {
        return getSystem(systemName).systemValue.currentValue
    }
}