package systems.helpers

class SystemInfoShellSave(infoShells: MutableList<SystemInfoShell>) {

    val savedInfoShells: HashMap<String, SystemInfoShell> = hashMapOf()

    init{
        infoShells.forEach{
            savedInfoShells[it.name] = it
        }
    }

    fun calculateGrowth(infoShells: MutableList<SystemInfoShell>) {
        infoShells.forEach{
            savedInfoShells[it.name]?.calculateGrowth(it)
        }
    }

    override fun toString(): String {
        var output = ""

        savedInfoShells.forEach{
            output += "$it/n"
        }

        return output
    }
}