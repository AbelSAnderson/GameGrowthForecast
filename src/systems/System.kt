package systems

interface System : Cloneable {
    val name: String

    fun performGrowth(systemController: SystemController, days: Int, totalDays: Int)

    fun calculateChanges(oldSystem: System): System

    fun resetSystem()

    public override fun clone(): System {
        return super.clone() as System
    }

    override fun toString(): String
}