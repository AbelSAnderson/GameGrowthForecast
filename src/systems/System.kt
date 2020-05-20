package systems

import growth.SystemController

interface System : Cloneable {
    val name: String
    var systemValue: Value

    fun performGrowth(systemController: SystemController, days: Int, totalDays: Int)

    fun calculateChanges(oldSystem: System): System

    fun resetSystem()

    public override fun clone(): System {
        return super.clone() as System
    }

    override fun toString(): String
}